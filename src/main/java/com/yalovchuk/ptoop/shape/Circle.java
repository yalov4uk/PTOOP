package com.yalovchuk.ptoop.shape;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Circle implements Shape {

  private static final long serialVersionUID = 1L;

  private Point center;
  private int radius;
}
