package com.education.ztu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Task7 {

  public static void main(String[] args) {
    System.out.println(System.lineSeparator());
    System.out.println("Task 7: (Collections)");

    // Create a list of products using Arrays.asList
    var products = Arrays.asList(
      new Product("Laptop", "Electronics", 999.99),
      new Product("Desk Chair", "Furniture", 149.99),
      new Product("Coffee Maker", "Appliances", 79.99),
      new Product("Smartphone", "Electronics", 599.99),
      new Product("Blender", "Appliances", 39.99)
    );

    // Collections.sort()
    Collections.sort(products, Comparator.comparing(Product::getPrice));
    System.out.println("Sorted by price: " + products);

    // Collections.binarySearch()
    var searchProduct = new Product("", "", 149.99);
    var index = Collections.binarySearch(
      products,
      searchProduct,
      Comparator.comparing(Product::getPrice)
    );
    System.out.println("Product with price 149.99 found at index: " + index);

    // Collections.reverse()
    Collections.reverse(products);
    System.out.println("Reversed: " + products);

    // Collections.shuffle()
    Collections.shuffle(products);
    System.out.println("Shuffled: " + products);

    // Collections.fill()
    var filledList = new ArrayList<>(products);
    Collections.fill(filledList, new Product("Dummy", "Category", 0.0));
    System.out.println("Filled: " + filledList);
    //
    // Collections.max() and Collections.min()
    var maxProduct = Collections.max(
      products,
      Comparator.comparing(Product::getPrice)
    );
    var minProduct = Collections.min(
      products,
      Comparator.comparing(Product::getPrice)
    );
    System.out.println("Most expensive product: " + maxProduct);
    System.out.println("Least expensive product: " + minProduct);
    //
    // Collections.copy()
    var copyList = new ArrayList<>(Collections.nCopies(products.size(), null));
    Collections.copy(copyList, products);
    System.out.println("Copied list: " + copyList);

    // Collections.rotate()
    Collections.rotate(products, 2);
    System.out.println("Rotated by 2: " + products);

    // Collections.checkedList()
    var checkedList = Collections.checkedList(
      new ArrayList<>(products),
      Product.class
    );
    try {
      // this would throw a ClassCastException with non-Product object
      // checkedList.add("Not a product");
    } catch (ClassCastException e) {
      System.out.println("Caught ClassCastException as expected");
    }

    // Collections.frequency()
    var someProductToCheck = products.get(0);
    var frequency = Collections.frequency(products, someProductToCheck);
    System.out.println(
      "Frequency of " + someProductToCheck.getName() + ": " + frequency
    );
  }
}
