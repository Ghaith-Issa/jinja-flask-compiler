package semantic;

/**
 * The kinds of semantic error miniFlask reports.
 * <p>
 * {@link #UNDEFINED_VARIABLE} and {@link #SCOPE_ERROR} look alike but are not:
 * an undefined name exists nowhere in the program, while a scope error names
 * something that <em>was</em> declared, just not anywhere the use site can see.
 */
public enum ErrorType {

    UNDEFINED_VARIABLE("Undefined Variable"),
    TYPE_ERROR("Type Error"),
    SCOPE_ERROR("Scope Error"),
    TYPE_MISMATCH("Type Mismatch"),
    MISSING_FLASK_VARIABLE("Missing Flask Variable");

    private final String label;

    ErrorType(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
