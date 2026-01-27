package factory_method;

public abstract class Map {
    protected int rows= 6;
    protected int columns= 6;
    protected Tile[][] tiles = new Tile[rows][columns];

    public abstract Tile createTile();

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tiles[i][j] = createTile();
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
