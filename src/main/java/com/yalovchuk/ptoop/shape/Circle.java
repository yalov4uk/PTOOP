package com.yalovchuk.ptoop.shape;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Circle implements Shape {

  private Point center;
  private int radius;
}
