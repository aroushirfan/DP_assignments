package flyweight;

import javafx.scene.image.Image;

public class TileGraphic {
  private final Image image;

  public TileGraphic(String path) {
    this.image = new Image(path);
  }

  public Image getImage() {
    return image;
  }
}
