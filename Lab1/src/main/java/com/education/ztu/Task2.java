package com.education.ztu;

import java.util.Scanner;

public class Task2 {

  public static void main(String[] args) {
    System.out.println(System.lineSeparator());
    System.out.println("Task 2 (Sum)");

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Enter first number: ");
      int firstNumber = scanner.nextInt();

      System.out.print("Enter second number: ");
      int secondNumber = scanner.nextInt();

      int sum = firstNumber + secondNumber;
      System.out.println("Sum: " + sum);
    }
  }
}
