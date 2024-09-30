package com.education.ztu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FibonacciUtilsTest {

  @Test
  void fibonacciWorksCorrectly() {
    assertAll(
      () -> assertEquals(1, FibonacciUtils.fibonacci(0)),
      () -> assertEquals(1, FibonacciUtils.fibonacci(1)),
      () -> assertEquals(2, FibonacciUtils.fibonacci(2)),
      () -> assertEquals(3, FibonacciUtils.fibonacci(3)),
      () -> assertEquals(5, FibonacciUtils.fibonacci(4)),
      () -> assertEquals(8, FibonacciUtils.fibonacci(5))
    );
  }

  @Test
  void generateFibonacciSequenceWithPositiveN() {
    assertArrayEquals(
      new int[] { 1, 1, 2, 3, 5 },
      FibonacciUtils.generateFibonacciSequence(5)
    );
  }

  @Test
  void generateFibonacciSequenceWithZero() {
    assertArrayEquals(
      new int[] {},
      FibonacciUtils.generateFibonacciSequence(0)
    );
  }

  @Test
  void generateFibonacciSequenceWithNegativeN() {
    assertArrayEquals(
      new int[] {},
      FibonacciUtils.generateFibonacciSequence(-5)
    );
  }

  @Test
  void generateFibonacciSequenceWithOne() {
    assertArrayEquals(
      new int[] { 1 },
      FibonacciUtils.generateFibonacciSequence(1)
    );
  }
}
