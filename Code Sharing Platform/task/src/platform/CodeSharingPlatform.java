package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {
    CodeInstance codeInstance = new CodeInstance("default snippet");

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @GetMapping("/api/code")
    public ResponseEntity showJsonContent() {
        return new ResponseEntity(Map.of(
                "code", codeInstance.getSnippet(),
                "date", codeInstance.getDate()),
                HttpStatus.OK);
    }

    @GetMapping(value = "/code", produces = MediaType.TEXT_HTML_VALUE)
    public String showHtmlContent() {
        return codeInstance.getHtmlSnippetWithDate();
    }

    @PostMapping("/api/code/new")
    public ResponseEntity showJsonContent2(@RequestBody Map<String, String> map) {
        codeInstance.update(map.get("code"));
        return new ResponseEntity("{}", HttpStatus.OK);
    }

    @GetMapping("/code/new")
    public String showHtmlForm() {
        return HTMLStringFiles.HTML_FORM;
    }
}
