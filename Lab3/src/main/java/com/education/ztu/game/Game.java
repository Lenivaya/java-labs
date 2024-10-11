package com.education.ztu.game;

public class Game {

  public static void main(String[] args) {
    Team<Scholar> scholarTeam = new Team<>("Dragon");
    scholarTeam.addNewParticipant(new Scholar("Ivan", 13));
    scholarTeam.addNewParticipant(new Scholar("Mariya", 15));

    Team<Scholar> scholarTeam2 = new Team<>("Rozumnyky");
    scholarTeam2.addNewParticipant(new Scholar("Sergey", 12));
    scholarTeam2.addNewParticipant(new Scholar("Olga", 14));

    Team<Student> studentTeam = new Team<>("Vpered");
    studentTeam.addNewParticipant(new Student("Mykola", 20));
    studentTeam.addNewParticipant(new Student("Viktoria", 21));

    Team<Student> studentTeam2 = new Team<>("Studenty");
    studentTeam2.addNewParticipant(new Student("Alex", 22));
    studentTeam2.addNewParticipant(new Student("Anna", 19));

    Team<Employee> employeeTeam = new Team<>("Robotyagi");
    employeeTeam.addNewParticipant(new Employee("Andriy", 28));
    employeeTeam.addNewParticipant(new Employee("Oksana", 25));

    Team<Employee> employeeTeam2 = new Team<>("Professionaly");
    employeeTeam2.addNewParticipant(new Employee("Igor", 30));
    employeeTeam2.addNewParticipant(new Employee("Elena", 27));

    // Demonstrate games between teams of the same league
    System.out.println("\nScholar teams playing:");
    scholarTeam.playWith(scholarTeam2);

    System.out.println("\nStudent teams playing:");
    studentTeam.playWith(studentTeam2);

    System.out.println("\nEmployee teams playing:");
    employeeTeam.playWith(employeeTeam2);
    // The following lines would cause compilation errors:
    // scholarTeam.addNewParticipant(new Student("Error", 20));
    // scholarTeam.playWith(studentTeam);
  }
}
