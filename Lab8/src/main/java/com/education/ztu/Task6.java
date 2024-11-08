package com.education.ztu;

import java.util.Arrays;

public class Task6 {

  public static void main(String[] args) {
    var numbers1 = new int[] { 5, 2, 8, 1, 9, 3, 7 };
    printMaxNumber(numbers1);

    var numbers2 = new int[] {};
    printMaxNumber(numbers2);
  }

  public static void printMaxNumber(int[] numbers) {
    var result = Arrays.stream(numbers)
      .boxed()
      .max(Integer::compareTo)
      .map(String::valueOf)
      .orElse("Числа відсутні");

    System.out.println("Максимальне значення: " + result);
  }
}
