package prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecommendationSystemUI {

  private static final List<Recommendation> recommendations = new ArrayList<>();
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    boolean running = true;

    while (running) {
      System.out.println("\n=== Book Recommendation System ===");
      System.out.println("1. View Recommendations");
      System.out.println("2. Create New Recommendation");
      System.out.println("3. Clone Existing Recommendation");
      System.out.println("4. Modify Recommendation");
      System.out.println("5. Exit");
      System.out.print("Choose: ");

      int choice = Integer.parseInt(scanner.nextLine());

      switch (choice) {
        case 1 -> viewRecommendations();
        case 2 -> createRecommendation();
        case 3 -> cloneRecommendation();
        case 4 -> modifyRecommendation();
        case 5 -> running = false;
        default -> System.out.println("Invalid choice");
      }
    }
  }

  private static void viewRecommendations() {
    if (recommendations.isEmpty()) {
      System.out.println("No recommendations available.");
      return;
    }

    for (int i = 0; i < recommendations.size(); i++) {
      System.out.println("\n[" + i + "]");
      System.out.println(recommendations.get(i));
    }
  }

  private static void createRecommendation() {
    System.out.print("Enter target audience: ");
    String audience = scanner.nextLine();

    Recommendation rec = new Recommendation(audience);

    boolean adding = true;
    while (adding) {
      System.out.print("Add book? (y/n): ");
      if (!scanner.nextLine().equalsIgnoreCase("y")) break;

      rec.addBook(createBook());
    }

    recommendations.add(rec);
    System.out.println("Recommendation created.");
  }

  private static Book createBook() {
    System.out.print("Author: ");
    String author = scanner.nextLine();

    System.out.print("Title: ");
    String title = scanner.nextLine();

    System.out.print("Genre: ");
    String genre = scanner.nextLine();

    System.out.print("Publication Year: ");
    int year = Integer.parseInt(scanner.nextLine());

    return new Book(author, title, genre, year);
  }

  private static void cloneRecommendation() {
    if (recommendations.isEmpty()) {
      System.out.println("No recommendations to clone.");
      return;
    }

    viewRecommendations();
    System.out.print("Enter index to clone: ");
    int index = Integer.parseInt(scanner.nextLine());

    if (index < 0 || index >= recommendations.size()) {
      System.out.println("Invalid index.");
      return;
    }

    Recommendation cloned = recommendations.get(index).clone();
    recommendations.add(cloned);

    System.out.println("Recommendation cloned.");
  }

  private static void modifyRecommendation() {
    if (recommendations.isEmpty()) {
      System.out.println("No recommendations to modify.");
      return;
    }

    viewRecommendations();
    System.out.print("Enter index to modify: ");
    int index = Integer.parseInt(scanner.nextLine());

    if (index < 0 || index >= recommendations.size()) {
      System.out.println("Invalid index.");
      return;
    }

    Recommendation rec = recommendations.get(index);

    System.out.println("1. Change target audience");
    System.out.println("2. Add book");
    System.out.println("3. Remove book");
    System.out.print("Choose: ");

    int choice = Integer.parseInt(scanner.nextLine());

    switch (choice) {
      case 1 -> {
        System.out.print("New audience: ");
        rec.setTargetAudience(scanner.nextLine());
      }
      case 2 -> rec.addBook(createBook());
      case 3 -> {
        System.out.print("Book index to remove: ");
        int bookIndex = Integer.parseInt(scanner.nextLine());
        rec.removeBook(bookIndex);
      }
      default -> System.out.println("Invalid choice");
    }

    System.out.println("Recommendation updated.");
  }
}
