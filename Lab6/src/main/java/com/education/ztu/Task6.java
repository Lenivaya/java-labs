package com.education.ztu;

import java.io.File;
import java.io.IOException;

public class Task6 {

  public static final String BASE_DIR = "directory_for_files";
  public static final String INNER_DIR_NAME = "inner_directory";
  public static final String RENAMED_DIR_NAME = "renamed_inner_directory";

  public static void main(String[] args) {
    try {
      // new folder
      var innerDir = new File(BASE_DIR, INNER_DIR_NAME);
      if (innerDir.mkdir()) System.out.println(
        "Created directory: " + innerDir.getName()
      );

      // absolute path of created folder
      System.out.println("Absolute path: " + innerDir.getAbsolutePath());

      // name of parent directory
      System.out.println(
        "Parent directory: " + innerDir.getParentFile().getName()
      );

      // two text files inside inner_directory
      var file1 = new File(innerDir, "file1.txt");
      var file2 = new File(innerDir, "file2.txt");
      file1.createNewFile();
      file2.createNewFile();
      System.out.println(
        "Created files: " + file1.getName() + ", " + file2.getName()
      );

      // delete one file
      if (file1.delete()) System.out.println(
        "Deleted file: " + file1.getName()
      );

      // rename inner_directory to renamed_inner_directory
      var renamedDir = new File(BASE_DIR, RENAMED_DIR_NAME);
      if (innerDir.renameTo(renamedDir)) System.out.println(
        "Renamed directory to: " + renamedDir.getName()
      );

      // list files and folders in directory_for_files
      var baseDirectory = new File(BASE_DIR);
      System.out.println("\nContents of " + BASE_DIR + ":");
      var files = baseDirectory.listFiles();
      for (var file : files) {
        String type = file.isDirectory() ? "Directory" : "File";
        System.out.printf(
          "%-30s %-10s %d bytes%n",
          file.getName(),
          type,
          file.length()
        );
      }
    } catch (IOException e) {
      System.err.println("An error occurred: " + e.getMessage());
    }
  }
}
