package com.education.ztu;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Task3 {

  public static void main(String[] args) throws Exception {
    // getting class object in three ways
    Class<?> class1 = CustomClass.class;
    Class<?> class2 = Class.forName("com.education.ztu.CustomClass");
    Class<?> class3 = new CustomClass().getClass();

    System.out.println("Class obtained in three ways:");
    System.out.println(class1);
    System.out.println(class2);
    System.out.println(class3);
    System.out.println();

    System.out.println("Fields:");
    var fields = class1.getDeclaredFields();
    for (var field : fields) System.out.println(
      field.getName() + " - " + field.getType()
    );
    System.out.println();

    System.out.println("Methods:");
    var methods = class1.getDeclaredMethods();
    for (var method : methods) {
      System.out.println(method.getName() + " - " + method.getReturnType());
      for (var param : method.getParameters()) System.out.println(
        "  Parameter: " + param.getName() + " - " + param.getType()
      );
    }
    System.out.println();

    System.out.println("Constructors:");
    var constructors = class1.getDeclaredConstructors();
    for (var constructor : constructors) {
      System.out.println(constructor.getName());
      for (var param : constructor.getParameters()) System.out.println(
        "  Parameter: " + param.getName() + " - " + param.getType()
      );
    }
    System.out.println();

    // create an instance
    Constructor<?> constructor = class1.getConstructor(String.class, int.class);
    Object instance = constructor.newInstance("Test", 42);
    System.out.println("Instance created: " + instance);

    // invoke a method
    Method setNameMethod = class1.getMethod("setName", String.class);
    setNameMethod.invoke(instance, "New Name");
    Method getNameMethod = class1.getMethod("getName");
    String name = (String) getNameMethod.invoke(instance);
    System.out.println("Name after invoking setName: " + name);

    // interaction with a private field
    Field privateField = class1.getDeclaredField("privateData");
    privateField.setAccessible(true);
    privateField.set(instance, "Private data changed");
    String privateData = (String) privateField.get(instance);
    System.out.println("Private field value: " + privateData);
  }
}

class CustomClass {

  public String name;
  public int number;
  private String privateData;

  public CustomClass() {
    this.privateData = "Default private data";
  }

  public CustomClass(String name, int number) {
    this.name = name;
    this.number = number;
    this.privateData = "Default private data";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  private void privateMethod() {
    System.out.println("This is a private method");
  }
}
