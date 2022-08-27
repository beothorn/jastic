package jastic.html.attributes;

import jastic.html.HTMLRenderer;

import java.util.Map;

public class ClassName extends AttributeValue {
    public ClassName(String value) {
        super(value);
    }

    @Override
    public String render(Map<String, Object> context, HTMLRenderer r) {
        return r.renderAttributeClassName(context, this);
    }

}
