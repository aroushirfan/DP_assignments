package bridge;

public abstract class Shape {
  protected Color color;
  protected BorderStyle borderStyle;

  public Shape(Color color, BorderStyle borderStyle) {
    this.color = color;
    this.borderStyle = borderStyle;
  }

  public abstract String draw();
}
