package platform.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.business.Snippet;

@Repository
public interface SnippetRepository extends CrudRepository<Snippet, Long> {
}
