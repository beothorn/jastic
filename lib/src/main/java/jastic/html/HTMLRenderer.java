package jastic.html;

import jastic.html.attributes.Charset;
import jastic.html.attributes.ClassName;
import jastic.html.attributes.Id;
import jastic.html.elements.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class HTMLRenderer {

    public static final String CONTEXT_STACK = "stack";

    public String render(HTMLRenderable... elements) {
        HashMap<String, Object> context = new HashMap<>();
        context.put("stack", new Stack<>());
        return render(context, elements);
    }

    public String render(Map<String, Object> context, HTMLRenderable[] elements) {
        return Arrays.stream(elements)
                .map(element -> element.render(context, this))
                .collect(Collectors.joining("\n"));
    }

    public String renderElementHtml(Map<String, Object> context, Html html) {
        return renderPairedTag(context, html.getAttributes(), html, html.getChildren());
    }

    public String renderElementHead(Map<String, Object> context, Head head) {
        return renderPairedTag(context, head.getAttributes(), head, head.getChildren());
    }

    public String renderElementMeta(Map<String, Object> context, Meta meta) {
        return renderSingleTag(context, meta.getAttributes(), meta);
    }

    public String renderElementBody(Map<String, Object> context, Body body) {
        return renderPairedTag(context, body.getAttributes(), body, body.getChildren());
    }

    public String renderElementTitle(Map<String, Object> context, Title title) {
        return renderPairedTag(context, title.getAttributes(), title, title.getChildren());
    }

    public String renderElementText(Map<String, Object> context, Text text) {
        Stack<DomElement> tags = (Stack<DomElement>) context.get(CONTEXT_STACK);
        int level = tags.size();
        return "\t".repeat(level) + text.getValue();
    }

    public String renderPairedTag(Map<String, Object> context, Attribute[] attributes, DomElement tag, HTMLRenderable[] children) {
        Stack<DomElement> tags = (Stack<DomElement>) context.get(CONTEXT_STACK);
        int level = tags.size();
        tags.push(tag);
        String renderedChildren = "";
        if (children.length > 0) {
            renderedChildren = "\n" + render(context, children) + "\n";
        }
        String renderedAttributes = render(context, attributes);
        tags.pop();
        return "\t".repeat(level) + "<" + tag.getTag() + renderedAttributes + ">"
                + renderedChildren
                + "\t".repeat(level) + "</" + tag.getTag() + ">";
    }

    public String renderSingleTag(Map<String, Object> context, Attribute[] attributes, DomElement tag) {
        Stack<DomElement> tags = (Stack<DomElement>) context.get(CONTEXT_STACK);
        int level = tags.size();
        tags.push(tag);
        String renderedAttributes = render(context, attributes);
        tags.pop();
        return "\t".repeat(level) + "<" + tag.getTag() + renderedAttributes + " />";
    }

    public String renderAttributeId(Map<String, Object> context, Id id) {
        return "id=\"" + id.getValue() + "\"";
    }

    public String renderAttributeClassName(Map<String, Object> context, ClassName className) {
        return "class=\"" + className.getValue() + "\"";
    }

    public String renderAttributeCharset(Map<String, Object> context, Charset charset) {
        String charsetString = switch (charset.getValue()) {
            case UTF8 -> "UTF-8";
            case ISO8859 -> "ISO-8859-1";
        };
        return "charset=\"" + charsetString + "\"";
    }

    private String render(Map<String, Object> context, Attribute[] attributes) {
        if (attributes.length == 0) return "";
        return " " + Arrays.stream(attributes)
                .map(element -> element.render(context, this))
                .collect(Collectors.joining(" "));
    }
}