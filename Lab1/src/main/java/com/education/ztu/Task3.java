package com.education.ztu;

public class Task3 {

  public static void main(String[] args) {
    System.out.println(System.lineSeparator());
    System.out.println("Task 3 (Args space join)");

    String result = String.join(" ", args);
    System.out.println("Arguments: " + result);
  }
}
