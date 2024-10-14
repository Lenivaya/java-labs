package com.education.ztu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemoTask6 {

  public static void demonstrate() {
    var labStart = LocalDateTime.of(2024, 10, 13, 11, 30);

    System.out.println("Lab Start: " + labStart);
    System.out.println("Day of week: " + labStart.getDayOfWeek());
    System.out.println("Day of year: " + labStart.getDayOfYear());
    System.out.println("Month: " + labStart.getMonth());
    System.out.println("Year: " + labStart.getYear());
    System.out.println("Hour: " + labStart.getHour());
    System.out.println("Minute: " + labStart.getMinute());
    System.out.println("Second: " + labStart.getSecond());

    System.out.println("Is leap year: " + labStart.toLocalDate().isLeapYear());

    LocalDateTime now = LocalDateTime.now();
    System.out.println("\nCurrent time: " + now);

    System.out.println(
      "Is current time after lab start: " + now.isAfter(labStart)
    );
    System.out.println(
      "Is current time before lab start: " + now.isBefore(labStart)
    );

    var modified = now
      .plusDays(7)
      .minusHours(3)
      .withMinute(0)
      .withSecond(0);
    System.out.println("\nModified date and time: " + modified);

    var formatter = DateTimeFormatter.ofPattern(
      "dd.MM.yyyy HH:mm:ss"
    );
    System.out.println(
      "Formatted date and time: " + modified.format(formatter)
    );
  }
}
