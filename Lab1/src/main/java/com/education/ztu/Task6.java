package com.education.ztu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task6 {

  public static void main(String[] args) {
    System.out.println(System.lineSeparator());
    System.out.println("Task 6 (fibonacci)");

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of Fibonacci elements: ");
    int n = scanner.nextInt();

    var fibonacciSequence = FibonacciUtils.generateFibonacciSequence(n);
    var reversedFibonacciSequence = IntStream.rangeClosed(
      1,
      fibonacciSequence.length
    )
      .mapToObj(i -> fibonacciSequence[fibonacciSequence.length - i])
      .toArray();

    System.out.println("Fibonacci sequence:");
    System.out.println(String.join(" ", Arrays.toString(fibonacciSequence)));

    System.out.println("Reversed Fibonacci sequence:");
    System.out.println(
      String.join(" ", Arrays.toString(reversedFibonacciSequence))
    );
    System.out.println();
  }
}
