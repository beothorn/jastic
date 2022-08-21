package jastic.basicElements;

import jastic.Attribute;
import jastic.DomElement;
import jastic.Renderable;
import jastic.Renderer;

import java.util.Map;

public class Tag implements Renderable {
    private final String tag;
    private Attribute[] attributes;
    private Renderable[] childrenElements;

    public Tag(String tag, final Attribute[] attributes, final Renderable[] childrenElements) {
        this.tag = tag;
        this.attributes = attributes;
        this.childrenElements = childrenElements;
    }

    public String getTag() {
        return tag;
    }

    public Renderable[] getChildren() {
        return childrenElements;
    }
    @Override
    public String render(Map<String, Object> context, Renderer r) {
        return r.renderTag(context, attributes, tag, childrenElements);
    }

    public Attribute[] getAttributes() {
        return attributes;
    }
}
