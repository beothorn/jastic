package jastic.html.elements;

import jastic.html.HTMLRenderable;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class Br implements HTMLRenderable {
    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderElementBr(context, this);
    }
}