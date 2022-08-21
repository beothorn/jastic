package jastic.basicAttributes;

import jastic.Attribute;
import jastic.Renderer;

import java.util.Map;

public class ClassName implements Attribute {
    private String value;

    public ClassName(String value){
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
