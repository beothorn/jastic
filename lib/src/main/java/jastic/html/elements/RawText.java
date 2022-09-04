package jastic.html.elements;

import jastic.html.HTMLRenderable;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class RawText implements HTMLRenderable {

    private final String value;

    public RawText(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderElementRawText(context, this);
    }
}
