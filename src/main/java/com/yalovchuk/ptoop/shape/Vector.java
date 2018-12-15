package com.yalovchuk.ptoop.shape;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vector {

  private Point point;
  private int angle;
}
