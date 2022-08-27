package jastic.html.elements;

import jastic.html.HTMLRenderable;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class Text implements HTMLRenderable {

    private final String value;

    public Text(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String render(Map<String, Object> context, HTMLRenderer r) {
        return r.renderElementText(context, this);
    }
}
