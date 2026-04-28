package command;

public class PixelGrid {
  private int[][] pixels = new int[8][8];
  private int cursorX = 0;
  private int cursorY = 0;
  private PixelGridView view;

  public void setView(PixelGridView view) {
    this.view = view;
  }

  public int[][] getPixels() {
    return pixels;
  }

  public int getCursorX() {
    return cursorX;
  }

  public int getCursorY() {
    return cursorY;
  }

  public void moveCursorUp() {
    if (cursorY > 0) cursorY--;
    view.update();
  }

  public void moveCursorDown() {
    if (cursorY < 7) cursorY++;
    view.update();
  }

  public void moveCursorLeft() {
    if (cursorX > 0) cursorX--;
    view.update();
  }

  public void moveCursorRight() {
    if (cursorX < 7) cursorX++;
    view.update();
  }

  public void togglePixel() {
    pixels[cursorY][cursorX] = pixels[cursorY][cursorX] == 0 ? 1 : 0;
    view.update();
  }

  public void generateCode() {
    System.out.println("int[][] pixelArt = {");
    for (int y = 0; y < 8; y++) {
      System.out.print("    {");
      for (int x = 0; x < 8; x++) {
        System.out.print(pixels[y][x]);
        if (x < 7) System.out.print(", ");
      }
      System.out.println("},");
    }
    System.out.println("};");
  }
}
