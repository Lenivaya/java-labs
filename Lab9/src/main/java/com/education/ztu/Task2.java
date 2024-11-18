package com.education.ztu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task2 {

  private static final String EMPLOYEE_DATA =
    """
    Іванов Іван Іванович, 35 років, Менеджер проектів, 10 років досвіду, м. Київ, вул. Хрещатик 1, ivanov@example.com, +380501234567, 15.03.1988
    Петренко Марія Олександрівна, 28 років, Розробник, 5 років досвіду, м. Львів, вул. Франка 10, petrenko@example.com, +380672345678, 22.07.1995
    Коваленко Олег Петрович, 42 роки, Системний адміністратор, 15 років досвіду, м. Харків, пр. Науки 5, kovalenko@example.com, +380633456789, 10.11.1981
    Сидоренко Анна Василівна, 31 рік, HR-менеджер, 8 років досвіду, м. Одеса, вул. Дерибасівська 7, sydorenko@example.com, +380994567890, 05.09.1992
    Мельник Дмитро Сергійович, 39 років, Бізнес-аналітик, 12 років досвіду, м. Дніпро, пр. Гагаріна 15, melnyk@example.com, +380935678901, 18.12.1984
    """;

  private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(
    "\\+\\d{12}"
  );
  private static final Pattern EMAIL_PATTERN = Pattern.compile(
    "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b"
  );
  private static final Pattern DATE_PATTERN = Pattern.compile(
    "(\\d{2})\\.(\\d{2})\\.(\\d{4})"
  );

  private static final DateTimeFormatter INPUT_DATE_FORMAT =
    DateTimeFormatter.ofPattern("dd.MM.yyyy");
  private static final DateTimeFormatter OUTPUT_DATE_FORMAT =
    DateTimeFormatter.ISO_LOCAL_DATE;

  public static void main(String[] args) {
    System.out.println("\nData before:");
    System.out.println(EMPLOYEE_DATA);

    System.out.println("Phone numbers found:");
    findMatches(PHONE_NUMBER_PATTERN).forEach(System.out::println);

    System.out.println("\nEmails found:");
    findMatches(EMAIL_PATTERN).forEach(System.out::println);

    var updatedData = changeDateFormat();
    System.out.println("\nData with updated date format:");
    System.out.println(updatedData);

    var finalData = changePositions(updatedData);
    System.out.println("\nFinal data with changed positions:");
    System.out.println(finalData);
  }

  private static List<String> findMatches(Pattern pattern) {
    return pattern
      .matcher(EMPLOYEE_DATA)
      .results()
      .map(MatchResult::group)
      .collect(Collectors.toList());
  }

  private static String changeDateFormat() {
    return DATE_PATTERN.matcher(EMPLOYEE_DATA).replaceAll(matchResult -> {
      var date = LocalDate.parse(matchResult.group(), INPUT_DATE_FORMAT);
      return date.format(OUTPUT_DATE_FORMAT);
    });
  }

  private static String changePositions(String data) {
    return data
      .replaceFirst("Менеджер проектів", "Старший менеджер проектів")
      .replaceFirst("Розробник", "Старший розробник")
      .replaceFirst(
        "Системний адміністратор",
        "Провідний системний адміністратор"
      );
  }
}
