package flyweight;

import java.util.Random;

public class WildernessMap extends Map {

  public WildernessMap(int width, int height) {
    super(width, height);
  }

  @Override
  protected void generate() {
    Random r = new Random();

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {

        int roll = r.nextInt(100);

        if (roll < 40) tiles[row][col] = new ForestTile();
        else if (roll < 60) tiles[row][col] = new WaterTile();
        else if (roll < 80) tiles[row][col] = new SwampTile();
        else tiles[row][col] = new RoadTile();
      }
    }
  }
}
