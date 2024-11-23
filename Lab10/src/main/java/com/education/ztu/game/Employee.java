package com.education.ztu.game;

import java.io.Serial;

/**
 * Represents an employee in the game.
 * <p>
 * This class extends the Participant class and adds specific properties and methods for an employee.
 *
 * @author Your Name
 */
public class Employee extends Participant {

  @Serial
  private static final long serialVersionUID = -8294076279718742013L;

  public Employee() {
    super();
  }

  /**
   * Constructs an Employee object with the given name and age.
   *
   * @param name the name of the employee
   * @param age  the age of the employee
   */
  public Employee(String name, int age) {
    super(name, age);
  }

  /**
   * Returns a string representation of the Employee object.
   * <p>
   * This method overrides the toString method of the Participant class to include specific details of the Employee.
   *
   * @return a string representation of the Employee
   */
  @Override
  public String toString() {
    return "Employee{" + super.toString() + "}";
  }
}
