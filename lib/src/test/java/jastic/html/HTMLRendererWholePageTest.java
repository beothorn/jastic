package jastic.html;

import jastic.html.attributes.Charset;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static jastic.JasticHTML.*;

public class HTMLRendererWholePageTest {

    @Test
    void render() {
        final HTMLRenderer r = new HTMLRenderer();
        final String actual = r.render(html(
                head(
                        meta(attributes(charset(Charset.Name.UTF8))),
                        title(text("Hello")),
                        meta(attributes(name("viewport"), content("width=device-width, initial-scale=1")))
                ),
                body(
                        text("Hello, World!")
                )
        ));
        final String expected = """
                <html>
                	<head>
                		<meta charset="UTF-8" />
                		<title>
                			Hello
                		</title>
                		<meta name="viewport" content="width=device-width, initial-scale=1" />
                	</head>
                	<body>
                		Hello, World!
                	</body>
                </html>""";
        Assertions.assertEquals(expected, actual);
    }
}
