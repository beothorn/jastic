package jastic.html;

import java.util.Map;

public interface HTMLRenderable {
    String render(Map<String, Object> context, HTMLRenderer r);
}
