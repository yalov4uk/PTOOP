package com.yalovchuk.ptoop.service;

import static java.io.File.separator;

import com.yalovchuk.ptoop.shape.Shape;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.extern.java.Log;

/**
 * This class is responsible for holding shapes in file.
 */
@Log
public class ShapeHolder {

  /**
   * Default filename pattern.
   */
  private static final String FILENAME =
      "src" + separator + "main" + separator + "resources" + separator + "shapes-%s.bin";

  @Getter
  private List<Shape> shapes = new ArrayList<>();

  public void create(Shape shape) {
    shapes.add(shape);
  }

  public void update(int i, Shape shape) {
    shapes.set(i, shape);
  }

  public void delete(int i) {
    shapes.remove(i);
  }

  /**
   * Load shapes from file using {@code FILENAME} pattern and postfix arg. Binary deserialization.
   *
   * @param postfix - postfix, for most cases current date in nano.
   */
  @SuppressWarnings("unchecked")
  public void load(String postfix) {
    try (FileInputStream fileInputStream = new FileInputStream(String.format(FILENAME, postfix));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
      shapes = (List<Shape>) objectInputStream.readObject();
    } catch (IOException | ClassNotFoundException e) {
      log.warning("shapes = []");
    }
  }

  /**
   * Save shapes to file with file name {@code FILENAME} + current time in nano. Binary
   * Serialization.
   */
  public void save() {
    try (FileOutputStream fileOutputStream = new FileOutputStream(
        String.format(FILENAME, System.nanoTime()));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
      objectOutputStream.writeObject(shapes);
      objectOutputStream.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
