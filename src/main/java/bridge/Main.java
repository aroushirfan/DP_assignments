package bridge;

public class Main {
  public static void main(String[] args) {

    Shape hex = new Hexagon(new Green(), new DashedBorder());
    Shape square = new Square(new Blue(), new ThickBorder());
    Shape triangle = new Triangle(new Red(), new DashedBorder());

    System.out.println(hex.draw());
    System.out.println(square.draw());
    System.out.println(triangle.draw());
  }
}
