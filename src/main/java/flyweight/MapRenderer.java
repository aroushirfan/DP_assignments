package flyweight;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class MapRenderer {

  private static final int TILE_SIZE = 64;

  public static Canvas render(Map map) {
    int width = map.getWidth();
    int height = map.getHeight();

    Canvas canvas = new Canvas(width * TILE_SIZE, height * TILE_SIZE);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {

        Tile tile = map.getTile(row, col);
        String type = tile.getType();

        Image img = TileGraphicFactory.getGraphic(type).getImage();

        gc.drawImage(img, col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
      }
    }

    return canvas;
  }
}
