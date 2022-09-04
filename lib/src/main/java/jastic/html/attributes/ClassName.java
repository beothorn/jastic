package jastic.html.attributes;

import jastic.html.HTMLRenderer;

import java.util.Map;

public class ClassName extends AttributeValue {
    public ClassName(final String value) {
        super(value);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderAttributeClassName(context, this);
    }

}
