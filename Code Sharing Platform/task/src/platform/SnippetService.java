package platform;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SnippetService {

    SnippetRepository repository = new InMemorySnippetRepository();
    Snippet snippet = new Snippet();
    private int id = 0;

    public Snippet getSnippetFromRepository(int id) {
        return repository.retrieve(id);
    }

    public void addSnippetToRepository(int id, String code) {
        repository.save(id, new Snippet(code, generateDate()));
    }

    public String generateDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS"));
    }

    public Collection<Snippet> getLatestSnippetsFromRepository() {
         return repository.retrieveLatest();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
