package com.education.ztu;

import java.util.regex.Pattern;

public class CredentialChecker {

  private static final Pattern LOGIN_PATTERN = Pattern.compile(
    "^[a-zA-Z0-9_]{3,19}$"
  );

  private static final Pattern PASSWORD_PATTERN = Pattern.compile(
    "^[a-zA-Z0-9_]{8,19}$"
  );

  public static boolean checkCredentials(
    String login,
    String password,
    String confirmPassword
  ) {
    try {
      validateLogin(login);
      validatePassword(password, confirmPassword);
      return true;
    } catch (WrongLoginException | WrongPasswordException e) {
      System.err.println("Credential check failed: " + e.getMessage());
      return false;
    }
  }

  private static void validateLogin(String login) throws WrongLoginException {
    if (login == null || login.isEmpty()) throw new WrongLoginException(
      "Login is empty or null"
    );
    if (!LOGIN_PATTERN.matcher(login).matches()) throw new WrongLoginException(
      "Invalid login format or length (must be 8-19 characters)"
    );
  }

  private static void validatePassword(String password, String confirmPassword)
    throws WrongPasswordException {
    if (
      password == null || password.isEmpty()
    ) throw new WrongPasswordException("Password is empty or null");
    if (
      !PASSWORD_PATTERN.matcher(password).matches()
    ) throw new WrongPasswordException(
      "Invalid password format or length (must be 8-19 characters)"
    );
    if (!password.equals(confirmPassword)) throw new WrongPasswordException(
      "Password and confirmation do not match"
    );
  }
}
