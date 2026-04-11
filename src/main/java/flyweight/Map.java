package flyweight;

public abstract class Map {

  protected Tile[][] tiles;
  protected int width;
  protected int height;

  public Map(int width, int height) {
    this.width = width;
    this.height = height;
    tiles = new Tile[height][width];
    generate();
  }

  protected abstract void generate();

  public Tile getTile(int row, int col) {
    return tiles[row][col];
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
