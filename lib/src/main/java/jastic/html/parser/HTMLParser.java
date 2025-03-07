package jastic.html.parser;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.NodeVisitor;
import java.util.List;

public class HTMLParser implements NodeVisitor {

    private final StringBuilder result;
    int indent = 0; // Track indentation

    public HTMLParser(StringBuilder result) {
        this.result = result;
    }

    @Override
    public void head(Node node, int i) {
        if (node instanceof Element) {
            Element element = (Element) node;


            // Add indentation
            result.append("\t".repeat(indent));

            result.append(element.tagName()).append("(");

            List<Attribute> attributes = element.attributes().asList();
            if (!attributes.isEmpty()) {
                result.append("attributes(");
                attributes.forEach(attr ->
                        result.append(attr.getKey())
                                .append("(\"")
                                .append(attr.getValue())
                                .append("\")")
                );
                result.append(")");
            }


            // Self-closing or normal tag
            if (element.childNodeSize() == 0) {
                result.append(")\n");
            } else {
                result.append("\n");
            }

            indent++; // Increase indentation
        }
    }

    @Override
    public void tail(Node node, int depth) {
        if (node instanceof Element) {
            Element element = (Element) node;
            indent--; // Decrease indentation

            // Close tag if not self-closing
            if (element.childNodeSize() > 0) {
                result.append("\t".repeat(indent))
                        .append(")\n");
            }
        }
    }
}
