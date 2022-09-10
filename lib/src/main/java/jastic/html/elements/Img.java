package jastic.html.elements;

import jastic.html.Attribute;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class Img extends SingleTag {

    public Img(final Attribute[] attributes) {
        super("img", attributes);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderElementImg(context, this);
    }
}