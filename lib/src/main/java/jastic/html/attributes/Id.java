package jastic.html.attributes;

import jastic.html.HTMLRenderer;

import java.util.Map;

public class Id extends AttributeValue {

    public Id(String value) {
        super(value);
    }

    @Override
    public String render(Map<String, Object> context, HTMLRenderer r) {
        return r.renderAttributeId(context, this);
    }
}
