package jastic.html;

public interface DomElement extends HTMLRenderable {
    Attribute[] getAttributes();

    String getTag();
}
