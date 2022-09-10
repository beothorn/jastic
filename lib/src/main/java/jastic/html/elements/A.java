package jastic.html.elements;

import jastic.html.Attribute;
import jastic.html.HTMLRenderable;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class A extends PairedTag {

    public A(final Attribute[] attributes, final HTMLRenderable[] childrenElements) {
        super("a", attributes, childrenElements);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderElementA(context, this);
    }
}