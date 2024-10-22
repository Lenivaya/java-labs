package com.education.ztu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task6 {

  public static void main(String[] args) {
    System.out.println(System.lineSeparator());
    System.out.println("Task 6: (HashMap)");

    var productMap = new HashMap<String, Product>();

    // put
    var productsToAdd = List.of(
      new Product("Laptop", "Electronics", 999.99),
      new Product("Desk Chair", "Furniture", 149.99),
      new Product("Coffee Maker", "Appliances", 79.99)
    );
    for (var product : productsToAdd) productMap.put(
      product.getName(),
      product
    );

    // get
    System.out.println("Get 'Laptop': " + productMap.get("Laptop"));

    // containsKey
    System.out.println(
      "Contains key 'Smartphone': " + productMap.containsKey("Smartphone")
    );

    // containsValue
    var productToCheckContains = productsToAdd.getFirst();
    System.out.println(
      "Contains " +
      productToCheckContains.getName() +
      ": " +
      productMap.containsValue(productToCheckContains)
    );

    // putIfAbsent
    var productToPutIfAbsent = new Product("Smartphone", "Electronics", 599.99);
    productMap.putIfAbsent(
      productToPutIfAbsent.getName(),
      productToPutIfAbsent
    );
    System.out.println(
      "After putIfAbsent" + productToPutIfAbsent.getName() + ": " + productMap
    );

    // keySet
    System.out.println("Keys: " + productMap.keySet());

    // values
    System.out.println("Values: " + productMap.values());

    // putAll
    var additionalProducts = Map.of(
      "Blender",
      new Product("Blender", "Appliances", 39.99),
      "Headphones",
      new Product("Headphones", "Electronics", 89.99),
      "Desk Lamp",
      new Product("Desk Lamp", "Furniture", 29.99)
    );
    productMap.putAll(additionalProducts);
    System.out.println("After putAll: " + productMap);

    // remove
    var removedProduct = productMap.remove("Coffee Maker");
    System.out.println("Removed product: " + removedProduct);
    System.out.println("After remove: " + productMap);

    // size
    System.out.println("Size of the map: " + productMap.size());

    // entrySet
    System.out.println();
    System.out.println("Demonstrating entrySet:");
    for (var entry : productMap.entrySet()) {
      var product = entry.getValue();
      System.out.println("Key: " + entry.getKey());
      System.out.println("Value: " + entry.getValue());

      var newPrice = product.getPrice() * 1.1;
      product.setPrice(Math.round(newPrice * 100.0) / 100.0);
      entry.setValue(product);
    }

    System.out.println(
      "\nAfter modifying entries (10% price increase): " + productMap
    );

    // clear
    productMap.clear();
    System.out.println("After clear, is empty: " + productMap.isEmpty());
  }
}
