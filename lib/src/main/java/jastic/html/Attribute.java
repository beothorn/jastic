package jastic.html;

import java.util.Map;

public interface Attribute {
    String render(Map<String, Object> context, HTMLRenderer r);
}
