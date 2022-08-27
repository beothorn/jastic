package jastic.basicElements;

import jastic.HTMLRenderer;
import jastic.Renderable;

import java.util.Map;

public class Text implements Renderable {

    private final String value;

    public Text(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String render(Map<String, Object> context, HTMLRenderer r) {
        return r.render(context, this);
    }
}
