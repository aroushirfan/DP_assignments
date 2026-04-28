package facade;

public class JokeDemo {

  public static void main(String[] args) {

    ApiFacade api = new ApiFacade();

    try {
      String joke = api.getAttributeValueFromJson(
          "https://api.chucknorris.io/jokes/random",
          "value"
      );

      System.out.println(joke);

    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
