package com.education.ztu;

import java.util.Arrays;

public class Operation {

  public static double addition(double... numbers) {
    return Arrays.stream(numbers).sum();
  }

  public static double subtraction(double... numbers) {
    return Arrays.stream(numbers).reduce((a, b) -> a - b).orElse(0);
  }

  public static double multiplication(double... numbers) {
    return Arrays.stream(numbers).reduce((a, b) -> a * b).orElse(1);
  }

  public static double division(double... numbers) {
    return Arrays.stream(numbers)
      .reduce((a, b) -> a / b)
      .orElseThrow(() ->
        new IllegalArgumentException("Division requires at least one number")
      );
  }

  public static double average(double... numbers) {
    return Arrays.stream(numbers).average().orElse(0);
  }

  public static double maximum(double... numbers) {
    return Arrays.stream(numbers).max().orElse(Double.NEGATIVE_INFINITY);
  }

  public static double minimum(double... numbers) {
    return Arrays.stream(numbers).min().orElse(Double.POSITIVE_INFINITY);
  }
}
