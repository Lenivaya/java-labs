package com.education.ztu;

public class RunnableDivisibleByTenFinder implements Runnable {

  private static final int MAX_NUMBER = 10000;
  private static final int DIVISOR = 10;

  @Override
  public void run() {
    try {
      for (int i = 0; i <= MAX_NUMBER; i++) {
        if (i % DIVISOR == 0) {
          System.out.println(Thread.currentThread().getName() + ": " + i);
          Thread.sleep(10); // sleep time to slow down the thread, so we can catch the interrupt
        }
      }
    } catch (InterruptedException e) {
      System.out.println(
        Thread.currentThread().getName() + ": Розрахунок завершено!!!"
      );
    }
  }
}
