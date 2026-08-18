package util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Reads source files for the compiler.
 * <p>
 * Windows editors — Notepad, and PowerShell's own {@code Set-Content -Encoding utf8}
 * — write a UTF-8 byte order mark. Neither lexer has a rule for it, so the file would
 * fail on its very first character with a token recognition error. Dropping it here
 * keeps every reader consistent.
 */
public final class Sources {

    private static final char BOM = '\uFEFF';

    private Sources() {}

    public static String read(Path file) throws IOException {
        return stripBom(Files.readString(file, StandardCharsets.UTF_8));
    }

    public static String stripBom(String text) {
        return (text != null && !text.isEmpty() && text.charAt(0) == BOM)
                ? text.substring(1)
                : text;
    }
}
