package abstract_factory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose UI factory A/B or q to quit: ");
            String choice = scanner.next().trim().toUpperCase();
            if (choice.equals("Q")) {
                System.out.println("Quitting");
                break;
            }
            UIFactory factory;
            if (choice.equals("A")) {
                factory = new FactoryA();
            } else if (choice.equals("B")) {
                factory = new FactoryB();
            } else {
                System.out.println("Invalid choice!");
                continue;
            }
            Button button = factory.createButton("Submit");
            Checkbox checkbox = factory.createCheckbox("I agree");
            TextField textField = factory.createTextField("Type anything...");

            System.out.println("Displaying initial UI:");
            button.display();
            checkbox.display();
            textField.display();

            button.setText("Confirm");
            checkbox.setText("Confirmed");
            textField.setText("Type email");

            System.out.println("Displaying updated UI:");
            button.display();
            checkbox.display();
            textField.display();

        }
    }
}
