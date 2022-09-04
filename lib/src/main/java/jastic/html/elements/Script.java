package jastic.html.elements;

import jastic.html.Attribute;
import jastic.html.HTMLRenderable;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class Script extends PairedTag {

    public Script(final Attribute[] attributes, final HTMLRenderable[] childrenElements) {
        super("script", attributes, childrenElements);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderElementScript(context, this);
    }
}