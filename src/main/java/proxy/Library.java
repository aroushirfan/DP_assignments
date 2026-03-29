package proxy;

import java.time.LocalDate;
import java.util.HashMap;

public class Library {

    private HashMap<String, Document> documents = new HashMap<>();

    public void addUnprotectedDocument(String id, LocalDate date, String content) {
        RealDocument doc = new RealDocument(id, date, content);
        documents.put(id, doc);
    }

    public void addProtectedDocument(String id, LocalDate date, String content) {
        RealDocument real = new RealDocument(id, date, content);
        DocumentProxy proxy = new DocumentProxy(real, true);
        documents.put(id, proxy);
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }
}
