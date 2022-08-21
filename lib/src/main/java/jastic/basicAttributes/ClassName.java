package jastic.basicAttributes;

import jastic.Attribute;
import jastic.HTMLRenderer;

import java.util.Map;

public class ClassName implements Attribute {
    private final String value;

    public ClassName(String value){
        this.value = value;
    }

    @Override
    public String render(Map<String, Object> context, HTMLRenderer r) {
        return r.render(context, this);
    }

    public String getValue() {
        return value;
    }
}
