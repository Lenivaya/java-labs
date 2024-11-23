package com.education.ztu.game;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a team of participants in a game or competition.
 * This class provides methods for managing team participants, playing against other teams, and cloning teams.
 * It implements the Serializable interface for serialization purposes.
 *
 * @param <T> the type of participant in the team, which must extend the Participant class
 */
public class Team<T extends Participant> implements Serializable {

  @Serial
  private static final long serialVersionUID = 6050068925876207507L;

  private String name;

  private List<T> participants = new ArrayList<>();

  /**
   * Default constructor required for JAXB XML serialization.
   */
  public Team() {
    this.name = "";
  }

  /**
   * Constructs a Team object with the given name.
   *
   * @param name the name of the team
   */
  public Team(String name) {
    this.name = name;
  }

  /**
   * Constructs a Team object by deep cloning another Team object.
   *
   * @param other the Team object to clone
   */
  public Team(Team<T> other) {
    this.setName(other.name).setParticipants(
        other.participants
          .stream()
          .map(participant -> (T) participant.clone())
          .toList()
      );
  }

  /**
   * Creates a deep clone of a given Team object.
   *
   * @param original the Team object to clone
   * @return a deep clone of the original Team object
   */
  public static <T extends Participant> Team<T> deepClone(Team<T> original) {
    return new Team<>(original);
  }

  /**
   * Adds a new participant to the team.
   *
   * @param participant the participant to add
   * @return this Team instance for method chaining
   */
  public Team<T> addNewParticipant(T participant) {
    participants.add(participant);
    return this;
  }

  /**
   * Adds a list of new participants to the team.
   *
   * @param participants the list of participants to add
   * @return this Team instance for method chaining
   */
  public Team<T> addNewParticipants(List<T> participants) {
    this.participants.addAll(participants);
    return this;
  }

  /**
   * Simulates a game between this team and another team, randomly selecting a winner.
   *
   * @param team the opposing team
   * @return the winning team
   */
  public Team<T> playWith(Team<T> team) {
    var winner = new Random().nextBoolean() ? this : team;

    System.out.println("The team " + winner.getName() + " won!");

    return winner;
  }

  /**
   * Returns a string representation of the Team object.
   *
   * @return a string containing the team's name and participants
   */
  @Override
  public String toString() {
    return (
      "Team{" + "name='" + name + "'" + ", participants=" + participants + '}'
    );
  }

  /**
   * Gets the name of the team.
   *
   * @return the team's name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the team.
   *
   * @param name the name to set
   * @return this Team instance for method chaining
   */
  public Team<T> setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Gets the list of participants in the team.
   *
   * @return the list of participants
   */
  public List<T> getParticipants() {
    return participants;
  }

  /**
   * Sets the list of participants in the team.
   *
   * @param participants the list of participants to set
   * @return this Team instance for method chaining
   */
  public Team<T> setParticipants(List<T> participants) {
    this.participants = participants;
    return this;
  }
}
