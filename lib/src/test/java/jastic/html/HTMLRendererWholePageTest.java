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
                        meta(attributes(name("viewport"), content("width=device-width, initial-scale=1"))),
                        link(attributes(rel("stylesheet"), href("/styles.css"), type("text/css")))
                ),
                body(
                        attributes(
                                id("hello-body")
                        ),
                        div(
                                attributes(
                                        id("container")
                                ),
                                script(
                                        rawText("console.log('hello')")
                                ),
                                noScript(
                                        text("Please enable JavaScript to view")
                                ),
                                text("Hello, World!")
                        )
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
                		<link rel="stylesheet" href="/styles.css" type="text/css" />
                	</head>
                	<body id="hello-body">
                		<div id="container">
                			<script>
                				console.log('hello')
                			</script>
                			<noscript>Please enable JavaScript to view</noscript>
                			Hello, World!
                		</div>
                	</body>
                </html>""";
        Assertions.assertEquals(expected, actual);
    }
}
