package com.education.ztu.game;

import java.util.Objects;

public abstract class Participant
  implements Cloneable, Comparable<Participant> {

  private String name;
  private int age;

  public Participant(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public Participant setName(String name) {
    this.name = name;
    return this;
  }

  public int getAge() {
    return age;
  }

  public Participant setAge(int age) {
    this.age = age;
    return this;
  }

  @Override
  public int compareTo(Participant other) {
    return this.name.compareTo(other.name);
  }

  @Override
  public Participant clone() {
    try {
      return (Participant) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Participant participant = (Participant) o;
    return age == participant.age && Objects.equals(name, participant.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }

  @Override
  public String toString() {
    return "name='" + name + "', age=" + age;
  }
}
