package platform;

import java.util.*;

public class InMemorySnippetRepository implements SnippetRepository {
    private Map<Integer, Snippet> mapOfSnippets = new HashMap<>();
    private Stack<Snippet> latest10 = new SizedStack<>(10);

    @Override
    public void save(int id, Snippet snippet) {
        mapOfSnippets.put(id, snippet);
        latest10.push(snippet);
    }

    @Override
    public Snippet retrieve(int id) {
        return mapOfSnippets.get(id);
    }

    @Override
    public List<Snippet> retrieveLatest() {
        List<Snippet> sortedFromRecent = new LinkedList<>();
        int bound = latest10.size();
        Stack<Snippet> tempStack = new SizedStack<>(10);
        tempStack.addAll(latest10);

        for (int i = 0; i < bound; i++) {
            sortedFromRecent.add(tempStack.pop());
        }
        return sortedFromRecent;
    }
}
