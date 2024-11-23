package com.education.ztu.game;

import java.io.Serial;

/**
 * Represents a student in the game.
 * This class extends the Participant class and adds specific properties and methods for a student.
 *
 * @author Your Name
 */
public class Student extends Participant {

  @Serial
  private static final long serialVersionUID = -1883718044099012949L;

  /**
   * Constructs a Student object with the given name and age.
   *
   * @param name the name of the student
   * @param age the age of the student
   */
  public Student(String name, int age) {
    super(name, age);
  }

  /**
   * Returns a string representation of the Student object.
   *
   * This method overrides the toString method of the Participant class to include specific details of the Student.
   *
   * @return a string representation of the Student
   */
  @Override
  public String toString() {
    return "Student{" + super.toString() + "}";
  }
}
