package com.dzukk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChangePasswordTest {

  PasswordManagement pm = new PasswordManagement();

  @DisplayName("Valid password inserted")
  @Test
  public void testValidChangePassword() {
    User currentUser = new User("test@test.com", "oldpassword", "alt@test.com", 100);

    User updatedUser = pm.setPassword(currentUser, "newPasswo1");

    assertEquals("newPasswo1", updatedUser.password());
  }

  @DisplayName("Invalid password inserted")
  @Test
  public void testInvalidChangePassword() {
    User currentUser = new User("test@test.com", "oldpassword", "alt@test.com", 100);

    User updatedUser = pm.setPassword(currentUser, "wrongpassword");

    assertEquals("oldpassword", updatedUser.password());
  }

  @DisplayName("Null password inserted")
  @Test
  public void testNullChangePassword() {
    User currentUser = new User("test@test.com", "oldpassword", "alt@test.com", 100);

    User updatedUser = pm.setPassword(currentUser, null);

    assertEquals("oldpassword", updatedUser.password());
  }
}
