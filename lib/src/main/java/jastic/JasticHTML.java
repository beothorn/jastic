package jastic;

import jastic.html.Attribute;
import jastic.html.HTMLRenderable;
import jastic.html.attributes.*;
import jastic.html.elements.*;

public class JasticHTML {

    public static Attribute[] attributes(final Attribute... attributes) {
        return attributes;
    }

    public static PairedTag tag(final String tag, final HTMLRenderable... children) {
        return tag(tag, new Attribute[0], children);
    }

    public static PairedTag tag(final String tag, final Attribute[] attributes, final HTMLRenderable... children) {
        return new PairedTag(tag, attributes, children);
    }

    public static Html html(final HTMLRenderable... children) {
        return html(new Attribute[0], children);
    }

    public static Html html(final Attribute[] attributes, final HTMLRenderable... children) {
        return new Html(attributes, children);
    }

    public static Body body(final HTMLRenderable... children) {
        return body(new Attribute[0], children);
    }

    public static Body body(final Attribute[] attributes, final HTMLRenderable... children) {
        return new Body(attributes, children);
    }

    public static Head head(final HTMLRenderable... children) {
        return head(new Attribute[0], children);
    }

    public static Head head(final Attribute[] attributes, final HTMLRenderable... children) {
        return new Head(attributes, children);
    }

    public static Div div(final HTMLRenderable... children) {
        return div(new Attribute[0], children);
    }

    public static Div div(final Attribute[] attributes, final HTMLRenderable... children) {
        return new Div(attributes, children);
    }

    public static Script script(final HTMLRenderable... children) {
        return script(new Attribute[0], children);
    }

    public static Script script(final Attribute[] attributes, final HTMLRenderable... children) {
        return new Script(attributes, children);
    }

    public static NoScript noScript(final HTMLRenderable... children) {
        return noScript(new Attribute[0], children);
    }

    public static NoScript noScript(final Attribute[] attributes, final HTMLRenderable... children) {
        return new NoScript(attributes, children);
    }

    public static Title title(final HTMLRenderable... children) {
        return title(new Attribute[0], children);
    }

    public static Title title(final Attribute[] attributes, final HTMLRenderable... children) {
        return new Title(attributes, children);
    }

    public static Meta meta(final Attribute[] attributes) {
        return new Meta(attributes);
    }

    public static Link link(final Attribute[] attributes) {
        return new Link(attributes);
    }

    public static Img img(final Attribute[] attributes) {
        return new Img(attributes);
    }

    public static Text text(final String text) {
        return new Text(text);
    }

    public static RawText rawText(final String text) {
        return new RawText(text);
    }

    public static Br br() {
        return new Br();
    }

    public static A a(final HTMLRenderable... children) {
        return a(new Attribute[0], children);
    }

    public static A a(final Attribute[] attributes, final HTMLRenderable... children) {
        return new A(attributes, children);
    }

    public static Span span(final HTMLRenderable... children) {
        return span(new Attribute[0], children);
    }

    public static Span span(final Attribute[] attributes, final HTMLRenderable... children) {
        return new Span(attributes, children);
    }

    public static P p(final HTMLRenderable... children) {
        return p(new Attribute[0], children);
    }

    public static P p(final Attribute[] attributes, final HTMLRenderable... children) {
        return new P(attributes, children);
    }

    public static H h(final int level, final HTMLRenderable... children) {
        return h(level, new Attribute[0], children);
    }

    public static H h(final int level, final Attribute[] attributes, final HTMLRenderable... children) {
        return new H(level, attributes, children);
    }

    public static Id id(final String id) {
        return new Id(id);
    }

    public static ClassName className(final String name) {
        return new ClassName(name);
    }

    public static Name name(final String name) {
        return new Name(name);
    }

    public static Content content(final String content) {
        return new Content(content);
    }

    public static Charset charset(final Charset.Name charset) {
        return new Charset(charset);
    }

    public static Rel rel(final String rel) {
        return new Rel(rel);
    }

    public static HRef href(final String href) {
        return new HRef(href);
    }

    public static Type type(final String type) {
        return new Type(type);
    }

    public static Src src(final String source) {
        return new Src(source);
    }
}
