package jastic.html.attributes;

import jastic.html.HTMLRenderer;

import java.util.Map;

public class Src extends AttributeValue {

    public Src(final String source) {
        super(source);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderAttributeSrc(context, this);
    }
}
