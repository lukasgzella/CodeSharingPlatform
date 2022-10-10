package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {

    static String content = "++++++++this is random code snippet+++++++++";
    static String htmlContent = "<html>\n" +
            "<head>\n" +
            "    <title>Code</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <pre>\n" +
            content +
            "</pre>\n" +
            "</body>\n" +
            "</html>";

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @GetMapping(value = "/code", produces = MediaType.TEXT_HTML_VALUE)
    public String showHtmlContent() {
        return htmlContent;
    }

    @GetMapping("/api/code")
    public ResponseEntity showJsonContent() {
        return new ResponseEntity(Map.of("code", content), HttpStatus.OK);
    }


}
