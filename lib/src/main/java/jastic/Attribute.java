package jastic;

import java.util.Map;

public interface Attribute {
    String render(Map<String, Object> context, Renderer r);
}
