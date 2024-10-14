package com.education.ztu;

public class StringBuilderDemoTask2 {

  public static void demonstrate(int a, int b) {
    StringBuilder sb = new StringBuilder();

    sb
      .append(a)
      .append(" + ")
      .append(b)
      .append(" = ")
      .append(a + b)
      .append("\n")
      .append(a)
      .append(" - ")
      .append(b)
      .append(" = ")
      .append(a - b)
      .append("\n")
      .append(a)
      .append(" * ")
      .append(b)
      .append(" = ")
      .append(a * b)
      .append("\n");

    System.out.println("Original string:");
    System.out.println(sb);

    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) != '=') continue;
      sb.deleteCharAt(i);
      sb.insert(i, "рівно");
      i += "рівно".length() - 1;
    }
    System.out.println(
      "After replacing '=' with 'рівно' using insert() and deleteCharAt():"
    );
    System.out.println(sb);

    sb.replace(0, sb.length(), sb.toString().replace("рівно", "="));
    System.out.println("After replacing 'рівно' back to '=' using replace():");
    System.out.println(sb);

    sb.replace(0, sb.length(), sb.toString().replace("=", "рівно"));
    System.out.println("After replacing '=' with 'рівно' using replace():");
    System.out.println(sb);

    sb.reverse();
    System.out.println("Reversed string:");
    System.out.println(sb);

    System.out.println("Length: " + sb.length());
    System.out.println("Capacity: " + sb.capacity());
  }
}
