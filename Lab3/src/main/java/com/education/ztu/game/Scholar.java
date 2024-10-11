package com.education.ztu.game;

public class Scholar extends Participant {

  public Scholar(String name, int age) {
    super(name, age);
  }

  @Override
  public String toString() {
    return "Scholar{" + super.toString() + "}";
  }
}
