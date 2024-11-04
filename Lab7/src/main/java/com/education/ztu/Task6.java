package com.education.ztu;

import java.util.Scanner;

public class Task6 {

  static class SharedData {

    private String message = null;
    private boolean isNewMessage = false;
  }

  static class Reader implements Runnable {

    private final SharedData sharedData;
    private final Scanner scanner;

    public Reader(SharedData sharedData) {
      this.sharedData = sharedData;
      this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
      while (true) {
        synchronized (sharedData) {
          System.out.println("Enter a message (or 'exit' to quit):");
          String input = scanner.nextLine();

          if ("exit".equalsIgnoreCase(input)) {
            sharedData.message = null;
            sharedData.isNewMessage = true;
            sharedData.notify();
            break;
          }

          sharedData.message = input;
          sharedData.isNewMessage = true;
          sharedData.notify();
        }

        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          break;
        }
      }
      scanner.close();
    }
  }

  static class Printer implements Runnable {

    private final SharedData sharedData;

    public Printer(SharedData sharedData) {
      this.sharedData = sharedData;
    }

    @Override
    public void run() {
      while (true) {
        synchronized (sharedData) {
          while (!sharedData.isNewMessage) {
            try {
              sharedData.wait();
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
              return;
            }
          }

          if (sharedData.message == null) {
            System.out.println("Printer: Exiting.");
            break;
          }

          System.out.println("Printer: " + sharedData.message);
          sharedData.isNewMessage = false;
        }
      }
    }
  }

  public static void main(String[] args) {
    SharedData sharedData = new SharedData();

    Thread readerThread = new Thread(new Reader(sharedData), "ReaderThread");
    Thread printerThread = new Thread(new Printer(sharedData), "PrinterThread");

    readerThread.start();
    printerThread.start();

    try {
      readerThread.join();
      printerThread.join();
    } catch (InterruptedException e) {
      System.out.println("Main thread interrupted");
      Thread.currentThread().interrupt();
    }

    System.out.println("Program finished.");
  }
}
