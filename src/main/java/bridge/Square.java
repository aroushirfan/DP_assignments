package bridge;

public class Square extends Shape {

  public Square(Color color, BorderStyle borderStyle) {
    super(color, borderStyle);
  }

  @Override
  public String draw() {
    return "Square drawn. " + color.fill() + ". " + borderStyle.applyBorder();
  }
}
