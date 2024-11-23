package com.education.ztu.game;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a participant in a game or competition.
 * This abstract class provides a basic structure for participants, including a name and age.
 */
public abstract class Participant
  implements Cloneable, Comparable<Participant>, Serializable {

  @Serial
  private static final long serialVersionUID = 2411272869056875360L;

  private String name;

  private int age;

  /**
   * Default constructor required for JAXB XML serialization.
   */
  public Participant() {
    this.name = "";
    this.age = 0;
  }

  /**
   * Constructs a Participant object with the given name and age.
   *
   * @param name the name of the participant
   * @param age  the age of the participant
   */
  public Participant(String name, int age) {
    this.setName(name).setAge(age);
  }

  /**
   * Gets the name of the participant.
   *
   * @return the participant's name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the participant.
   *
   * @param name the name to set
   * @return this Participant instance for method chaining
   */
  public Participant setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Gets the age of the participant.
   *
   * @return the participant's age
   */
  public int getAge() {
    return age;
  }

  /**
   * Sets the age of the participant.
   *
   * @param age the age to set
   * @return this Participant instance for method chaining
   */
  public Participant setAge(int age) {
    this.age = age;
    return this;
  }

  /**
   * Compares this participant to another participant based on their names.
   *
   * @param other the participant to compare with
   * @return a negative integer, zero, or a positive integer as this participant is less than, equal to, or greater than the specified participant
   */
  @Override
  public int compareTo(Participant other) {
    return this.name.compareTo(other.name);
  }

  /**
   * Creates and returns a copy of this participant.
   *
   * @return a copy of this Participant instance
   */
  @Override
  public Participant clone() {
    try {
      return (Participant) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  /**
   * Checks if this participant is equal to another object.
   *
   * @param o the object to compare with
   * @return true if this participant is equal to the specified object; false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Participant participant = (Participant) o;
    return age == participant.age && Objects.equals(name, participant.name);
  }

  /**
   * Returns a hash code value for this participant.
   *
   * @return a hash code value for this Participant instance
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }

  /**
   * Returns a string representation of this participant.
   *
   * @return a string containing the participant's name and age
   */
  @Override
  public String toString() {
    return "name='" + name + "', age=" + age;
  }
}
