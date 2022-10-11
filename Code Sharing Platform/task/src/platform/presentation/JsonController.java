package platform.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import platform.business.Snippet;
import platform.business.SnippetService;

import java.util.Collection;
import java.util.Map;

@Controller
public class JsonController {

    @Autowired
    SnippetService snippetService;

    @PostMapping("/api/code/new")
    public ResponseEntity addNewJsonSnippet(@RequestBody Map<String, String> map) {
        Long id = snippetService.addSnippetToRepository(map.get("code"));
        return new ResponseEntity(Map.of(
                "id", String.valueOf(id)),
                HttpStatus.OK);
    }

    @GetMapping("/api/code/{id}")
    public ResponseEntity showJsonSnippetById(@PathVariable long id) {
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
