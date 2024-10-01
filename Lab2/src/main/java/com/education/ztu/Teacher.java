package com.education.ztu;

public class Teacher extends Person {

  public static int counter;

  private Car car;
  private String subject;
  private String university;
  private int coursesTaught;

  Teacher(String subject, String university, Car car) {
    this.setSubject(subject).setUniversity(university).setCar(car);
    counter++;
  }

  Teacher(
    String firstname,
    String lastName,
    int age,
    Gender gender,
    Location location,
    String subject,
    String university,
    Car car
  ) {
    super(firstname, lastName, age, gender, location);
    this.setSubject(subject).setUniversity(university).setCar(car);
    counter++;
  }

  // Getters
  public Car getCar() {
    return car;
  }

  public String getSubject() {
    return subject;
  }

  public String getUniversity() {
    return university;
  }

  public int getCoursesTaught() {
    return coursesTaught;
  }

  // Setters with fluent interface
  public Teacher setCar(Car car) {
    this.car = car;
    return this;
  }

  public Teacher setSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public Teacher setUniversity(String university) {
    this.university = university;
    return this;
  }

  public Teacher setCoursesTaught(int coursesTaught) {
    this.coursesTaught = coursesTaught;
    return this;
  }

  public void getOccupation() {
    System.out.println(
      "I am a teacher of " + this.subject + " at " + this.university
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
    System.out.println("I am a teacher");
  }

  public void teachNewCourse() {
    this.coursesTaught++;
    System.out.println("Now teaching " + this.coursesTaught + " courses");
  }
}
