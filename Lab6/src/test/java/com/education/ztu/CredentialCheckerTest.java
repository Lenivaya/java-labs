package com.education.ztu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CredentialCheckerTest {

  @Test
  @DisplayName("Valid credentials should pass")
  void validCredentialsShouldPass() {
    assertTrue(
      CredentialChecker.checkCredentials(
        "validLogin",
        "validPass_123",
        "validPass_123"
      )
    );
  }

  @ParameterizedTest
  @DisplayName("Invalid logins should fail")
  @CsvSource(
    {
      "invalid login, validPass_123, validPass_123, 'Login contains space'",
      "thisLoginIsTooLongToBeValid, validPass_123, validPass_123, 'Login is too long'",
      "login@invalid, validPass_123, validPass_123, 'Login contains invalid character'",
      ", validPass_123, validPass_123, 'Login is empty'",
    }
  )
  void invalidLoginsShouldFail(
    String login,
    String password,
    String confirmPassword,
    String testCase
  ) {
    assertFalse(
      CredentialChecker.checkCredentials(login, password, confirmPassword),
      testCase
    );
  }

  @ParameterizedTest
  @DisplayName("Invalid passwords should fail")
  @CsvSource(
    {
      "validLogin, short, short, 'Password is too short'",
      "validLogin, thisPasswordIsTooLongToBeValid, thisPasswordIsTooLongToBeValid, 'Password is too long'",
      "validLogin, invalid@Pass, invalid@Pass, 'Password contains invalid character'",
      "validLogin, , , 'Password is empty'",
      "validLogin, validPass_123, differentPass_123, 'Passwords do not match'",
    }
  )
  void invalidPasswordsShouldFail(
    String login,
    String password,
    String confirmPassword,
    String testCase
  ) {
    assertFalse(
      CredentialChecker.checkCredentials(login, password, confirmPassword),
      testCase
    );
  }

  @Test
  @DisplayName("Login with maximum allowed length should pass")
  void loginWithMaxLengthShouldPass() {
    assertTrue(
      CredentialChecker.checkCredentials(
        "abcdefghijklmnopqrs",
        "validPass_123",
        "validPass_123"
      )
    );
  }

  @Test
  @DisplayName("Password with maximum allowed length should pass")
  void passwordWithMaxLengthShouldPass() {
    assertTrue(
      CredentialChecker.checkCredentials(
        "validLogin",
        "abcdefghijklmnopqrs",
        "abcdefghijklmnopqrs"
      )
    );
  }

  @Test
  @DisplayName("Login with only numbers should pass")
  void loginWithOnlyNumbersShouldPass() {
    assertTrue(
      CredentialChecker.checkCredentials(
        "123456789",
        "validPass_123",
        "validPass_123"
      )
    );
  }

  @Test
  @DisplayName("Password with only numbers should pass")
  void passwordWithOnlyNumbersShouldPass() {
    assertTrue(
      CredentialChecker.checkCredentials("validLogin", "123456789", "123456789")
    );
  }

  @Test
  @DisplayName("Login with underscore should pass")
  void loginWithUnderscoreShouldPass() {
    assertTrue(
      CredentialChecker.checkCredentials(
        "valid_login",
        "validPass_123",
        "validPass_123"
      )
    );
  }

  @Test
  @DisplayName("Password with underscore should pass")
  void passwordWithUnderscoreShouldPass() {
    assertTrue(
      CredentialChecker.checkCredentials(
        "validLogin",
        "valid_pass_123",
        "valid_pass_123"
      )
    );
  }
}
