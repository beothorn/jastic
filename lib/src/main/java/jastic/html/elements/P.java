package jastic.html.elements;

import jastic.html.Attribute;
import jastic.html.HTMLRenderable;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class P extends PairedTag {

    public P(final Attribute[] attributes, final HTMLRenderable[] childrenElements) {
        super("p", attributes, childrenElements);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderElementP(context, this);
    }
}