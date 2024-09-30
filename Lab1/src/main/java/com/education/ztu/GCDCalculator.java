package com.education.ztu;

public class GCDCalculator {

  public static int findGCD(int a, int b) {
    return a == 0 ? b : findGCD(b % a, a);
  }
}
