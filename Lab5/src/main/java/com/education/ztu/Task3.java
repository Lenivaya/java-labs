package com.education.ztu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task3 {

  public static void main(String[] args) {
    System.out.println(System.lineSeparator());
    System.out.println("Task 3: (ArrayList)");

    var productList = new ArrayList<Product>();

    // add
    productList.add(new Product("Laptop", "Electronics", 999.99));
    productList.add(new Product("Desk Chair", "Furniture", 149.99));
    System.out.println("Initial list: " + productList);

    // addAll
    productList.addAll(
      List.of(
        new Product("Coffee Maker", "Appliances", 79.99),
        new Product("Smartphone", "Electronics", 599.99)
      )
    );
    System.out.println("After adding more products: " + productList);

    // get
    System.out.println("Second product: " + productList.get(1));

    // indexOf and lastIndexOf
    var productToFind = new Product("Laptop", "Electronics", 999.99);
    System.out.println(
      "Index of 'Laptop': " + productList.indexOf(productToFind)
    );
    System.out.println(
      "Last index of 'Laptop': " + productList.lastIndexOf(productToFind)
    );

    // iterator
    System.out.println("\nUsing iterator:");
    for (var product : productList) System.out.println(product);

    // listIterator
    System.out.println("\nUsing listIterator in reverse:");
    var listIterator = productList.listIterator(productList.size());
    while (listIterator.hasPrevious()) System.out.println(
      listIterator.previous()
    );

    // remove
    productList.remove(1);
    System.out.println("\nAfter removing second product: " + productList);

    // set
    productList.set(0, new Product("Gaming Laptop", "Electronics", 1499.99));
    System.out.println("\nAfter setting first product: " + productList);

    // sort
    productList.sort(Comparator.comparing(Product::getPrice));
    System.out.println("\nAfter sorting by price: " + productList);

    // subList
    var subList = productList.subList(0, 2);
    System.out.println("\nSublist (first two products): " + subList);

    // contains
    System.out.println(
      "\nContains 'Coffee Maker': " +
      productList.contains(new Product("Coffee Maker", "Appliances", 79.99))
    );

    // isEmpty and size
    System.out.println("Is the list empty? " + productList.isEmpty());
    System.out.println("Size of the list: " + productList.size());

    // retainAll
    var productsToRetain = List.of(productList.get(0), productList.get(1));
    productList.retainAll(productsToRetain);
    System.out.println("\nAfter retaining only two products: " + productList);

    // toArray
    var productArray = productList.toArray(new Product[0]);
    System.out.println("\nAs array: " + Arrays.toString(productArray));

    // clear
    productList.clear();
    System.out.println(
      "\nAfter clearing the list. Is empty? " + productList.isEmpty()
    );
  }
}
