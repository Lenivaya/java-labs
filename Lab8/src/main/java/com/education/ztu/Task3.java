package com.education.ztu;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Task3 {

  public static void main(String[] args) {
    // a) Predicates
    Predicate<String> isNumeric = s -> s.matches("-?\\d+(\\.\\d+)?");
    Predicate<String> isNotEmpty = s -> !s.isEmpty();
    Predicate<String> isValidNumber = isNotEmpty.and(isNumeric);

    System.out.println("a) Predicates:");
    System.out.println("'123' is numeric: " + isValidNumber.test("123"));
    System.out.println("'-12.34' is numeric: " + isValidNumber.test("-12.34"));
    System.out.println("'abc' is numeric: " + isValidNumber.test("abc"));
    System.out.println("'' is numeric: " + isValidNumber.test(""));

    // b) Consumers
    Consumer<String> printStartTime = startTime ->
      System.out.println("Пара почалася о " + startTime);
    Consumer<String> printEndTime = startTime -> {
      var start = LocalTime.parse(
        startTime,
        DateTimeFormatter.ofPattern("H:mm")
      );
      var end = start.plusMinutes(80);
      System.out.println(
        "Пара закінчилася о " + end.format(DateTimeFormatter.ofPattern("H:mm"))
      );
    };
    Consumer<String> printLessonInfo = printStartTime.andThen(printEndTime);

    System.out.println("\nb) Виведення інформації про пару:");
    printLessonInfo.accept("8:30");
    System.out.println();
    printLessonInfo.accept("10:00");

    // c) Supplier
    Supplier<String> upperCaseSentence =
      "sentence that will be printed in uppercase"::toUpperCase;

    System.out.println("\nc) Виведення речення у верхньому регістрі:");
    System.out.println(upperCaseSentence.get());

    // d) Function
    Function<String, Integer> multiplyNumbers = s ->
      Arrays.stream(s.split("\\s+"))
        .mapToInt(Integer::parseInt)
        .reduce(1, (a, b) -> a * b);

    System.out.println("\nd) Обчислення добутку чисел з рядка:");
    System.out.println(
      "Добуток чисел '2 3 4': " + multiplyNumbers.apply("2 3 4")
    );
    System.out.println(
      "Добуток чисел '1 5 10 2': " + multiplyNumbers.apply("1 5 10 2")
    );
  }
}
