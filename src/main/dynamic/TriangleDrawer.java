package dynamic;

import com.yalovchuk.ptoop.shape.Shape;
import java.util.function.Consumer;

public class TriangleDrawer implements Consumer<Shape> {

  @Override
  public void accept(Shape shape) {
    System.out.println(shape);
  }
}
