package com.education.ztu;

public class StringAnalyzer {

  public static void analyze(String input) {
    System.out.println("Analyzing: " + input);
    System.out.println("Last character: " + input.charAt(input.length() - 1));
    System.out.println("Ends with '!!!': " + input.endsWith("!!!"));
    System.out.println(
      "Starts with 'I learn ': " + input.startsWith("I learn ")
    );
    System.out.println("Contains 'Java': " + input.contains("Java"));
    System.out.println("Position of 'Java': " + input.indexOf("Java"));
    System.out.println(
      "After replacing 'a' with 'o': " + input.replace('a', 'o')
    );
    System.out.println("Uppercase: " + input.toUpperCase());
    System.out.println("Lowercase: " + input.toLowerCase());
    System.out.println(
      "After cutting out 'Java': " + input.replace("Java", "")
    );
  }
}
