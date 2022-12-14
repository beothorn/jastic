package jastic.html.elements;

import jastic.html.Attribute;
import jastic.html.HTMLRenderable;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class Title extends PairedTag {

    public Title(final Attribute[] attributes, final HTMLRenderable[] childrenElements) {
        super("title", attributes, childrenElements);
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderElementTitle(context, this);
    }
}
