package command;

public class MoveCursorLeftCommand implements Command {
  private PixelGrid grid;

  public MoveCursorLeftCommand(PixelGrid grid) {
    this.grid = grid;
  }

  public void execute() {
    grid.moveCursorLeft();
  }
}
