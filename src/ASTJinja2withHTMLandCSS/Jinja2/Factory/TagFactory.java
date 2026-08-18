package ASTJinja2withHTMLandCSS.Jinja2.Factory;
import ASTJinja2withHTMLandCSS.Jinja2.*;
import ASTJinja2withHTMLandCSS.Jinja2.TagsName.*;
import ASTJinja2withHTMLandCSS.Jinja2.VoidTagsName.*;

public class TagFactory {
    public static TagNameNode createTag(int line, String name) {
        return switch (name) {
            case "html" -> new HtmlTagNode(line);
            case "head" -> new HeadTagNode(line);
            case "body" -> new BodyTagNode(line);
            case "title" -> new TitleTagNode(line);
            case "div" -> new DivTagNode(line);
            case "a" -> new ATagNode(line);
            case "p" -> new PTagNode(line);
            case "h1" -> new H1TagNode(line);
            case "h2" -> new H2TagNode(line);
            case "h3" -> new H3TagNode(line);
            case "h4" -> new H4TagNode(line);
            case "h5" -> new H5TagNode(line);
            case "h6" -> new H6TagNode(line);
            case "form" -> new FormTagNode(line);
            case "label" -> new LabelTagNode(line);
            case "button" -> new ButtonTagNode(line);
            case "textarea" -> new TextareaTagNode(line);
            case "span" -> new SpanTagNode(line);
            case "ul" -> new UlTagNode(line);
            case "li" -> new LiTagNode(line);
            default -> new TagNameNode(line, name);
        };
    }

    public static VoidTagNameNode createVoidTag(int line, String name) {
        return switch (name) {
            case "meta" -> new MetaTagNode(line);
            case "link" -> new LinkTagNode(line);
            case "img" -> new ImgTagNode(line);
            case "input" -> new InputTagNode(line);
            default -> new VoidTagNameNode(line, name);
        };
    }
}
