package com.education.ztu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Task4 {

  public static void main(String[] args) {
    var products = new Product[] {
      new Product("Laptop", "Apple", 1500.0, 10),
      new Product("Phone", "Samsung", 800.0, 20),
      new Product("Tablet", "Apple", 600.0, 15),
      new Product("Smartwatch", "Xiaomi", 150.0, 30),
      new Product("Headphones", "Sony", 200.0, 25),
    };

    // Отримати всі бренди та вивести в консоль. (map)
    System.out.println();
    System.out.println("All brands:");
    Arrays.stream(products)
      .map(Product::getBrand)
      .distinct()
      .forEach(System.out::println);

    // Отримати 2 товари ціна яких менше тисячі. (filter, limit)
    System.out.println();
    System.out.println("2 products with price less than 1000:");
    Arrays.stream(products)
      .filter(p -> p.getPrice() < 1000)
      .limit(2)
      .forEach(System.out::println);

    // Отримати суму всіх видів товарів, що є на складі. (reduce)
    var totalCount = Arrays.stream(products).reduce(
      0,
      (sum, product) -> sum + product.getCount(),
      Integer::sum
    );
    System.out.println();
    System.out.println("Total count of products in stock: " + totalCount);

    // Згрупувати товари по бренду (Collectors.groupingBy())
    System.out.println();
    System.out.println("Products grouped by brand:");
    Arrays.stream(products)
      .collect(Collectors.groupingBy(Product::getBrand))
      .forEach((brand, productList) -> {
        System.out.println(brand + ":");
        productList.forEach(p -> System.out.println("  " + p));
      });

    // Відсортувати товари за зростанням ціни та повернути масив (sorted, Collectors)
    System.out.println();
    System.out.println("Products sorted by price:");
    Arrays.stream(products)
      .sorted(Comparator.comparingDouble(Product::getPrice))
      .forEach(System.out::println);

    // За бажанням дописати функціонал, що використовує інші методи стрімів.
    System.out.println();
    System.out.println("Most expensive product:");
    Arrays.stream(products)
      .max(Comparator.comparingDouble(Product::getPrice))
      .ifPresent(System.out::println);

    double totalProductsValue = Arrays.stream(products)
      .mapToDouble(Product::getTotalValue)
      .sum();
    System.out.println();
    System.out.printf(
      "Total value of all products: %.2f\n",
      totalProductsValue
    );
  }
}
