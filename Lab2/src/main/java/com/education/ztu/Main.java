package com.education.ztu;

public class Main {

  public static void main(String[] args) {
    System.out.println(System.lineSeparator());
    System.out.println(
      "Testing classes and interfaces from com.education.ztu package"
    );

    Student student = new Student(
      "John",
      "Doe",
      20,
      Gender.MALE,
      Location.ZHYTOMYR,
      "Computer Science",
      2,
      "ZTU"
    );

    Car teacherCar = new Car();
    teacherCar.brand = "Toyota";

    Car employeeCar = new Car();
    employeeCar.brand = "Honda";

    Teacher teacher = new Teacher(
      "Jane",
      "Smith",
      35,
      Gender.FEMALE,
      Location.KIEV,
      "Mathematics",
      "ZTU",
      teacherCar
    );

    Employee employee = new Employee(
      "Bob",
      "Johnson",
      28,
      Gender.MALE,
      Location.VINNYTSIA,
      "Tech Corp",
      "Software Developer",
      employeeCar
    );

    var anotherEmployee = new Employee(
      "Alice",
      "Johnson",
      28,
      Gender.MALE,
      Location.VINNYTSIA,
      "Tech Corp",
      "Software Developer",
      employeeCar
    );

    System.out.println("Student information:");
    student.getFullInfo();
    System.out.println();

    System.out.println("Teacher information:");
    teacher.getFullInfo();
    System.out.println();

    System.out.println("Employee information:");
    employee.getFullInfo();
    System.out.println();

    System.out.println("Another employee information:");
    anotherEmployee.getFullInfo();
    System.out.println();

    System.out.println("\nDemonstrating new functionality:");

    student.setGpa(3.8);

    teacher.teachNewCourse();
    teacher.teachNewCourse();

    employee.celebrateWorkAnniversary();

    System.out.println();
    System.out.println("There are " + Employee.showCounter() + " employees");

    System.out.println();
    System.out.println("Checking object type using instanceof operator:");

    Human[] humans = { student, teacher, employee };
    for (var human : humans) {
      System.out.print("Object is: ");
      human.whoIAm();

      System.out.println("Checking object type using instanceof operator:");
      if (human instanceof Student) {
        System.out.println("This is a Student");
      } else if (human instanceof Teacher) {
        System.out.println("This is a Teacher");
      } else if (human instanceof Employee) {
        System.out.println("This is an Employee");
      }

      // This could be written using instanceof operator
      // But I'd definitely prefer pattern matching instead
      System.out.println("Checking object type using pattern matching:");
      switch (human) {
        case Student _ -> System.out.println("This is a Student");
        case Teacher _ -> System.out.println("This is a Teacher");
        case Employee _ -> System.out.println("This is an Employee");
        default -> {}
      }

      System.out.println();
    }
  }
}
