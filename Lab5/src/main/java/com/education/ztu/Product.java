package com.education.ztu;

import java.util.Objects;

public class Product implements Comparable<Product> {

  private String name;
  private String category;
  private double price;

  public Product(String name, String category, double price) {
    this.setName(name).setCategory(category).setPrice(price);
  }

  public String getName() {
    return name;
  }

  public Product setName(String name) {
    this.name = name;
    return this;
  }

  public String getCategory() {
    return category;
  }

  public Product setCategory(String category) {
    this.category = category;
    return this;
  }

  public double getPrice() {
    return price;
  }

  public Product setPrice(double price) {
    this.price = price;
    return this;
  }

  @Override
  public String toString() {
    return (
      "Product{" +
      "name='" +
      name +
      '\'' +
      ", category='" +
      category +
      '\'' +
      ", price=" +
      price +
      '}'
    );
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return (
      Double.compare(product.price, price) == 0 &&
      Objects.equals(name, product.name) &&
      Objects.equals(category, product.category)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, category, price);
  }

  @Override
  public int compareTo(Product other) {
    return Double.compare(this.price, other.price);
  }
}
