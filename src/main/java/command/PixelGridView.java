package command;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PixelGridView extends GridPane {
  private PixelGrid grid;
  private Rectangle[][] rects = new Rectangle[8][8];

  public PixelGridView(PixelGrid grid) {
    this.grid = grid;
    grid.setView(this);

    for (int y = 0; y < 8; y++) {
      for (int x = 0; x < 8; x++) {
        Rectangle r = new Rectangle(40, 40);
        r.setStroke(Color.GRAY);
        rects[y][x] = r;
        add(r, x, y);
      }
    }

    update();
  }

  public void update() {
    int[][] pixels = grid.getPixels();
    int cx = grid.getCursorX();
    int cy = grid.getCursorY();

    for (int y = 0; y < 8; y++) {
      for (int x = 0; x < 8; x++) {
        if (pixels[y][x] == 1) {
          rects[y][x].setFill(Color.BLACK);
        } else {
          rects[y][x].setFill(Color.WHITE);
        }

        if (x == cx && y == cy) {
          rects[y][x].setStroke(Color.RED);
        } else {
          rects[y][x].setStroke(Color.GRAY);
        }
      }
    }
  }
}
