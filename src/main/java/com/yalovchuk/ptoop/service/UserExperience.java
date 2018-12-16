package com.yalovchuk.ptoop.service;

import com.yalovchuk.ptoop.shape.Shape;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class UserExperience {

  private final PluginManager pluginManager = new PluginManager();
  private final ShapeHolder shapeHolder = new ShapeHolder();

  private Class<? extends Shape> active;

  public Map<Integer, Class<? extends Shape>> getOptions() {
    return pluginManager.getOptions();
  }

  public void activate(int option) {
    active = pluginManager.getOptions().get(option);
  }

  public Shape generate() {
    return pluginManager.generate(active);
  }

  public void draw(Shape shape) {
    pluginManager.draw(active, shape);
  }

  public void addModule(URL[] urls, String optionClass, String creatorClass, String drawerClass) {
    pluginManager.addModule(urls, optionClass, creatorClass, drawerClass);
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
}
