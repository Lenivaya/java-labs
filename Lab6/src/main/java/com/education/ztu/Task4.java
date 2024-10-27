package com.education.ztu;

public class Task4 {

  public static void main(String[] args) {
    var sourceTextFile = "directory_for_files/source_text.txt";
    var destinationTextFile = "directory_for_files/copied_text.txt";

    var sourceImageFile = "directory_for_files/source_image.jpg";
    var destinationImageFile = "directory_for_files/copied_image.jpg";

    try {
      FileCopier.copyTextFile(sourceTextFile, destinationTextFile);
      System.out.println("Text file copied successfully.");

      FileCopier.copyImageFile(sourceImageFile, destinationImageFile);
      System.out.println("Image file copied successfully.");
    } catch (Exception e) {
      System.err.println("An error occurred: " + e.getMessage());
    }
  }
}
