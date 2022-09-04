package jastic.html.elements;

import jastic.html.Attribute;
import jastic.html.DomElement;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class SingleTag implements DomElement {
    private final String tag;
    private final Attribute[] attributes;

    public SingleTag(final String tag, final Attribute[] attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderSingleTag(context, attributes, this);
    }

    public Attribute[] getAttributes() {
        return attributes;
    }
}
