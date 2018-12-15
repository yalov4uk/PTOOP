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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;
import lombok.Getter;

public class ShapeManager {

  private static final Scanner scanner = new Scanner(System.in);
  private final ShapeHolder shapeHolder = new ShapeHolder();
  @Getter
  private final Map<Integer, Class<? extends Shape>> options = new HashMap<>();
  private final Map<Class<? extends Shape>, Supplier<Shape>> creators = new HashMap<>();
  private final Map<Class<? extends Shape>, Consumer<Shape>> drawers = new HashMap<>();

  private int i;

  public ShapeManager() {
    defaultInit();
  }

  public void create(Shape shape) {
    shapeHolder.create(shape);
  }

  public List<Shape> readAll() {
    return shapeHolder.getShapes();
  }

  public void update(int i, Shape shape) {
    shapeHolder.update(i, shape);
  }

  public void delete(int i) {
    shapeHolder.delete(i);
  }

  public Shape generate(Class<? extends Shape> shapeClass) {
    return creators.get(shapeClass).get();
  }

  public void draw(Class<? extends Shape> shapeClass, Shape shape) {
    drawers.get(shapeClass).accept(shape);
  }

  public void addNewShapeClass(Class<? extends Shape> option, Supplier<Shape> creator,
      Consumer<Shape> drawer) {
    creators.put(option, creator);
    drawers.put(option, drawer);
    options.put(i++, option);
  }

  private void defaultInit() {
    options.put(i++, Circle.class);
    options.put(i++, Ellipse.class);
    options.put(i++, Parallelogram.class);
    options.put(i++, Rectangle.class);
    options.put(i++, Segment.class);
    options.put(i++, Square.class);

    creators.put(Circle.class, () -> new Circle(
        new Point(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine())),
        Integer.parseInt(scanner.nextLine())));
    creators.put(Ellipse.class, () -> new Ellipse(new Vector(
        new Point(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine())),
        Integer.parseInt(scanner.nextLine())), Integer.parseInt(scanner.nextLine()),
        Integer.parseInt(scanner.nextLine())));
    creators.put(Parallelogram.class, () -> new Parallelogram(new Vector(
        new Point(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine())),
        Integer.parseInt(scanner.nextLine())), Integer.parseInt(scanner.nextLine()),
        Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine())));
    creators.put(Rectangle.class, () -> new Rectangle(new Vector(
        new Point(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine())),
        Integer.parseInt(scanner.nextLine())), Integer.parseInt(scanner.nextLine()),
        Integer.parseInt(scanner.nextLine())));
    creators.put(Segment.class, () -> new Segment(new Vector(
        new Point(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine())),
        Integer.parseInt(scanner.nextLine())), Integer.parseInt(scanner.nextLine())));
    creators.put(Square.class, () -> new Square(new Vector(
        new Point(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine())),
        Integer.parseInt(scanner.nextLine())), Integer.parseInt(scanner.nextLine())));

    drawers.put(Circle.class, System.out::println);
    drawers.put(Ellipse.class, System.out::println);
    drawers.put(Parallelogram.class, System.out::println);
    drawers.put(Rectangle.class, System.out::println);
    drawers.put(Segment.class, System.out::println);
    drawers.put(Square.class, System.out::println);
  }
}
