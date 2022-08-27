package jastic.html.elements;

import jastic.html.Attribute;
import jastic.html.HTMLRenderable;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class Html extends PairedTag {

    public Html(final Attribute[] attributes, final HTMLRenderable[] childrenElements) {
        super("html", attributes, childrenElements);
    }

    @Override
    public String render(Map<String, Object> context, HTMLRenderer r) {
        return r.renderElementHtml(context, this);
    }
}
