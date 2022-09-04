package jastic.html.attributes;

import jastic.html.HTMLRenderer;

import java.util.Map;

public class Rel extends AttributeValue {

    public Rel(final String relation) {
        super(relation);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderAttributeRel(context, this);
    }
}
