package com.education.ztu;

public class Task5 {

  public static void main(String[] args) {
    var sharedRunnable =
      new RunnableArithmeticProgressionSynchronizationBlock();

    var thread1 = new Thread(
      sharedRunnable,
      "Thread-1-arithmetic-progression-sync-block"
    );
    var thread2 = new Thread(
      sharedRunnable,
      "Thread-2-arithmetic-progression-sync-block"
    );
    var thread3 = new Thread(
      sharedRunnable,
      "Thread-3-arithmetic-progression-sync-block"
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

    System.out.println(
      "\nArithmetic progression with synchronization block completed."
    );
  }
}
