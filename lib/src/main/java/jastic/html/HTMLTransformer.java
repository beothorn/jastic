package jastic.html;

import jastic.html.parser.HTMLParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class HTMLTransformer {

    public String toJava(String html) {
        Element root = Jsoup.parse(html).child(0);
        StringBuilder result = new StringBuilder();
        root.traverse(new HTMLParser(result));
        return result.toString();
    }
}
