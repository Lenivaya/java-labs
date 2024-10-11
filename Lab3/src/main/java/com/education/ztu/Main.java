package com.education.ztu;

import java.util.List;

import com.education.ztu.game.Scholar;
import com.education.ztu.game.Student;
import com.education.ztu.game.Team;

public class Main {

  public static void main(String[] args) {
    // write your code here for Task 3

    // creation and adding new participants
    var studentTeam = new Team<Student>("Dragon");
    studentTeam
      .addNewParticipant(new Student("Ivan", 13))
      .addNewParticipant(new Student("Mariya", 15))
      .addNewParticipant(new Student("John", 20))
      .addNewParticipant(new Student("Jane", 21));

    // trying to add non students to students team (won't compile)
    // studentTeam.addNewParticipant(new Scholar("John", 20));

    var scholarTeam = new Team<Student>("Students");
    scholarTeam.addNewParticipants(
      List.of(new Student("John", 20), new Student("Jane", 21))
    );

    var anotherStudentTeam = new Team<Student>("Turtle");
    anotherStudentTeam.addNewParticipants(
      List.of(
        new Student("John", 20),
        new Student("Jane", 21),
        new Student("Jim", 22),
        new Student("Jill", 23)
      )
    );

    System.out.println(System.lineSeparator());
    System.out.println("Playing game between two teams:");

    // game between two teams
    var gameWinner = studentTeam.playWith(anotherStudentTeam);

    // game between two teams with different leagues
    // (won't compile)
    // var gameWinner = scholarTeam.playWith(studentTeam);

    System.out.println(System.lineSeparator());
    System.out.println("Testing deep cloning");

    // cloning
    Team<Student> clonedTeam = Team.deepClone(scholarTeam);
    System.out.println("Original team: " + scholarTeam);
    System.out.println("Cloned team: " + clonedTeam);

    // modifying original team to check whether cloning is deep
    scholarTeam.setName("Dragon (modified)");
    scholarTeam
      .getParticipants()
      .getFirst()
      .setName("Ivan (modified)")
      .setAge(14);
    System.out.println("Original team after modification: " + scholarTeam);
    System.out.println(
      "Cloned team after original was modified: " + clonedTeam
    );

    // equals & hashCode
    System.out.println(System.lineSeparator());
    System.out.println("Testing equals & hashCode");

    Scholar ivan1 = new Scholar("Ivan", 13);
    Scholar ivan2 = new Scholar("Ivan", 13);
    Scholar mariya = new Scholar("Mariya", 15);

    System.out.println("ivan1 equals ivan2: " + ivan1.equals(ivan2));
    System.out.println("ivan1 equals mariya: " + ivan1.equals(mariya));
    System.out.println("ivan1 hashCode: " + ivan1.hashCode());
    System.out.println("ivan2 hashCode: " + ivan2.hashCode());
    System.out.println("mariya hashCode: " + mariya.hashCode());

    // toString
    System.out.println("ivan1 toString: " + ivan1);
    System.out.println("mariya toString: " + mariya);
  }
}
