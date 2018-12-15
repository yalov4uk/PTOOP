package com.yalovchuk.ptoop.shape;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Segment implements Shape {

  private static final long serialVersionUID = 1L;

  private Vector vector;
  private int length;
}
