package jastic.html.elements;

import jastic.html.Attribute;
import jastic.html.HTMLRenderable;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class Div extends PairedTag {

    public Div(final Attribute[] attributes, final HTMLRenderable[] childrenElements) {
        super("div", attributes, childrenElements);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderElementDiv(context, this);
    }
}