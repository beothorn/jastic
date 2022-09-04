package jastic.html.attributes;

import jastic.html.HTMLRenderer;

import java.util.Map;

public class Type extends AttributeValue {

    public Type(final String type) {
        super(type);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderAttributeType(context, this);
    }
}
