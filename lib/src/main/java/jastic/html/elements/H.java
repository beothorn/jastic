package jastic.html.elements;

import jastic.html.Attribute;
import jastic.html.HTMLRenderable;
import jastic.html.HTMLRenderer;

import java.util.Map;

public class H extends PairedTag {

    private final int level;

    public H(final int level, final Attribute[] attributes, final HTMLRenderable[] childrenElements) {
        super("h" + level, attributes, childrenElements);
        this.level = level;
    }

    @Override
    public String render(final Map<String, Object> context, final HTMLRenderer r) {
        return r.renderElementH(context, this);
    }

    public int getLevel() {
        return level;
    }
}