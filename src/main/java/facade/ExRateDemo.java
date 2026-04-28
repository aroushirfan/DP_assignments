package facade;

public class ExRateDemo {

  public static void main(String[] args) {

    ApiFacade api = new ApiFacade();

    try {
      String rates = api.getAttributeValueFromJson(
          "https://api.fxratesapi.com/latest",
          "rates"
      );
      System.out.println("Rates:");
      System.out.println(rates);

    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
