package jastic.html.elements;

import jastic.html.Attribute;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class Link extends SingleTag {

    public Link(final Attribute[] attributes) {
        super("link", attributes);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderElementLink(context, this);
    }
}
