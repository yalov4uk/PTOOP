package com.yalovchuk.ptoop.shape;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Parallelogram extends Rectangle {

  private int angle;

  public Parallelogram(Vector vector, int width, int height, int angle) {
    super(vector, width, height);
    this.angle = angle;
  }
}
