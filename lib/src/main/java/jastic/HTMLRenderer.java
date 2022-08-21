package jastic;

import jastic.basicAttributes.ClassName;
import jastic.basicAttributes.Id;
import jastic.basicElements.Body;
import jastic.basicElements.Html;
import jastic.basicElements.Tag;
import jastic.basicElements.Text;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HTMLRenderer {

    public String render(Html html) {
        return render(Map.of(), html);
    }

    public String render(Map<String, Object> context, Html html) {
        return renderTag(context, html.getAttributes(), "html", html.getChildren());
    }

    public String render(Body body) {
        return render(Map.of(), body);
    }

    public String render(Map<String, Object> context, Body body) {
        return renderTag(context, body.getAttributes(), "body", body.getChildren());
    }

    public String render(Text text) {
        return render(Map.of(), text);
    }

    public String render(Map<String, Object> context, Text text) {
        int level = 0;
        if(context.containsKey("level")){
            level = (int) context.get("level");
        }
        return "\t".repeat(level) + text.getValue();
    }

    public String render(Renderable[] elements) {
        return render(Map.of(), elements);
    }

    public String render(Map<String, Object> context, Renderable[] elements) {
        return Arrays.stream(elements)
                .map(element -> element.render(context, this))
                .collect(Collectors.joining());
    }

    public String render(Tag tag) {
        return renderTag(Map.of(), tag.getAttributes(), tag.getTag(), tag.getChildren());
    }

    public String render(Map<String, Object> context, Attribute[] attributes){
        if(attributes == null) return "";
        return " " + Arrays.stream(attributes)
            .map(element -> element.render(context, this))
            .collect(Collectors.joining(" "));
    }

    public String renderTag(Map<String, Object> context, Attribute[] attributes, String tag, Renderable[] children) {
        int level = 0;
        if(context.containsKey("level")){
            level = (int) context.get("level");
        }
        Map<String, Object> newContext = new LinkedHashMap<>(context);
        newContext.put("level", level+1);
        String renderedChildren = render(newContext, children);
        String renderedAttributes = render(newContext, attributes);
        return "\t".repeat(level) + "<" + tag + renderedAttributes + ">\n"
                + renderedChildren + "\n"
                +"\t".repeat(level) + "</" + tag + ">";
    }

    public String render(Id id) {
        return render(Map.of(), id);
    }

    public String render(ClassName className) {
        return render(Map.of(), className);
    }

    public String render(Map<String, Object> context, Id id) {
        return "id=\""+id.getValue()+"\"";
    }

    public String render(Map<String, Object> context, ClassName className) {
        return "class=\""+className.getValue()+"\"";
    }
}