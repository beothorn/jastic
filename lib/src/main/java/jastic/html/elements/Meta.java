package jastic.html.elements;

import jastic.html.Attribute;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class Meta extends SingleTag {

    public Meta(final Attribute[] attributes) {
        super("meta", attributes);
    }

    @Override
    public String render(Map<String, Object> context, HTMLRenderer r) {
        return r.renderElementMeta(context, this);
    }
}