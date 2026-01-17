package factory_method;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Choose map type: 1. City Map 2. Wilderness Map");
        int choice= scanner.nextInt();
        Map map;
        if (choice==1) {
            map= new CityMap();
        } else {
            map= new WildernessMap();
        }
        map.display();
    }
}
