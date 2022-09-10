package jastic.html;

import jastic.html.attributes.Charset;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static jastic.JasticHTML.*;

public class HTMLRendererWholePageTest {

    @Test
    void render() throws URISyntaxException, IOException {
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
                                text("Hello, World!"),
                                br(),
                                text("Hello, World!"),
                                a(
                                        attributes(
                                                href("#")
                                        ),
                                        text("Click here!")
                                ),
                                img(
                                        attributes(
                                                className("images"),
                                                src("./img.png")
                                        )
                                ),
                                h(1,
                                        text("A title")
                                ),
                                h(2,
                                        text("A subtitle")
                                ),
                                p(
                                        text("Read this paragraph"),
                                        span(
                                                attributes(
                                                        className("important")
                                                ),
                                                text("carefully.")
                                        )
                                )
                        )
                )
        ));
        final String expected = Files.readString(Paths.get(getClass().getResource("/page.html").toURI())).trim();
        Assertions.assertEquals(expected, actual);
    }
}
