package com.yalovchuk.ptoop.service;

import com.yalovchuk.ptoop.shape.Shape;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Api gateway (facade).
 */
public class UserExperience {

  private final PluginManager pluginManager = new PluginManager();
  private final ShapeHolder shapeHolder = new ShapeHolder();

  /**
   * Currently active shape. Emulates pressed button on UI
   */
  private Class<? extends Shape> active;

  /**
   * Get all shapes. Emulates an array of buttons on UI. Only one button may be {@code active} Each
   * shape associated with unique id. So it's possible to choose a shape by id.
   *
   * @return shapes.
   */
  public Map<Integer, Class<? extends Shape>> getOptions() {
    return pluginManager.getOptions();
  }

  /**
   * Activate the shape by id.
   *
   * @param option - id of the shape to activate.
   */
  public void activate(int option) {
    active = pluginManager.getOptions().get(option);
  }

  /**
   * Generate the active shape.
   *
   * @return shape.
   */
  public Shape generate() {
    return pluginManager.generate(active);
  }

  /**
   * Draw the shape.
   *
   * @param shape - shape to draw
   */
  public void draw(Shape shape) {
    pluginManager.draw(active, shape);
  }

  /**
   * Add a new shape at the runtime from compiled sources.
   *
   * @param urls - urls, where .class files located.
   * @param optionClass - model class.
   * @param creatorClass - class with factory method.
   * @param drawerClass - class with draw method.
   */
  public void addPlugin(URL[] urls, String optionClass, String creatorClass, String drawerClass) {
    pluginManager.addPlugin(urls, optionClass, creatorClass, drawerClass);
  }

  /**
   * Create a new shape.
   *
   * @param shape - shape to create
   */
  public void create(Shape shape) {
    shapeHolder.create(shape);
  }

  /**
   * Read all shapes.
   *
   * @return shapes.
   */
  public List<Shape> readAll() {
    return shapeHolder.getShapes();
  }

  /**
   * Update existing shape by index in an array.
   *
   * @param i - index in array.
   * @param shape - shape to update.
   */
  public void update(int i, Shape shape) {
    shapeHolder.update(i, shape);
  }

  /**
   * Delete shape by index in an array.
   *
   * @param i - index in an array.
   */
  public void delete(int i) {
    shapeHolder.delete(i);
  }

  /**
   * Load shapes from file with postfix.
   *
   * @param postfix - file postfix.
   */
  public void load(String postfix) {
    shapeHolder.load(postfix);
  }

  /**
   * Save shapes to file.
   */
  public void save() {
    shapeHolder.save();
  }
}
