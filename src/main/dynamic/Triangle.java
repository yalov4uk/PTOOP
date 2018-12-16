package dynamic;

import com.yalovchuk.ptoop.shape.Shape;
import com.yalovchuk.ptoop.shape.Vector;

public class Triangle implements Shape {

  private static final long serialVersionUID = 1L;

  private Vector vector;
  private int angle;
  private int length;

  public Triangle(Vector vector, int angle, int length) {
    this.vector = vector;
    this.angle = angle;
    this.length = length;
  }

  public Vector getVector() {
    return vector;
  }

  public void setVector(Vector vector) {
    this.vector = vector;
  }

  public int getAngle() {
    return angle;
  }

  public void setAngle(int angle) {
    this.angle = angle;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Triangle triangle = (Triangle) o;

    if (angle != triangle.angle) {
      return false;
    }
    if (length != triangle.length) {
      return false;
    }
    return vector.equals(triangle.vector);
  }

  @Override
  public int hashCode() {
    int result = vector.hashCode();
    result = 31 * result + angle;
    result = 31 * result + length;
    return result;
  }

  @Override
  public String toString() {
    return "Triangle{" +
        "vector=" + vector +
        ", angle=" + angle +
        ", length=" + length +
        '}';
  }
}
