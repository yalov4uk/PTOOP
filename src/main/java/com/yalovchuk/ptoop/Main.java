package com.yalovchuk.ptoop;

import com.yalovchuk.ptoop.shape.Circle;
import com.yalovchuk.ptoop.shape.Ellipse;
import com.yalovchuk.ptoop.shape.Parallelogram;
import com.yalovchuk.ptoop.shape.Point;
import com.yalovchuk.ptoop.shape.Rectangle;
import com.yalovchuk.ptoop.shape.Segment;
import com.yalovchuk.ptoop.shape.Shape;
import com.yalovchuk.ptoop.shape.Square;
import com.yalovchuk.ptoop.shape.Vector;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    ShapeHolder shapeHolder = new ShapeHolder();
    shapeHolder.setShapes(Arrays.asList(
        new Circle(new Point(1, 2), 3),
        new Ellipse(new Vector(new Point(1, 2), 3), 4, 5),
        new Parallelogram(new Vector(new Point(1, 2), 3), 4, 5, 6),
        new Rectangle(new Vector(new Point(1, 2), 3), 4, 5),
        new Segment(new Vector(new Point(1, 2), 3), 4),
        new Square(new Vector(new Point(1, 2), 3), 4)
    ));
    for (Shape shape : shapeHolder.getShapes()) {
      shape.draw();
    }
  }
}
