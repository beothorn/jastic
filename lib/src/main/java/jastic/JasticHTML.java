package jastic;

import jastic.html.Attribute;
import jastic.html.HTMLRenderable;
import jastic.html.attributes.Charset;
import jastic.html.attributes.ClassName;
import jastic.html.attributes.Id;
import jastic.html.elements.*;

public class JasticHTML {

    public static Attribute[] attributes(Attribute... attributes) {
        return attributes;
    }

    public static PairedTag tag(String tag, HTMLRenderable... children) {
        return tag(tag, new Attribute[0], children);
    }

    public static PairedTag tag(String tag, Attribute[] attributes, HTMLRenderable... children) {
        return new PairedTag(tag, attributes, children);
    }

    public static Html html(HTMLRenderable... children) {
        return html(new Attribute[0], children);
    }

    public static Html html(Attribute[] attributes, HTMLRenderable... children) {
        return new Html(attributes, children);
    }

    public static Body body(HTMLRenderable... children) {
        return body(new Attribute[0], children);
    }

    public static Body body(Attribute[] attributes, HTMLRenderable... children) {
        return new Body(attributes, children);
    }

    public static Head head(HTMLRenderable... children) {
        return head(new Attribute[0], children);
    }

    public static Head head(Attribute[] attributes, HTMLRenderable... children) {
        return new Head(attributes, children);
    }

    public static Title title(HTMLRenderable... children) {
        return title(new Attribute[0], children);
    }

    public static Title title(Attribute[] attributes, HTMLRenderable... children) {
        return new Title(attributes, children);
    }

    public static Meta meta(Attribute[] attributes) {
        return new Meta(attributes);
    }

    public static Text text(String text) {
        return new Text(text);
    }

    public static Id id(String id) {
        return new Id(id);
    }

    public static ClassName className(String name) {
        return new ClassName(name);
    }

    public static Charset charset(Charset.Name charset) {
        return new Charset(charset);
    }
}
