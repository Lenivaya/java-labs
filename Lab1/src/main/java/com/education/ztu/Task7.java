package com.education.ztu;

import java.util.stream.IntStream;

public class Task7 {

  public static void main(String[] args) {
    System.out.println(System.lineSeparator());
    System.out.println("Task 7 (ASCII alphabet)");

    IntStream.rangeClosed('A', 'Z')
      .mapToObj(c -> (char) c + " ==> " + c)
      .forEach(System.out::println);
  }
}
