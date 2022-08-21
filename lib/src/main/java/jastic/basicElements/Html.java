package jastic.basicElements;

import jastic.Attribute;
import jastic.DomElement;
import jastic.Renderable;
import jastic.HTMLRenderer;

import java.util.Map;

public class Html implements DomElement {
    private final Attribute[] attributes;
    private final Renderable[] childrenElements;

    public Html(final Attribute[] attributes, final Renderable[] childrenElements) {
        this.attributes = attributes;
        this.childrenElements = childrenElements;
    }

    @Override
    public Attribute[] getAttributes() {
        return attributes;
    }

    public Renderable[] getChildren() {
        return childrenElements;
    }

    @Override
    public String render(Map<String, Object> context, HTMLRenderer r) {
        return r.render(context, this);
    }
}
