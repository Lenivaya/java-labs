package com.education.ztu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DigitSumCalculatorTest {

  @Test
  void testCalculateDigitSum() {
    assertEquals(6, DigitSumCalculator.calculateDigitSum(123));
    assertEquals(15, DigitSumCalculator.calculateDigitSum(12345));
    assertEquals(0, DigitSumCalculator.calculateDigitSum(0));
    assertEquals(1, DigitSumCalculator.calculateDigitSum(1000));
  }

  @Test
  void testCalculateDigitSumWithNegativeNumbers() {
    assertEquals(6, DigitSumCalculator.calculateDigitSum(-123));
    assertEquals(15, DigitSumCalculator.calculateDigitSum(-12345));
  }
}
