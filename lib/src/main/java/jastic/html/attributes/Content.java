package jastic.html.attributes;

import jastic.html.HTMLRenderer;

import java.util.Map;

public class Content extends AttributeValue {

    public Content(final String content) {
        super(content);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderAttributeContent(context, this);
    }
}
