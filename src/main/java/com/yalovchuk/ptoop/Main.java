package com.yalovchuk.ptoop;

import com.yalovchuk.ptoop.shape.Shape;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    UserExperience userExperience = new UserExperience();
    while (true) {
      System.out.println("1. Tap a number and choose shape");
      System.out.println(userExperience.getOptions());
      userExperience.activate(Integer.parseInt(scanner.nextLine()));

      System.out.println("2. Create chose shape");
      Shape shape = userExperience.create();

      System.out.println("3. Draw created shape");
      userExperience.draw(shape);
    }
  }
}
