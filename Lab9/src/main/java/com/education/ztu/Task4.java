package com.education.ztu;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Task4 {

  public static void main(String[] args) {
    Class<?> annotatedClass = AnnotatedClass.class;

    System.out.println("Annotated methods:");
    for (var method : annotatedClass.getDeclaredMethods()) {
      if (method.isAnnotationPresent(CustomAnnotation.class)) {
        CustomAnnotation annotation = method.getAnnotation(
          CustomAnnotation.class
        );
        System.out.println("Method: " + method.getName());
        System.out.println("  Value: " + annotation.value());
        System.out.println("  Count: " + annotation.count());
        System.out.println("  Tags: " + String.join(", ", annotation.tags()));
      }
    }
  }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CustomAnnotation {
  String value() default "Default value";

  int count() default 0;

  String[] tags() default {};
}

class AnnotatedClass {

  @CustomAnnotation(
    value = "Custom method",
    count = 5,
    tags = { "tag1", "tag2" }
  )
  public void annotatedMethod1() {
    //
  }

  @CustomAnnotation(count = 10)
  public void annotatedMethod2() {
    //
  }

  public void nonAnnotatedMethod() {
    //
  }
}
