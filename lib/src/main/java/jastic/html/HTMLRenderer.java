package jastic.html;

import jastic.html.attributes.*;
import jastic.html.elements.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class HTMLRenderer {

    public static final String CONTEXT_STACK = "stack";

    public String render(final HTMLRenderable... elements) {
        final HashMap<String, Object> context = new HashMap<>();
        context.put("stack", new Stack<>());
        return render(context, elements);
    }

    public String render(final Map<String, Object> context, final HTMLRenderable[] elements) {
        return Arrays.stream(elements)
                .map(element -> element.render(context, this))
                .collect(Collectors.joining("\n"));
    }

    public String renderElementHtml(final Map<String, Object> context, final Html html) {
        return renderPairedTag(context, html.getAttributes(), html, html.getChildren());
    }

    public String renderElementHead(final Map<String, Object> context, final Head head) {
        return renderPairedTag(context, head.getAttributes(), head, head.getChildren());
    }

    public String renderElementMeta(final Map<String, Object> context, final Meta meta) {
        return renderSingleTag(context, meta.getAttributes(), meta);
    }

    public String renderElementBody(final Map<String, Object> context, final Body body) {
        return renderPairedTag(context, body.getAttributes(), body, body.getChildren());
    }

    public String renderElementTitle(final Map<String, Object> context, final Title title) {
        return renderPairedTag(context, title.getAttributes(), title, title.getChildren());
    }

    public String renderElementLink(final Map<String, Object> context, final Link link) {
        return renderSingleTag(context, link.getAttributes(), link);
    }

    public String renderElementImg(final Map<String, Object> context, final Img img) {
        return renderSingleTag(context, img.getAttributes(), img);
    }

    public String renderElementDiv(final Map<String, Object> context, final Div div) {
        return renderPairedTag(context, div.getAttributes(), div, div.getChildren());
    }

    public String renderElementScript(final Map<String, Object> context, final Script script) {
        return renderPairedTag(context, script.getAttributes(), script, script.getChildren());
    }

    public String renderElementNoScript(final Map<String, Object> context, final NoScript noscript) {
        return renderPairedTag(context, noscript.getAttributes(), noscript, noscript.getChildren());
    }

    public String renderElementText(final Map<String, Object> context, final Text text) {
        final Stack<DomElement> tags = (Stack<DomElement>) context.get(CONTEXT_STACK);
        final int level = tags.size();
        return "\t".repeat(level) + text.getValue();
    }

    public String renderElementRawText(final Map<String, Object> context, final RawText rawText) {
        final Stack<DomElement> tags = (Stack<DomElement>) context.get(CONTEXT_STACK);
        final int level = tags.size();
        return "\t".repeat(level) + rawText.getValue();
    }

    public String renderElementBr(final Map<String, Object> context, final Br br) {
        final int level = ((Stack<DomElement>) context.get(CONTEXT_STACK)).size();
        return "\t".repeat(level) + "<br>";
    }

    public String renderElementA(final Map<String, Object> context, final A a) {
        return renderPairedTag(context, a.getAttributes(), a, a.getChildren());
    }

    public String renderElementP(final Map<String, Object> context, final P p) {
        return renderPairedTag(context, p.getAttributes(), p, p.getChildren());
    }

    public String renderElementSpan(final Map<String, Object> context, final Span span) {
        return renderPairedTag(context, span.getAttributes(), span, span.getChildren());
    }

    public String renderElementH(final Map<String, Object> context, final H h) {
        return renderPairedTag(context, h.getAttributes(), h, h.getChildren());
    }

    public String renderPairedTag(final Map<String, Object> context, final Attribute[] attributes, final DomElement tag, final HTMLRenderable[] children) {
        final Stack<DomElement> tags = (Stack<DomElement>) context.get(CONTEXT_STACK);
        final int level = tags.size();
        tags.push(tag);
        String renderedChildren = "";
        if (children.length > 0) {
            renderedChildren = "\n" + render(context, children) + "\n";
        }
        final String renderedAttributes = render(context, attributes);
        tags.pop();
        return "\t".repeat(level) + "<" + tag.getTag() + renderedAttributes + ">"
                + renderedChildren
                + "\t".repeat(level) + "</" + tag.getTag() + ">";
    }

    public String renderSingleTag(final Map<String, Object> context, final Attribute[] attributes, final DomElement tag) {
        final Stack<DomElement> tags = (Stack<DomElement>) context.get(CONTEXT_STACK);
        final int level = tags.size();
        tags.push(tag);
        final String renderedAttributes = render(context, attributes);
        tags.pop();
        return "\t".repeat(level) + "<" + tag.getTag() + renderedAttributes + " />";
    }

    public String renderAttributeId(final Map<String, Object> context, final Id id) {
        return "id=\"" + id.getValue() + "\"";
    }

    public String renderAttributeClassName(final Map<String, Object> context, final ClassName className) {
        return "class=\"" + className.getValue() + "\"";
    }

    public String renderAttributeName(final Map<String, Object> context, final Name className) {
        return "name=\"" + className.getValue() + "\"";
    }

    public String renderAttributeSrc(final Map<String, Object> context, final Src source) {
        return "src=\"" + source.getValue() + "\"";
    }

    public String renderAttributeContent(final Map<String, Object> context, final Content content) {
        return "content=\"" + content.getValue() + "\"";
    }

    public String renderAttributeCharset(final Charset charset) {
        final String charsetString = switch (charset.getValue()) {
            case UTF8 -> "UTF-8";
            case ISO8859 -> "ISO-8859-1";
        };
        return "charset=\"" + charsetString + "\"";
    }

    public String renderAttributeRel(final Map<String, Object> context, final Rel relation) {
        return "rel=\"" + relation.getValue() + "\"";
    }

    public String renderAttributeHRef(final Map<String, Object> context, final HRef href) {
        return "href=\"" + href.getValue() + "\"";
    }

    public String renderAttributeType(final Map<String, Object> context, final Type type) {
        return "type=\"" + type.getValue() + "\"";
    }

    private String render(final Map<String, Object> context, final Attribute[] attributes) {
        if (attributes.length == 0) return "";
        return " " + Arrays.stream(attributes)
                .map(element -> element.render(context, this))
                .collect(Collectors.joining(" "));
    }
}