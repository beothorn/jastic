package jastic.basicElements;

import jastic.Renderable;
import jastic.Renderer;

import java.util.Map;

public class Text implements Renderable {

    private String value;

    public Text(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String render(Map<String, Object> context,  Renderer r) {
        return r.render(context, this);
    }
}
