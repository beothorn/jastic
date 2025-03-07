package jastic.html;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

class HTMLToJasticTest {

    @Test
    void renderTag() throws URISyntaxException, IOException {
        final String simplePage = Files.readString(Paths.get(getClass().getResource("/htmlToJastic/simple.html").toURI())).trim();
        HTMLTransformer t = new HTMLTransformer();

        assertEquals("""
                html(
                \thead(
                \t\tmeta(attributes(charset("UTF-8")))
                \t)
                \tbody(
                \t)
                )
                """, t.toJava(simplePage));
    }

}
