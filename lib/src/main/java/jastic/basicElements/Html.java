package jastic.basicElements;

import jastic.Attribute;
import jastic.DomElement;
import jastic.Renderable;
import jastic.Renderer;

import java.util.Map;

public class Html implements DomElement {
    private Attribute[] attributes;
    private Renderable[] childrenElements;

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
    public String render(Map<String, Object> context, Renderer r) {
        return r.render(context, this);
    }
}
