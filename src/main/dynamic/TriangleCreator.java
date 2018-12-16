package dynamic;

import com.yalovchuk.ptoop.shape.Point;
import com.yalovchuk.ptoop.shape.Shape;
import com.yalovchuk.ptoop.shape.Vector;
import java.util.Scanner;
import java.util.function.Supplier;

public class TriangleCreator implements Supplier<Shape> {

  private static final Scanner scanner = new Scanner(System.in);

  @Override
  public Shape get() {
    return new Triangle(
        new Vector(
            new Point(
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine())),
            Integer.parseInt(scanner.nextLine())),
        Integer.parseInt(scanner.nextLine()),
        Integer.parseInt(scanner.nextLine()));
  }
}
