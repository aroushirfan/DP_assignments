package flyweight;

import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {

  private static final Map<String, TileGraphic> graphics = new HashMap<>();

  public static TileGraphic getGraphic(String tileType) {
    TileGraphic graphic = graphics.get(tileType);

    if (graphic == null) {
      String path = "/tiles/" + tileType + ".png";
      graphic = new TileGraphic(path);
      graphics.put(tileType, graphic);
    }

    return graphic;
  }
}
