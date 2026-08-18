package util;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Records parse errors instead of printing them.
 * <p>
 * ANTLR's default listener writes to the console and the run carries on, so a file
 * that failed to parse still ended with "0 errors" and a zero exit code. Collecting
 * them lets the driver report the count and fail properly.
 */
public class SyntaxErrorCollector extends BaseErrorListener {

    /** One parse error, with enough detail to point at the source. */
    public record SyntaxError(String file, int line, int column, String message) {
        @Override
        public String toString() {
            return "[Syntax Error] " + file + ":" + line + ":" + column + " - " + message;
        }
    }

    private final String file;
    private final List<SyntaxError> errors = new ArrayList<>();

    public SyntaxErrorCollector(String file) {
        this.file = file;
    }

    public List<SyntaxError> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String message,
                            RecognitionException e) {
        String token = (offendingSymbol instanceof Token t) ? " near '" + t.getText() + "'" : "";
        errors.add(new SyntaxError(file, line, charPositionInLine + 1, message + token));
    }
}
