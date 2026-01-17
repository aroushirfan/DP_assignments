package factory_method;
import java.util.Random;

public class CityMap extends Map{
    private Random rand = new Random();
    @Override
    public Tile createTile() {
        int choice = rand.nextInt(3);
        switch (choice) {
            case 0:
                return new RoadTile();
            case 1:
                return new BuildingTile();
            case 2:
                return new ForestTile();
            default: return new RoadTile();
        }
    }
}
