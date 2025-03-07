package jastic.html;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

class HTMLToJasticTest {

    @Test
    void fromHtmlToJastic() throws URISyntaxException, IOException {
        final String simplePage = Files.readString(Paths.get(getClass().getResource("/htmlToJastic/simple.html").toURI())).trim();
        HTMLTransformer t = new HTMLTransformer();

        String javaCode = t.toJava(simplePage);
        assertEquals("""
                html(
                \thead(
                \t\tmeta(attributes(charset("UTF-8")))
                \t)
                \tbody(
                \t)
                )
                """, javaCode);
    }

}
