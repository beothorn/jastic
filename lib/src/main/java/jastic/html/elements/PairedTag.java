package jastic.html.elements;

import jastic.html.Attribute;
import jastic.html.DomElement;
import jastic.html.HTMLRenderable;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class PairedTag implements DomElement {
    private final String tag;
    private final Attribute[] attributes;
    private final HTMLRenderable[] childrenElements;

    public PairedTag(final String tag, final Attribute[] attributes, final HTMLRenderable[] childrenElements) {
        this.tag = tag;
        this.attributes = attributes;
        this.childrenElements = childrenElements;
    }

    public HTMLRenderable[] getChildren() {
        return childrenElements;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderPairedTag(context, attributes, this, childrenElements);
    }

    public Attribute[] getAttributes() {
        return attributes;
    }
}
