package jastic.html.attributes;

import jastic.html.HTMLRenderer;

import java.util.Map;

public class Name extends AttributeValue {

    public Name(final String value) {
        super(value);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderAttributeName(context, this);
    }
}
