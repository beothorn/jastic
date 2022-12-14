package jastic.html.elements;

import jastic.html.Attribute;
import jastic.html.HTMLRenderable;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class Head extends PairedTag {

    public Head(final Attribute[] attributes, final HTMLRenderable[] childrenElements) {
        super("head", attributes, childrenElements);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderElementHead(context, this);
    }
}
