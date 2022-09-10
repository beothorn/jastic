package jastic.html.elements;

import jastic.html.Attribute;
import jastic.html.HTMLRenderable;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class Span extends PairedTag {

    public Span(final Attribute[] attributes, final HTMLRenderable[] childrenElements) {
        super("span", attributes, childrenElements);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderElementSpan(context, this);
    }
}