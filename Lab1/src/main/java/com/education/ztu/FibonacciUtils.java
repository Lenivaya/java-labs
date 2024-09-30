package com.education.ztu;

import java.util.stream.IntStream;

public class FibonacciUtils {

  public static int[] generateFibonacciSequence(int n) {
    if (n <= 0) return new int[0];
    return IntStream.range(0, n).map(FibonacciUtils::fibonacci).toArray();
  }

  public static int fibonacci(int n) {
    return n <= 1 ? 1 : fibonacci(n - 1) + fibonacci(n - 2);
  }
}
