package state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameCharacter hero = new GameCharacter("Hero");
        Scanner sc = new Scanner(System.in);
        while (true) {
            hero.showStatus();
            System.out.println("Choose an action: 1) Train 2) Meditate 3) Fight");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> hero.train();
                case 2 -> hero.meditate();
                case 3 -> hero.fight();
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
