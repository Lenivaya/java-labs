package com.education.ztu;

import java.util.Arrays;

public class Main2 {

  public static void main(String[] args) {
    System.out.println(System.lineSeparator());
    System.out.println("Demonstrating operations class:");
    System.out.println("Math operations:");
    System.out.println("Addition: " + Operation.addition(1, 2, 3, 4, 5));
    System.out.println("Subtraction: " + Operation.subtraction(100, 20, 30));
    System.out.println("Multiplication: " + Operation.multiplication(2, 3, 4));
    System.out.println("Division: " + Operation.division(100, 2, 2));
    System.out.println("Average: " + Operation.average(10, 20, 30, 40, 50));
    System.out.println("Maximum: " + Operation.maximum(5, 2, 8, 1, 9));
    System.out.println("Minimum: " + Operation.minimum(5, 2, 8, 1, 9));

    System.out.println();
    System.out.println("Location enum values:");
    System.out.println(Arrays.toString(Location.values()));
  }
}
