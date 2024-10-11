package com.education.ztu.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> {

  private String name;
  private List<T> participants = new ArrayList<>();

  public Team(String name) {
    this.name = name;
  }

  public Team(Team<T> other) {
    this.setName(other.name).setParticipants(
        other.participants
          .stream()
          .map(participant -> (T) participant.clone())
          .toList()
      );
  }

  public static <T extends Participant> Team<T> deepClone(Team<T> original) {
    return new Team<>(original);
  }

  public Team<T> addNewParticipant(T participant) {
    participants.add(participant);
    return this;
  }

  public Team<T> addNewParticipants(List<T> participants) {
    this.participants.addAll(participants);
    return this;
  }

  public Team<T> playWith(Team<T> team) {
    var winner = new Random().nextBoolean() ? this : team;

    System.out.println("The team " + winner.getName() + " won!");

    return winner;
  }

  @Override
  public String toString() {
    return (
      "Team{" + "name='" + name + "'" + ", participants=" + participants + '}'
    );
  }

  public String getName() {
    return name;
  }

  public Team<T> setName(String name) {
    this.name = name;
    return this;
  }

  public List<T> getParticipants() {
    return participants;
  }

  public Team<T> setParticipants(List<T> participants) {
    this.participants = participants;
    return this;
  }
}
