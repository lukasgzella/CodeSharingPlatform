package platform;

import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SnippetRepository {

    public void save(int id, Snippet snippet);
    public Snippet retrieve(int id);
    public Collection<Snippet> retrieveLatest();

}
