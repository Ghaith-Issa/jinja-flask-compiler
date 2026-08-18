package ASTJinja2withHTMLandCSS.CSS.Factory;

import ASTJinja2withHTMLandCSS.CSS.*;
import ASTJinja2withHTMLandCSS.CSS.PropertiesName.*;

public class CSSPropertyFactory {

    public static CSSPropertyNameNode create(int line, String name) {
        return switch (name) {

            case "font-family" -> new FontFamilyPropertyNode(line);
            case "background" -> new BackgroundPropertyNode(line);
            case "background-color" -> new BackgroundColorPropertyNode(line);
            case "color" -> new ColorPropertyNode(line);

            case "padding" -> new PaddingPropertyNode(line);
            case "padding-top" -> new PaddingTopPropertyNode(line);
            case "padding-bottom" -> new PaddingBottomPropertyNode(line);

            case "margin" -> new MarginPropertyNode(line);
            case "margin-top" -> new MarginTopPropertyNode(line);
            case "margin-bottom" -> new MarginBottomPropertyNode(line);

            case "width" -> new WidthPropertyNode(line);
            case "height" -> new HeightPropertyNode(line);

            case "display" -> new DisplayPropertyNode(line);
            case "gap" -> new GapPropertyNode(line);
            case "flex-wrap" -> new FlexWrapPropertyNode(line);
            case "justify-content" -> new JustifyContentPropertyNode(line);

            case "text-align" -> new TextAlignPropertyNode(line);
            case "font-size" -> new FontSizePropertyNode(line);
            case "font-weight" -> new FontWeightPropertyNode(line);

            case "border" -> new BorderPropertyNode(line);
            case "border-radius" -> new BorderRadiusPropertyNode(line);
            case "box-shadow" -> new BoxShadowPropertyNode(line);

            case "text-decoration" -> new TextDecorationPropertyNode(line);
            case "cursor" -> new CursorPropertyNode(line);
            case "transform" -> new TransformPropertyNode(line);

            default -> new CSSPropertyNameNode(line, name);
        };
    }
}
