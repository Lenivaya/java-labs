package com.education.ztu;

public class Task2 {

  public static void main(String[] args) {
    try {
      var myThread = new MyThread("MyCustomThread");

      printThreadInfo("Initial", myThread);

      myThread.setName("UpdatedThreadName");
      myThread.setPriority(Thread.MAX_PRIORITY);

      printThreadInfo("Updated", myThread);

      myThread.start();
      printThreadState("After start", myThread);

      myThread.join();
      printThreadState("After join", myThread);

      var mainThread = Thread.currentThread();
      printMainThreadInfo(mainThread);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.err.println("Thread was interrupted: " + e.getMessage());
    }
  }

  private static void printThreadInfo(String stage, Thread thread) {
    System.out.printf("%s thread info:%n", stage);
    System.out.printf("\tName: %s%n", thread.getName());
    System.out.printf("\tPriority: %d%n", thread.getPriority());
    System.out.printf("\tIs alive? %b%n", thread.isAlive());
    System.out.printf("\tIs daemon? %b%n", thread.isDaemon());
    System.out.printf("\tState: %s%n%n", thread.getState());
  }

  private static void printThreadState(String stage, Thread thread) {
    System.out.printf(
      "%s: %s is in state: %s%n%n",
      stage,
      thread.getName(),
      thread.getState()
    );
  }

  private static void printMainThreadInfo(Thread thread) {
    printThreadInfo("Main", thread);
  }
}
