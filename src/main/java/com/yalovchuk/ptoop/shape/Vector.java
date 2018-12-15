package com.yalovchuk.ptoop.shape;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vector implements Serializable {

  private static final long serialVersionUID = 1L;

  private Point point;
  private int angle;
}
