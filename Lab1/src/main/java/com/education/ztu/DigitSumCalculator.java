package com.education.ztu;

public class DigitSumCalculator {

  public static int calculateDigitSum(int number) {
    number = Math.abs(number);

    int digitSum = 0;
    while (number > 0) {
      digitSum += number % 10;
      number /= 10;
    }

    return digitSum;
  }
}
