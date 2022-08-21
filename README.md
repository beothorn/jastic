# jastic

Static page rendering for java.

```java
HTMLRenderer r = new HTMLRenderer();
String staticPage = r.render(html(
        body(
                text("Hello, World!")
        )
));
```
