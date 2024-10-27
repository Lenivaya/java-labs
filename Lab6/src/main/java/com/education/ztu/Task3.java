package com.education.ztu;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Task3 {

  private static final String DIRECTORY = "directory_for_files/";

  public static void main(String[] args) {
    var cart = new ArrayList<>(
      List.of(
        new Product("Apple", "Fruit", 1.0),
        new Product("Banana", "Fruit", 0.5),
        new Product("Orange", "Fruit", 0.75)
      )
    );

    var report = ReceiptGenerator.generateReceipt(cart, Locale.US);
    System.out.println("Shopping Report:");
    System.out.println(report);

    var fileName = DIRECTORY + "shopping_report.txt";
    writeReportToFile(report, fileName);
    System.out.println("\nReport written to file: " + fileName);

    System.out.println("\nReading report from file:");
    readReportFromFile(fileName);
  }

  private static void writeReportToFile(String report, String fileName) {
    FileWriter writer = null;
    try {
      writer = new FileWriter(fileName);
      writer.write(report);
    } catch (IOException e) {
      System.err.println("Error writing to file: " + e.getMessage());
    } finally {
      if (writer != null) {
        try {
          writer.close();
        } catch (IOException e) {
          System.err.println("Error closing file: " + e.getMessage());
        }
      }
    }
  }

  private static void readReportFromFile(String fileName) {
    FileReader reader = null;
    Scanner scanner = null;
    try {
      reader = new FileReader(fileName);
      scanner = new Scanner(reader);
      while (scanner.hasNextLine()) {
        System.out.println(scanner.nextLine());
      }
    } catch (IOException e) {
      System.err.println("Error reading from file: " + e.getMessage());
    } finally {
      if (scanner != null) {
        try {
          scanner.close();
        } catch (Exception e) {
          System.err.println("Error closing scanner: " + e.getMessage());
        }
      }
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          System.err.println("Error closing file: " + e.getMessage());
        }
      }
    }
  }
}
