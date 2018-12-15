package com.yalovchuk.ptoop;

import com.yalovchuk.ptoop.shape.Shape;
import java.util.List;
import java.util.Map;

public class UserExperience {

  private final ShapeManager shapeManager = new ShapeManager();

  private Class<? extends Shape> active;

  public Map<Integer, Class<? extends Shape>> getOptions() {
    return shapeManager.getOptions();
  }

  public void activate(int option) {
    active = shapeManager.getOptions().get(option);
  }

  public Shape generate() {
    return shapeManager.generate(active);
  }

  public void create(Shape shape) {
    shapeManager.create(shape);
  }

  public List<Shape> readAll() {
    return shapeManager.readAll();
  }

  public void update(int i, Shape shape) {
    shapeManager.update(i, shape);
  }

  public void delete(int i) {
    shapeManager.delete(i);
  }

  public void draw(Shape shape) {
    shapeManager.draw(active, shape);
  }
}
