package com.education.ztu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopier {

  public static void copyTextFile(String sourceFile, String destinationFile)
    throws IOException {
    try (
      BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
      BufferedWriter writer = new BufferedWriter(
        new FileWriter(destinationFile)
      )
    ) {
      String line;
      while ((line = reader.readLine()) != null) {
        writer.write(line);
        writer.newLine();
      }
    }
  }

  public static void copyImageFile(String sourceFile, String destinationFile)
    throws IOException {
    try (
      FileInputStream fis = new FileInputStream(sourceFile);
      FileOutputStream fos = new FileOutputStream(destinationFile)
    ) {
      byte[] buffer = new byte[1024];
      int length;
      while ((length = fis.read(buffer)) > 0) {
        fos.write(buffer, 0, length);
      }
    }
  }
}
