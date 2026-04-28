package command;

public class MoveCursorDownCommand implements Command {
  private PixelGrid grid;

  public MoveCursorDownCommand(PixelGrid grid) {
    this.grid = grid;
  }

  public void execute() {
    grid.moveCursorDown();
  }
}
