package com.education.ztu;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Task5 {

  private static final String FILE_PATH =
    "directory_for_files/shopping_report.txt";

  public static void main(String[] args) {
    try {
      addProduct("Grapes,Fruit,$2.50", 5);
      addProduct("Carrot,Vegetable,$0.75", 6);
      addProduct("Milk,Dairy,$1.99", 7);

      printFileContents();
    } catch (IOException e) {
      System.err.println("An error occurred: " + e.getMessage());
    }
  }

  private static void addProduct(String product, int position)
    throws IOException {
    try (RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw")) {
      for (int i = 0; i < position - 1; i++) file.readLine();

      var currentPosition = file.getFilePointer();

      var restOfFile = new StringBuilder();
      String line;
      while ((line = file.readLine()) != null) restOfFile
        .append(line)
        .append("\n");

      file.seek(currentPosition);

      file.writeBytes(
        String.format(
          "%3d. %-15s %-15s %15s%n",
          position,
          product.split(",")[0],
          product.split(",")[1],
          product.split(",")[2]
        )
      );
      file.writeBytes(restOfFile.toString());
    }
  }

  private static void printFileContents() throws IOException {
    try (RandomAccessFile file = new RandomAccessFile(FILE_PATH, "r")) {
      String line;
      System.out.println("File contents:");
      while ((line = file.readLine()) != null) System.out.println(line);
    }
  }
}
