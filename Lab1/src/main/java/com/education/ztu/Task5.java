package com.education.ztu;

import java.util.Scanner;

public class Task5 {

  public static void main(String[] args) {
    System.out.println(System.lineSeparator());
    System.out.println("Task 5 (sum of digits)");

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a positive integer: ");
    int number = scanner.nextInt();

    if (number <= 0) {
      throw new IllegalArgumentException("The number must be positive.");
    }

    int sumOfDigits = DigitSumCalculator.calculateDigitSum(number);
    System.out.println("The sum of the digits is: " + sumOfDigits);
  }
}
