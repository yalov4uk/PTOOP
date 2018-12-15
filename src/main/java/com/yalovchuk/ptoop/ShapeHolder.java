package com.yalovchuk.ptoop;

import com.yalovchuk.ptoop.shape.Shape;
import java.util.Collection;
import lombok.Data;

@Data
public class ShapeHolder {

  private Collection<Shape> shapes;
}
