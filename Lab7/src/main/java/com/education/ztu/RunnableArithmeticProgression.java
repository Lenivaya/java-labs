package com.education.ztu;

public class RunnableArithmeticProgression implements Runnable {

  private static int result = 1;
  private static final int MAX_VALUE = 100;
  private static final long DELAY = 200; // 0.2 seconds

  @Override
  public void run() {
    while (true) {
      int currentValue = getNextValueAndPrint();
      if (currentValue > MAX_VALUE) break;
      try {
        Thread.sleep(DELAY);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        break;
      }
    }
  }

  private static synchronized int getNextValueAndPrint() {
    if (result <= MAX_VALUE) {
      System.out.print(result + " ");
      return result++;
    }
    return result;
  }
}
