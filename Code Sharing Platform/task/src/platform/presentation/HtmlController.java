package platform.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import platform.business.SnippetService;

@Controller
public class HtmlController {

    @Autowired
    SnippetService snippetService;

    @GetMapping(path = "/code/new", produces = "text/html")
    public String addNewHtmlSnippetByForm() {
        return "HTML_FORM";
    }

    @GetMapping("/code/{id}")
    public String showHtmlSnippetById(Model model, @PathVariable long id) {
        model.addAttribute("snippet", snippetService.getSnippetFromRepository(id));
        return "Current";
    }

    @GetMapping("/code/latest")
    public String showLatestHtmlSnippets(Model model) {
        model.addAttribute("latestList", snippetService.getLatestSnippetsFromRepository());
        return "Latest";
    }

}
