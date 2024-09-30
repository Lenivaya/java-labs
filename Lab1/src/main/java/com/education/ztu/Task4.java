package com.education.ztu;

import java.util.Scanner;

public class Task4 {

  public static void main(String[] args) {
    System.out.println(System.lineSeparator());
    System.out.println("Task 4 (GCD)");

    try (var scanner = new Scanner(System.in)) {
      System.out.print("Enter the first positive integer: ");
      var a = scanner.nextInt();

      System.out.print("Enter the second positive integer: ");
      var b = scanner.nextInt();

      if (a <= 0 || b <= 0) {
        throw new IllegalArgumentException("Both numbers must be positive.");
      }

      int gcd = GCDCalculator.findGCD(a, b);
      System.out.println("The Greatest Common Divisor is: " + gcd);
    }
  }
}
