package proxy;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        User alice = new User("A");
        User bob = new User("B");

        library.addUnprotectedDocument("doc1", LocalDate.now(), "Public content: Hello world!");
        library.addProtectedDocument("doc2", LocalDate.now(), "Secret content: Top-level info");

        AccessControlService acs = AccessControlService.getInstance();
        acs.allowAccess("A", "doc2");
        try {
            System.out.println("A reads doc1: " + library.getDocument("doc1").getContent(alice));
            System.out.println("A reads doc2: " + library.getDocument("doc2").getContent(alice));

            System.out.println("B reads doc1: " + library.getDocument("doc1").getContent(bob));
            System.out.println("B reads doc2: " + library.getDocument("doc2").getContent(bob));

        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}