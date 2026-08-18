package semantic;

import java.util.Comparator;

/** One reported problem, with enough context to point the user at the source. */
public class SemanticError implements Comparable<SemanticError> {

    /** Sorted the way a reader scans a report: by file, then down the file. */
    public static final Comparator<SemanticError> BY_LOCATION =
            Comparator.comparing((SemanticError e) -> e.file == null ? "" : e.file)
                    .thenComparingInt(e -> e.line);

    private final ErrorType type;
    private final String file;
    private final int line;
    private final String message;

    /** Optional "did you mean" style follow-up. May be null. */
    private final String hint;

    public SemanticError(ErrorType type, String file, int line, String message) {
        this(type, file, line, message, null);
    }

    public SemanticError(ErrorType type, String file, int line, String message, String hint) {
        this.type = type;
        this.file = file;
        this.line = line;
        this.message = message;
        this.hint = hint;
    }

    public ErrorType getType() { return type; }
    public String getFile()    { return file; }
    public int getLine()       { return line; }
    public String getMessage() { return message; }
    public String getHint()    { return hint; }

    @Override
    public int compareTo(SemanticError other) {
        return BY_LOCATION.compare(this, other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('[').append(type.label()).append("] ");
        if (file != null) out.append(file).append(':');
        out.append(line).append(" - ").append(message);
        if (hint != null) out.append("\n    hint: ").append(hint);
        return out.toString();
    }
}
