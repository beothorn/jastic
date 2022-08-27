package jastic;

public interface DomElement extends Renderable {
    Attribute[] getAttributes();

    Renderable[] getChildren();
}
