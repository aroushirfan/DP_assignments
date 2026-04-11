package bridge;

public class Triangle extends Shape {

  public Triangle(Color color, BorderStyle borderStyle) {
    super(color, borderStyle);
  }

  @Override
  public String draw() {
    return "Triangle drawn. " + color.fill() + ". " + borderStyle.applyBorder();
  }
}
