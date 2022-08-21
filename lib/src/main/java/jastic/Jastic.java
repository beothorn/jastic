package jastic;

import jastic.basicAttributes.ClassName;
import jastic.basicAttributes.Id;
import jastic.basicElements.Body;
import jastic.basicElements.Html;
import jastic.basicElements.Tag;
import jastic.basicElements.Text;

public class Jastic {

    public static Attribute[] attributes(Attribute... attributes){
        return attributes;
    }

    public static Tag tag(String tag, Attribute[] attributes, Renderable... children){
        return new Tag(tag, attributes, children);
    }
    public static Tag tag(String tag, Renderable... children){
        return new Tag(tag, null, children);
    }

    public static Html html(Renderable... children){
        return new Html(null, children);
    }

    public static Body body(Renderable... children){
        return new Body(null, children);
    }

    public static Text text(String text){
        return new Text(text);
    }

    public static Id id(String id){
        return new Id(id);
    }

    public static ClassName className(String name){
        return new ClassName(name);
    }
}
