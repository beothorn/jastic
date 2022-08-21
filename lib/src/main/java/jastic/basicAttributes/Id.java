package jastic.basicAttributes;

import jastic.Attribute;
import jastic.Renderer;

import java.util.Map;

public class Id implements Attribute {
    private String value;

    public Id(String value){
        this.value = value;
    }

    @Override
    public String render(Map<String, Object> context, Renderer r) {
        return r.render(context, this);
    }

    public String getValue() {
        return value;
    }
}
