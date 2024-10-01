package com.education.ztu;

public abstract class Person implements Human {

  private int age;
  private String firstname;
  private Gender gender;
  private String lastName;
  private Location location;

  Person() {}

  Person(
    String firstname,
    String lastName,
    int age,
    Gender gender,
    Location location
  ) {
    this.setFirstname(firstname)
      .setLastName(lastName)
      .setAge(age)
      .setGender(gender)
      .setLocation(location);
  }

  abstract void getOccupation();

  public void getFullInfo() {
    sayName();
    sayAge();
    sayGender();
    sayLocation();
  }

  @Override
  public void sayAge() {
    System.out.println("My age is:" + this.age);
  }

  @Override
  public void sayGender() {
    System.out.println("My gender is:" + this.gender);
  }

  @Override
  public void sayLocation() {
    System.out.println("My location is:" + this.location);
  }

  @Override
  public void sayName() {
    System.out.println("My name is:" + this.firstname + " " + this.lastName);
  }

  // Setters
  public Person setAge(int age) {
    if (age < 0) {
      throw new IllegalArgumentException("Age cannot be negative");
    }
    this.age = age;
    return this;
  }

  public Person setFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public Person setGender(Gender gender) {
    this.gender = gender;
    return this;
  }

  public Person setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Person setLocation(Location location) {
    this.location = location;
    return this;
  }

  // Getters
  public int getAge() {
    return age;
  }

  public String getFirstname() {
    return firstname;
  }

  public Gender getGender() {
    return gender;
  }

  public String getLastName() {
    return lastName;
  }

  public Location getLocation() {
    return location;
  }
}
