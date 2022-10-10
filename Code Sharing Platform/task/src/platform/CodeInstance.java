package platform;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CodeInstance {
    String snippet;
    String date;
    String htmlSnippetWithDate;


    public CodeInstance(String snippet) {
        update(snippet);
    }
    void update(String snippet) {
        this.snippet = snippet;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        this.htmlSnippetWithDate = HTMLStringFiles.THEN_ADD_SNIPPET +
                snippet +
                HTMLStringFiles.THEN_ADD_DATE +
                date +
                HTMLStringFiles.END;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getHtmlSnippetWithDate() {
        return htmlSnippetWithDate;
    }

    public void setHtmlSnippetWithDate(String htmlSnippetWithDate) {
        this.htmlSnippetWithDate = htmlSnippetWithDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}