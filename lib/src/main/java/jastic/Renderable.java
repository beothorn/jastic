package jastic;

import java.util.Map;

public interface Renderable {
    String render(Map<String, Object> context, HTMLRenderer r);
}
