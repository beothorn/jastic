package jastic.html.elements;

import jastic.html.Attribute;
import jastic.html.HTMLRenderable;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class Body extends PairedTag {

    public Body(final Attribute[] attributes, final HTMLRenderable[] childrenElements) {
        super("body", attributes, childrenElements);
    }

    @Override
    public String render(Map<String, Object> context, HTMLRenderer r) {
        return r.renderElementBody(context, this);
    }
}
