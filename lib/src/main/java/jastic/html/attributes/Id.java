package jastic.html.attributes;

import jastic.html.HTMLRenderer;

import java.util.Map;

public class Id extends AttributeValue {

    public Id(final String value) {
        super(value);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderAttributeId(context, this);
    }
}
