package jastic.html.elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextTest {

    @Test
    void escapeText() {
        Text text = new Text("<script> alert(\"evil&bad\"+'x') </script>");
        assertEquals("&lt;script&gt; alert(&quot;evil&amp;bad&quot;+&#39;x&#39;) &lt;/script&gt;", text.getValue());
    }

}
