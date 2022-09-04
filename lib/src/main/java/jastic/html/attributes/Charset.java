package jastic.html.attributes;

import jastic.html.Attribute;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class Charset implements Attribute {

    private final Name value;

    public Charset(final Name value) {
        this.value = value;
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderAttributeCharset(this);
    }

    public Name getValue() {
        return value;
    }

    public enum Name {UTF8, ISO8859}

}
