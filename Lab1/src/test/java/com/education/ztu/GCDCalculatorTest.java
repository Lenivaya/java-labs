package com.education.ztu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GCDCalculatorTest {

  @Test
  void testGCD() {
    assertEquals(6, GCDCalculator.findGCD(54, 24));
    assertEquals(1, GCDCalculator.findGCD(17, 13));
    assertEquals(12, GCDCalculator.findGCD(36, 60));

    assertEquals(1, GCDCalculator.findGCD(1, 1)); // both numbers are 1
    assertEquals(0, GCDCalculator.findGCD(0, 0)); // both numbers are 0
    assertEquals(5, GCDCalculator.findGCD(0, 5)); // one number is 0
    assertEquals(5, GCDCalculator.findGCD(5, 0)); // one number is 0
    assertEquals(1, GCDCalculator.findGCD(1, 0)); // one number is 1
    assertEquals(1, GCDCalculator.findGCD(0, 1)); // one number is 1
  }
}
