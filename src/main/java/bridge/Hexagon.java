package bridge;

public class Hexagon extends Shape {

  public Hexagon(Color color, BorderStyle borderStyle) {
    super(color, borderStyle);
  }

  @Override
  public String draw() {
    return "Hexagon drawn. " + color.fill() + ". " + borderStyle.applyBorder();
  }
}
