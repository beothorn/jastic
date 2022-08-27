package jastic.html.attributes;

import jastic.html.Attribute;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class Charset implements Attribute {

    private final Name value;

    public Charset(Name value) {
        this.value = value;
    }

    @Override
    public String render(Map<String, Object> context, HTMLRenderer r) {
        return r.renderAttributeCharset(context, this);
    }

    public Name getValue() {
        return value;
    }

    public enum Name {UTF8, ISO8859}

}
