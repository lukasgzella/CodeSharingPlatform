package platform.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.persistence.SnippetRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SnippetService {

    @Autowired
    private SnippetRepository repository;

    public Snippet getSnippetFromRepository(long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Long addSnippetToRepository(String code) {
        Snippet snippet = new Snippet(generateId(), code, generateDate());
        repository.save(snippet);
        return snippet.getId();
    }

    public Collection<Snippet> getLatestSnippetsFromRepository() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).
                sorted(new DateComparator()).
                limit(10).
                collect(Collectors.toList());
    }

    public String generateDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS"));
    }

    public Long generateId() {
        List<Snippet> snippets = new ArrayList<>();
        repository.findAll().forEach(snippets::add);
        return (long) snippets.size();
    }
}
