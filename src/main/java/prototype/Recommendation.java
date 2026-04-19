package prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
  private String targetAudience;
  private List<Book> books = new ArrayList<>();

  public Recommendation(String targetAudience) {
    this.targetAudience = targetAudience;
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public void removeBook(int index) {
    if (index >= 0 && index < books.size()) {
      books.remove(index);
    }
  }

  public void setTargetAudience(String targetAudience) {
    this.targetAudience = targetAudience;
  }

  public List<Book> getBooks() {
    return books;
  }

  @Override
  public Recommendation clone() {
    try {
      Recommendation cloned = (Recommendation) super.clone();
      cloned.books = new ArrayList<>();

      for (Book b : this.books) {
        cloned.books.add(b.clone()); // deep copy
      }

      return cloned;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError("Cloning failed");
    }
  }

  @Override
  public String toString() {
    return "Target Audience: " + targetAudience + "\nBooks:\n" + books;
  }
}
