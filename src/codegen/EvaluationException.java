package codegen;

/** A miniFlask program error hit while the generator was executing it. */
public class EvaluationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final int line;

    public EvaluationException(String message) {
        this(message, 0);
    }

    public EvaluationException(String message, int line) {
        super(message);
        this.line = line;
    }

    public int getLine() {
        return line;
    }

    @Override
    public String getMessage() {
        return (line > 0) ? "line " + line + ": " + super.getMessage() : super.getMessage();
    }
}
