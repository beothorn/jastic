package jastic.basicElements;

import jastic.Attribute;
import jastic.HTMLRenderer;
import jastic.Renderable;

import java.util.Map;

public class Html extends Tag {

    public Html(final Attribute[] attributes, final Renderable[] childrenElements) {
        super("html", attributes, childrenElements);
    }

    @Override
    public String render(Map<String, Object> context, HTMLRenderer r) {
        return r.render(context, this);
    }
}
