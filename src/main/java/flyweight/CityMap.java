package flyweight;

import java.util.Random;

public class CityMap extends Map {

  public CityMap(int width, int height) {
    super(width, height);
  }

  @Override
  protected void generate() {
    Random r = new Random();

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {

        int roll = r.nextInt(100);

        if (roll < 50) tiles[row][col] = new RoadTile();
        else if (roll < 80) tiles[row][col] = new BuildingTile();
        else tiles[row][col] = new ForestTile();
      }
    }
  }
}
