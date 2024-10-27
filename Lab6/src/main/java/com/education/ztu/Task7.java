package com.education.ztu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Task7 {

  private static final String DIRECTORY_PATH = "directory_for_files";
  private static final String ARCHIVE_NAME = "directory_for_files.zip";

  public static void main(String[] args) {
    try {
      createArchive(DIRECTORY_PATH, ARCHIVE_NAME);
      listArchiveContents(ARCHIVE_NAME);
    } catch (IOException e) {
      System.err.println("An error occurred: " + e.getMessage());
    }
  }

  private static void createArchive(String directoryPath, String archiveName)
    throws IOException {
    var directory = new File(directoryPath);
    var files = directory.listFiles();

    if (files == null || files.length == 0) {
      System.out.println("No files to archive in " + directoryPath);
      return;
    }

    try (
      var fos = new FileOutputStream(archiveName);
      var zos = new ZipOutputStream(fos)
    ) {
      for (var file : files) {
        if (!file.isDirectory()) {
          addToArchive(file, zos);
        }
      }

      System.out.println("Archive created: " + archiveName);
    }
  }

  private static void addToArchive(File file, ZipOutputStream zos)
    throws IOException {
    try (var fis = new FileInputStream(file)) {
      var zipEntry = new ZipEntry(file.getName());
      zos.putNextEntry(zipEntry);

      var buffer = new byte[1024];
      int length;
      while ((length = fis.read(buffer)) > 0) zos.write(buffer, 0, length);

      zos.closeEntry();
    }
  }

  private static void listArchiveContents(String archiveName)
    throws IOException {
    try (
      var fis = new FileInputStream(archiveName);
      var zis = new ZipInputStream(fis)
    ) {
      ZipEntry zipEntry;
      System.out.println("\nContents of " + archiveName + ":");
      while ((zipEntry = zis.getNextEntry()) != null) {
        System.out.println(zipEntry.getName());
        zis.closeEntry();
      }
    }
  }
}
