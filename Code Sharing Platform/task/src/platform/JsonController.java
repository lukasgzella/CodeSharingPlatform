package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@Controller
public class JsonController {
    private int id = 0;

    @Autowired
    SnippetService snippetService;

    @PostMapping("/api/code/new")
    public ResponseEntity addNewJsonSnippet(@RequestBody Map<String, String> map) {
        snippetService.addSnippetToRepository(id, map.get("code"));
        return new ResponseEntity(Map.of(
                "id", String.valueOf(id++)),
                HttpStatus.OK);
    }

    @GetMapping("/api/code/{id}")
    public ResponseEntity showJsonSnippetById(@PathVariable int id) {
        Snippet snippet = snippetService.getSnippetFromRepository(id);
        return new ResponseEntity(Map.of(
                "code", snippet.getCode(), "date", snippet.getDate()),
                HttpStatus.OK);
    }

    @GetMapping("/api/code/latest")
    public @ResponseBody Collection<Snippet> showLatestJsonSnippets() {
        return snippetService.getLatestSnippetsFromRepository();
    }
}
