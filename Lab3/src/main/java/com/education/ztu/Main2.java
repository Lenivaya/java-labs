package com.education.ztu;

import java.util.ArrayList;
import java.util.List;

import com.education.ztu.game.Employee;
import com.education.ztu.game.Participant;
import com.education.ztu.game.ParticipantComparators;
import com.education.ztu.game.Scholar;
import com.education.ztu.game.Student;
import com.education.ztu.game.Team;

public class Main2 {

  public static void main(String[] args) {
    // write your code here for Task 4

    List<Participant> participants = new ArrayList<>(
      List.of(
        new Scholar("Charlie", 14),
        new Scholar("Alice", 13),
        new Student("Bob", 20),
        new Employee("David", 30),
        new Scholar("Alice", 15)
      )
    );

    System.out.println("Original list:");
    participants.forEach(System.out::println);

    System.out.println("\nSorted by name (natural order):");
    participants.stream().sorted().forEach(System.out::println);

    System.out.println("\nSorted by age:");
    participants
      .stream()
      .sorted(ParticipantComparators.BY_AGE)
      .forEach(System.out::println);

    System.out.println("\nSorted by name then age:");
    participants
      .stream()
      .sorted(ParticipantComparators.BY_NAME_THEN_AGE)
      .forEach(System.out::println);

    // Sorting within a team
    Team<Scholar> scholarTeam = new Team<>("Dragon");
    scholarTeam.addNewParticipants(
      List.of(
        new Scholar("Charlie", 14),
        new Scholar("Alice", 13),
        new Scholar("Bob", 15)
      )
    );

    System.out.println("\nScholar team participants sorted by name:");
    scholarTeam
      .getParticipants()
      .stream()
      .sorted()
      .forEach(System.out::println);
  }
}
