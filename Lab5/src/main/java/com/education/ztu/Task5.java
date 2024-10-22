package com.education.ztu;

import java.util.Set;
import java.util.TreeSet;

public class Task5 {

  public static void main(String[] args) {
    System.out.println(System.lineSeparator());
    System.out.println("Task 5: (TreeSet)");

    var productSet = new TreeSet<Product>();

    // add
    productSet.add(new Product("Laptop", "Electronics", 999.99));
    productSet.addAll(
      Set.of(
        new Product("Desk Chair", "Furniture", 149.99),
        new Product("Coffee Maker", "Appliances", 79.99),
        new Product("Smartphone", "Electronics", 599.99),
        new Product("Blender", "Appliances", 39.99)
      )
    );
    System.out.println("TreeSet after adding products: " + productSet);

    // first
    System.out.println("First product: " + productSet.first());

    // last
    System.out.println("Last product: " + productSet.last());

    // headSet (products below $100)
    System.out.println(
      "Products below $100: " + productSet.headSet(new Product("", "", 100.0))
    );

    // subSet (products between $50 and $200)
    System.out.println(
      "Products between $50 and $200: " +
      productSet.subSet(new Product("", "", 50.0), new Product("", "", 200.0))
    );

    // tailSet (products from $200 onwards)
    System.out.println(
      "Products from $200 onwards: " +
      productSet.tailSet(new Product("", "", 200.0))
    );

    // ceiling
    System.out.println(
      "Ceiling for $300: " + productSet.ceiling(new Product("", "", 300.0))
    );

    // floor
    System.out.println(
      "Floor for $300: " + productSet.floor(new Product("", "", 300.0))
    );

    // higher
    System.out.println(
      "Higher than $300: " + productSet.higher(new Product("", "", 300.0))
    );

    // lower
    System.out.println(
      "Lower than $300: " + productSet.lower(new Product("", "", 300.0))
    );

    // pollFirst
    System.out.println("Polled first: " + productSet.pollFirst());
    System.out.println("Set after pollFirst: " + productSet);

    // pollLast
    System.out.println("Polled last: " + productSet.pollLast());
    System.out.println("Set after pollLast: " + productSet);

    // descendingSet
    System.out.println("Descending set: " + productSet.descendingSet());
  }
}
