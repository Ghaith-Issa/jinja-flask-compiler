package ASTJinja2withHTMLandCSS.Jinja2.Factory;
import ASTJinja2withHTMLandCSS.Jinja2.*;
import ASTJinja2withHTMLandCSS.Jinja2.AttributesName.*;

public class AttributeFactory {
    public static AttributeNameNode create(int line, String name) {
        return switch (name) {
            case "charset" -> new CharsetAttrNode(line);
            case "style" -> new StyleAttrNode(line);
            case "alt" -> new AltAttrNode(line);
            case "href" -> new HrefAttrNode(line);
            case "src" -> new SrcAttrNode(line);
            case "rel" -> new RelAttrNode(line);
            case "class" -> new ClassAttrNode(line);
            case "method" -> new MethodAttrNode(line);
            case "type" -> new TypeAttrNode(line);
            case "name" -> new NameAttrNode(line);
            case "step" -> new StepAttrNode(line);
            case "required" -> new RequiredAttrNode(line);
            default -> new AttributeNameNode(line, name);
        };
    }
}
