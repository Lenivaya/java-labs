package com.education.ztu;

public class Student extends Person {

  public static int counter;

  private int course;
  private String speciality;
  private String university;
  private double gpa;

  Student(
    String firstname,
    String lastName,
    int age,
    Gender gender,
    Location location,
    String speciality,
    int course,
    String university
  ) {
    super(firstname, lastName, age, gender, location);
    this.setSpeciality(speciality).setCourse(course).setUniversity(university);
    counter++;
  }

  Student(String speciality, int course, String university) {
    this.setSpeciality(speciality).setCourse(course).setUniversity(university);
    counter++;
  }

  public int getCourse() {
    return course;
  }

  public Student setCourse(int course) {
    if (course < 1) {
      throw new IllegalArgumentException("Course must be a positive number");
    }
    this.course = course;
    return this;
  }

  public String getSpeciality() {
    return speciality;
  }

  public Student setSpeciality(String speciality) {
    this.speciality = speciality;
    return this;
  }

  public String getUniversity() {
    return university;
  }

  public Student setUniversity(String university) {
    this.university = university;
    return this;
  }

  public double getGpa() {
    return gpa;
  }

  public Student setGpa(double gpa) {
    this.gpa = gpa;
    return this;
  }

  @Override
  public void getOccupation() {
    System.out.println(
      "I am a student of " +
      this.getSpeciality() +
      " at " +
      this.getUniversity()
    );
  }

  @Override
  public void getFullInfo() {
    super.getFullInfo();
    getOccupation();
  }

  public static int showCounter() {
    return counter;
  }

  @Override
  public void whoIAm() {
    System.out.println("I am a student");
  }
}
