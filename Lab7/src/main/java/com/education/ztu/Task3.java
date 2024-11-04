package com.education.ztu;

public class Task3 {

  public static void main(String[] args) {
    var thread1 = new Thread(new RunnableDivisibleByTenFinder(), "Thread-1");
    var thread2 = new Thread(new RunnableDivisibleByTenFinder(), "Thread-2");
    var thread3 = new Thread(new RunnableDivisibleByTenFinder(), "Thread-3");

    thread1.start();
    thread2.start();
    thread3.start();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.out.println("Головний потік був перерваний");
      thread1.interrupt();
      thread2.interrupt();
      thread3.interrupt();
    }

    thread1.interrupt();
    thread2.interrupt();
    thread3.interrupt();

    try {
      thread1.join();
      thread2.join();
      thread3.join();
    } catch (InterruptedException e) {
      System.out.println("Очікування завершення потоків було перерване");
      Thread.currentThread().interrupt();
    }

    System.out.println("Всі потоки завершили роботу");
  }
}
