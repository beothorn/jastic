package jastic.html.elements;

import jastic.html.Attribute;
import jastic.html.HTMLRenderable;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class NoScript extends PairedTag {

    public NoScript(final Attribute[] attributes, final HTMLRenderable[] childrenElements) {
        super("noscript", attributes, childrenElements);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderElementNoScript(context, this);
    }
}
