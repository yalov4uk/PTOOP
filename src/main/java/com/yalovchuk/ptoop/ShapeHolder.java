package com.yalovchuk.ptoop;

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

@Log
public class ShapeHolder {

  private static final String FILENAME = "src/main/resources/shapes.bin";

  @Getter
  private List<Shape> shapes = new ArrayList<>();

  public ShapeHolder() {
    try (FileInputStream fileInputStream = new FileInputStream(FILENAME);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
      shapes = (List<Shape>) objectInputStream.readObject();
    } catch (IOException | ClassNotFoundException e) {
      log.warning("shapes = []");
    }
  }

  public void create(Shape shape) {
    shapes.add(shape);
    save();
  }

  public void update(int i, Shape shape) {
    shapes.set(i, shape);
    save();
  }

  public void delete(int i) {
    shapes.remove(i);
    save();
  }

  private void save() {
    try (FileOutputStream fileOutputStream = new FileOutputStream(FILENAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
      objectOutputStream.writeObject(shapes);
      objectOutputStream.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
