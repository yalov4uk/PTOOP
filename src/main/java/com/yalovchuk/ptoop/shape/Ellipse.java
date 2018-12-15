package com.yalovchuk.ptoop.shape;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ellipse implements Shape {

  private Vector center;
  private int width;
  private int height;
}
