# Jastic

Static page rendering for java.

In development...

# Why

## Java native

No need to add another dependency, build tool and other complexities to the pipeline.

## Server side rendering

Simple solution for very simple websites. Need to only show some page with a value, use this together with jetty.

## Static website render

Generate websites or documentation with java.

# What

[ ] Html rendering

[ ] CSS rendering

[ ] RSS rendering

[ ] Strict Html rendering (compile time)

[ ] Dynamic analisys (runtime)

[ ] Tree diff

[ ] Published on maven central

# How

```java
package jastic;

import jastic.html.HTMLRenderer;
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
                        meta(attributes(charset(Charset.Name.UTF8)))
                ),
                body(
                        text("Hello, World!")
                )
        ));
        final String expected = """
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
```
