package com.education.ztu;

public class MyThread extends Thread {

  private static final int REPEAT_COUNT = 100;

  public MyThread(String name) {
    super(name);
  }

  @Override
  public void run() {
    for (int i = 0; i < REPEAT_COUNT; i++) {
      System.out.println("Я люблю програмувати!!!");
    }
  }
}
