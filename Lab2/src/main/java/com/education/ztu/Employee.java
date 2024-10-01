package com.education.ztu;

public class Employee extends Person {

  public static int counter;

  private Car car;
  private String company;
  private String position;
  private int yearsOfExperience;

  Employee(String company, String position, Car car) {
    this.setCompany(company).setPosition(position).setCar(car);
    counter++;
  }

  Employee(
    String firstname,
    String lastName,
    int age,
    Gender gender,
    Location location,
    String company,
    String position,
    Car car
  ) {
    super(firstname, lastName, age, gender, location);
    this.setCompany(company).setPosition(position).setCar(car);
    counter++;
  }

  // Getters
  public Car getCar() {
    return car;
  }

  public String getCompany() {
    return company;
  }

  public String getPosition() {
    return position;
  }

  public int getYearsOfExperience() {
    return yearsOfExperience;
  }

  // Setters
  public Employee setCar(Car car) {
    this.car = car;
    return this;
  }

  public Employee setCompany(String company) {
    this.company = company;
    return this;
  }

  public Employee setPosition(String position) {
    this.position = position;
    return this;
  }

  public Employee setYearsOfExperience(int yearsOfExperience) {
    this.yearsOfExperience = yearsOfExperience;
    return this;
  }

  public void getOccupation() {
    System.out.println(
      "I am an employee of " + this.company + " at " + this.position
    );
  }

  @Override
  public void getFullInfo() {
    super.getFullInfo();
    getOccupation();
    System.out.println("I drive a " + car.brand);
  }

  public static int showCounter() {
    return counter;
  }

  @Override
  public void whoIAm() {
    System.out.println("I am an employee");
  }

  public void celebrateWorkAnniversary() {
    this.yearsOfExperience++;
    System.out.println(
      "Celebrating " + this.yearsOfExperience + " years at the company!"
    );
  }
}
