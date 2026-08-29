package FlaskStatement;

import java.util.List;

public class GlobalStatement extends Statement {
    private final List<String> names;

    public GlobalStatement(int line, List<String> names) {
        super(line);
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }
}
