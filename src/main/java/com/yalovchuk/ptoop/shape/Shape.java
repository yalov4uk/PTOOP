package com.yalovchuk.ptoop.shape;

public interface Shape {

  default void draw() {
    System.out.println(this);
  }
}
