package jastic;

import jastic.html.HTMLRenderer;
import jastic.html.attributes.Charset;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static jastic.JasticHTML.*;

public class HTMLRendererWholePageTest {

    @Test
    void render() {
        HTMLRenderer r = new HTMLRenderer();
        String actual = r.render(html(
                head(
                        meta(attributes(charset(Charset.Name.UTF8)))
                ),
                body(
                        text("Hello, World!")
                )
        ));
        String expected = """
                <html>
                	<head>
                		<meta charset="UTF-8" />
                	</head>
                	<body>
                		Hello, World!
                	</body>
                </html>""";
        Assertions.assertEquals(expected, actual);
    }
}
