package com.education.ztu;

public class Task4 {

  public static void main(String[] args) {
    var thread1 = new Thread(
      new RunnableArithmeticProgression(),
      "Thread-1-arithmetic-progression"
    );
    var thread2 = new Thread(
      new RunnableArithmeticProgression(),
      "Thread-2-arithmetic-progression"
    );
    var thread3 = new Thread(
      new RunnableArithmeticProgression(),
      "Thread-3-arithmetic-progression"
    );

    thread1.start();
    thread2.start();
    thread3.start();

    try {
      thread1.join();
      thread2.join();
      thread3.join();
    } catch (InterruptedException e) {
      System.out.println("Main thread interrupted");
      Thread.currentThread().interrupt();
    }

    System.out.println("\nArithmetic progression completed.");
  }
}
