package command;

public class MoveCursorRightCommand implements Command {
  private PixelGrid grid;

  public MoveCursorRightCommand(PixelGrid grid) {
    this.grid = grid;
  }

  public void execute() {
    grid.moveCursorRight();
  }
}
