package jastic.html.attributes;

import jastic.html.Attribute;

public abstract class AttributeValue implements Attribute {
    
    private final String value;

    public AttributeValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
