package com.education.ztu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OperationTest {

  @ParameterizedTest
  @MethodSource("provideAdditionArguments")
  @DisplayName("Test addition operation")
  void testAddition(double expected, double[] numbers) {
    assertEquals(expected, Operation.addition(numbers), 0.0001);
  }

  private static Stream<Arguments> provideAdditionArguments() {
    return Stream.of(
      Arguments.of(10.0, new double[] { 1, 2, 3, 4 }),
      Arguments.of(0.0, new double[] {}),
      Arguments.of(5.0, new double[] { 5 })
    );
  }

  @ParameterizedTest
  @MethodSource("provideSubtractionArguments")
  @DisplayName("Test subtraction operation")
  void testSubtraction(double expected, double[] numbers) {
    assertEquals(expected, Operation.subtraction(numbers), 0.0001);
  }

  private static Stream<Arguments> provideSubtractionArguments() {
    return Stream.of(
      Arguments.of(5.0, new double[] { 10, 2, 3 }),
      Arguments.of(0.0, new double[] {}),
      Arguments.of(10.0, new double[] { 10 })
    );
  }

  @ParameterizedTest
  @MethodSource("provideMultiplicationArguments")
  @DisplayName("Test multiplication operation")
  void testMultiplication(double expected, double[] numbers) {
    assertEquals(expected, Operation.multiplication(numbers), 0.0001);
  }

  private static Stream<Arguments> provideMultiplicationArguments() {
    return Stream.of(
      Arguments.of(24.0, new double[] { 2, 3, 4 }),
      Arguments.of(1.0, new double[] {}),
      Arguments.of(7.0, new double[] { 7 })
    );
  }

  @ParameterizedTest
  @MethodSource("provideDivisionArguments")
  @DisplayName("Test division operation")
  void testDivision(double expected, double[] numbers) {
    assertEquals(expected, Operation.division(numbers), 0.0001);
  }

  private static Stream<Arguments> provideDivisionArguments() {
    return Stream.of(
      Arguments.of(10.0, new double[] { 100, 2, 5 }),
      Arguments.of(7.0, new double[] { 7 })
    );
  }

  @Test
  @DisplayName("Test division with no arguments")
  void testDivisionNoArguments() {
    assertThrows(IllegalArgumentException.class, Operation::division);
  }

  @ParameterizedTest
  @MethodSource("provideAverageArguments")
  @DisplayName("Test average operation")
  void testAverage(double expected, double[] numbers) {
    assertEquals(expected, Operation.average(numbers), 0.0001);
  }

  private static Stream<Arguments> provideAverageArguments() {
    return Stream.of(
      Arguments.of(2.5, new double[] { 1, 2, 3, 4 }),
      Arguments.of(0.0, new double[] {}),
      Arguments.of(7.0, new double[] { 7 })
    );
  }

  @ParameterizedTest
  @MethodSource("provideMaximumArguments")
  @DisplayName("Test maximum operation")
  void testMaximum(double expected, double[] numbers) {
    assertEquals(expected, Operation.maximum(numbers), 0.0001);
  }

  private static Stream<Arguments> provideMaximumArguments() {
    return Stream.of(
      Arguments.of(4.0, new double[] { 1, 2, 3, 4 }),
      Arguments.of(Double.NEGATIVE_INFINITY, new double[] {}),
      Arguments.of(5.0, new double[] { 5 })
    );
  }

  @ParameterizedTest
  @MethodSource("provideMinimumArguments")
  @DisplayName("Test minimum operation")
  void testMinimum(double expected, double[] numbers) {
    assertEquals(expected, Operation.minimum(numbers), 0.0001);
  }

  private static Stream<Arguments> provideMinimumArguments() {
    return Stream.of(
      Arguments.of(1.0, new double[] { 1, 2, 3, 4 }),
      Arguments.of(Double.POSITIVE_INFINITY, new double[] {}),
      Arguments.of(5.0, new double[] { 5 })
    );
  }
}
