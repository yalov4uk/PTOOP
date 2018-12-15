package com.yalovchuk.ptoop;

import com.yalovchuk.ptoop.shape.Shape;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class UserExperience {

  private final ShapeManager shapeManager = new ShapeManager();

  private Class<? extends Shape> active;

  public Map<Integer, Class<? extends Shape>> getOptions() {
    return shapeManager.getOptions();
  }

  public void activate(int option) {
    active = shapeManager.getOptions().get(option);
  }

  public Shape create() {
    return shapeManager.create(active);
  }

  public void draw(Shape shape) {
    shapeManager.draw(active, shape);
  }

  public void addNewShape(Class<? extends Shape> option, Supplier<Shape> creator,
      Consumer<Shape> drawer) {
    shapeManager.add(option, creator, drawer);
  }
}
