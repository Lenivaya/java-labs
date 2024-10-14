package com.education.ztu;

import java.util.List;
import java.util.Locale;

public class Main {

  public static void main(String[] args) {
    System.out.println(System.lineSeparator());
    System.out.println("Task 2:");
    StringAnalyzer.analyze("I learn Java!!!");

    System.out.println(System.lineSeparator());
    System.out.println("Task 3");
    StringBuilderDemoTask2.demonstrate(4, 36);

    System.out.println(System.lineSeparator());
    System.out.println("Task 4");
    var products = List.of(
      new Product("Джинси", "Жіночий одяг", 1500.78),
      new Product("Спідниця", "Жіночий одяг", 1000.56),
      new Product("Краватка", "Чоловічий одяг", 500.78),
      new Product("Футболка", "Унісекс", 300.00),
      new Product("Шкарпетки", "Унісекс", 50.00),
      new Product("Куртка", "Верхній одяг", 2000.00),
      new Product("Шапка", "Аксесуари", 200.00),
      new Product("Рукавички", "Аксесуари", 150.00),
      new Product("Шарф", "Аксесуари", 250.00),
      new Product("Черевики", "Взуття", 1500.00)
    );
    System.out.println(
      ReceiptGenerator.generateReceipt(products, Locale.getDefault())
    );

    System.out.println(System.lineSeparator());
    System.out.println("Task 5");
    System.out.println("Ukrainian Receipt:");
    System.out.println(
      ReceiptGenerator.generateReceipt(products, Locale.of("ua", "UA"))
    );

    System.out.println("\nEnglish Receipt:");
    System.out.println(
      ReceiptGenerator.generateReceipt(products, Locale.of("en", "US"))
    );

    System.out.println("\nFrench Receipt:");
    System.out.println(
      ReceiptGenerator.generateReceipt(products, Locale.of("fr", "FR"))
    );

    System.out.println(System.lineSeparator());
    System.out.println("Task 6");
    DateTimeDemoTask6.demonstrate();
  }
}
