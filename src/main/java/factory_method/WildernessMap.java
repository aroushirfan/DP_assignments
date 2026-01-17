package factory_method;

import java.util.Random;

public class WildernessMap extends Map{
    private Random rand = new Random();
    @Override
    public Tile createTile() {
        int choice = rand.nextInt(3);
        switch (choice) {
            case 0:
                return new ForestTile();
            case 1:
                return new SwampTile();
            case 2:
                return new WaterTile();
            default: return new ForestTile();
        }
    }
}
