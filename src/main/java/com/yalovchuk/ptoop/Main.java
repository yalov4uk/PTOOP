package com.yalovchuk.ptoop;

import com.yalovchuk.ptoop.shape.Shape;
import java.util.Scanner;
import lombok.extern.java.Log;

@Log
public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    UserExperience userExperience = new UserExperience();
    while (true) {
      log.info("1 - view, 2- add and draw, 3- update, 4 - delete");
      switch (Integer.parseInt(scanner.nextLine())) {
        case 1:
          log.info(userExperience.readAll().toString());
          break;
        case 2:
          log.info(userExperience.getOptions().toString());
          userExperience.activate(Integer.parseInt(scanner.nextLine()));
          Shape shape = userExperience.generate();
          userExperience.create(shape);
          userExperience.draw(shape);
          break;
        case 3:
          userExperience.update(Integer.parseInt(scanner.nextLine()), userExperience.generate());
          break;
        case 4:
          userExperience.delete(Integer.parseInt(scanner.nextLine()));
          break;
      }
    }
  }
}
