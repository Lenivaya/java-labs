package com.education.ztu;

public class Product {

  private String name;
  private String brand;
  private double price;
  private int count;

  public Product(String name, String brand, double price, int count) {
    this.name = name;
    this.brand = brand;
    this.price = price;
    this.count = count;
  }

  public String getName() {
    return name;
  }

  public String getBrand() {
    return brand;
  }

  public double getPrice() {
    return price;
  }

  public int getCount() {
    return count;
  }

  public double getTotalValue() {
    return price * count;
  }

  public Product setName(String name) {
    this.name = name;
    return this;
  }

  public Product setBrand(String brand) {
    this.brand = brand;
    return this;
  }

  public Product setPrice(double price) {
    this.price = price;
    return this;
  }

  public Product setCount(int count) {
    this.count = count;
    return this;
  }

  public Product setTotalValue(double totalValue) {
    this.price = totalValue / count;
    return this;
  }

  @Override
  public String toString() {
    return String.format(
      "Product{name='%s', brand='%s', price=%.2f, count=%d}",
      name,
      brand,
      price,
      count
    );
  }
}
