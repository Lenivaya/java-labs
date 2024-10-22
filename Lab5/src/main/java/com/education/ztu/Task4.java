package com.education.ztu;

import java.util.ArrayDeque;

public class Task4 {

  public static void main(String[] args) {
    System.out.println(System.lineSeparator());
    System.out.println("Task 4: (ArrayDeque)");

    var productDeque = new ArrayDeque<Product>();

    // push
    productDeque.push(new Product("Laptop", "Electronics", 999.99));
    productDeque.push(new Product("Desk Chair", "Furniture", 149.99));
    System.out.println("After push operations: " + productDeque);

    // offerLast
    productDeque.offerLast(new Product("Coffee Maker", "Appliances", 79.99));
    System.out.println("After offerLast: " + productDeque);

    // getFirst
    System.out.println("First product (getFirst): " + productDeque.getFirst());

    // peekLast
    System.out.println("Last product (peekLast): " + productDeque.peekLast());

    // pop
    var poppedProduct = productDeque.pop();
    System.out.println("Popped product: " + poppedProduct);
    System.out.println("Deque after pop: " + productDeque);

    // removeLast
    var removedLastProduct = productDeque.removeLast();
    System.out.println("Removed last product: " + removedLastProduct);
    System.out.println("Deque after removeLast: " + productDeque);

    productDeque.offerLast(new Product("Smartphone", "Electronics", 599.99));
    productDeque.offerLast(new Product("Blender", "Appliances", 39.99));

    // pollLast
    var polledLastProduct = productDeque.pollLast();
    System.out.println("Polled last product: " + polledLastProduct);
    System.out.println("Deque after pollLast: " + productDeque);

    // pollFirst
    var polledFirstProduct = productDeque.pollFirst();
    System.out.println("Polled first product: " + polledFirstProduct);
    System.out.println("Deque after pollFirst: " + productDeque);
  }
}
