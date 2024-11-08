package com.education.ztu;

public class Task2 {

  @FunctionalInterface
  interface Printable {
    void print();
  }

  public static void main(String[] args) {
    Printable printable = () ->
      System.out.println("Message written with lambda expression");
    printable.print();
  }
}
