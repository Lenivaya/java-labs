package com.education.ztu.game;

import java.io.Serial;

/**
 * Represents a scholar in the game.
 * This class extends the Participant class and adds specific properties and methods for a scholar.
 *
 * @author Your Name
 */
public class Scholar extends Participant {

  @Serial
  private static final long serialVersionUID = -2603660033459023555L;

  /**
   * Constructs a Scholar object with the given name and age.
   *
   * @param name the name of the scholar
   * @param age  the age of the scholar
   */
  public Scholar(String name, int age) {
    super(name, age);
  }

  /**
   * Returns a string representation of the Scholar object.
   * <p>
   * This method overrides the toString method of the Participant class to include specific details of the Scholar.
   *
   * @return a string representation of the Scholar
   */
  @Override
  public String toString() {
    return "Scholar{" + super.toString() + "}";
  }
}
