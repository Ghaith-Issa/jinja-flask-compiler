package watch;

import java.io.IOException;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Watches a miniFlask project and reports when its sources change.
 * <p>
 * A generated site is static, so nothing updates itself once written: editing a
 * price in app.py leaves output/index.html showing the old one until the compiler
 * runs again. This is the piece that notices and triggers that rerun.
 */
public class ProjectWatcher implements AutoCloseable {

    /** Extensions that belong to the project, so editor temp files are ignored. */
    private static final Set<String> WATCHED_EXTENSIONS =
            Set.of(".py", ".html", ".jinja", ".css", ".js");

    /** Folders below the project root that are watched, plus the root itself. */
    private static final List<String> WATCHED_FOLDERS = List.of("templates", "static", "images");

    /**
     * One save fires several filesystem events, and editors often write through a
     * temporary file. Collecting events for this long turns that burst into one
     * rebuild.
     */
    private final long debounceMillis;

    private final Path projectDir;
    private final Consumer<Set<Path>> onChange;
    private final WatchService service;
    private final List<Path> registered = new ArrayList<>();

    private volatile boolean running = true;

    public ProjectWatcher(Path projectDir, Consumer<Set<Path>> onChange, long debounceMillis)
            throws IOException {
        this.projectDir = projectDir;
        this.onChange = onChange;
        this.debounceMillis = debounceMillis;
        this.service = FileSystems.getDefault().newWatchService();
        registerDirectories();
    }

    public List<Path> getRegisteredDirectories() {
        return registered;
    }

    private void registerDirectories() throws IOException {
        register(projectDir);
        for (String folder : WATCHED_FOLDERS) {
            Path directory = projectDir.resolve(folder);
            if (Files.isDirectory(directory)) register(directory);
        }
    }

    private void register(Path directory) throws IOException {
        directory.register(service,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);
        registered.add(directory);
    }

    // ============================================================

    /** Blocks, rebuilding on every change, until {@link #stop()} or an interrupt. */
    public void watch() throws InterruptedException {
        while (running) {
            WatchKey key;
            try {
                key = service.take();
            } catch (ClosedWatchServiceException e) {
                return;
            }

            Set<Path> changed = new LinkedHashSet<>();
            collect(key, changed);

            // Drain the rest of the burst before doing any work.
            WatchKey next;
            while ((next = pollNext()) != null) {
                collect(next, changed);
            }

            if (!changed.isEmpty()) onChange.accept(changed);
        }
    }

    private WatchKey pollNext() {
        try {
            return service.poll(debounceMillis, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ClosedWatchServiceException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    private void collect(WatchKey key, Set<Path> changed) {
        Path directory = (Path) key.watchable();
        for (WatchEvent<?> event : key.pollEvents()) {
            if (event.kind() == StandardWatchEventKinds.OVERFLOW) continue;
            Path file = directory.resolve((Path) event.context());
            if (isRelevant(file)) changed.add(file);
        }
        key.reset();
    }

    private boolean isRelevant(Path file) {
        String name = file.getFileName().toString().toLowerCase();
        if (name.startsWith("~") || name.startsWith(".")) return false;
        return WATCHED_EXTENSIONS.stream().anyMatch(name::endsWith);
    }

    public void stop() {
        running = false;
        close();
    }

    @Override
    public void close() {
        try {
            service.close();
        } catch (IOException ignored) {
            // nothing useful to do while shutting down
        }
    }

    /** Files the watcher would react to, for reporting what is being watched. */
    public List<Path> watchedFiles() {
        List<Path> files = new ArrayList<>();
        for (Path directory : registered) {
            try (Stream<Path> entries = Files.list(directory)) {
                entries.filter(Files::isRegularFile).filter(this::isRelevant).forEach(files::add);
            } catch (IOException ignored) {
                // an unreadable directory simply contributes nothing
            }
        }
        return files;
    }
}
