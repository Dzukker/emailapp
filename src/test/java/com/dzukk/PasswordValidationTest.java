package com.dzukk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordValidationTest {
    PasswordManagement pm = new PasswordManagement();
    User currentUser = new User("test@test.com", "oldpassword", "alt@test.com", 100);
    @DisplayName("Inserted valid password")
    @Test
    public void testInvalidPassword() {
        User updatedUser = pm.setPassword(currentUser, "wrongpassword");

        assertEquals("oldpassword", updatedUser.password());
    }

    @DisplayName("Inserted too short password")
    @Test
    public void testShortPassword() {
        User updatedUser = pm.setPassword(currentUser, "short");

        assertEquals("oldpassword", updatedUser.password());
    }

    @DisplayName("Inserted password with no uppercases")
    @Test
    public void testNoUppercasePassword() {
        User updatedUser = pm.setPassword(currentUser, "noupperca1");

        assertEquals("oldpassword", updatedUser.password());
    }

    @DisplayName("Inserted password with no lowercases")
    @Test
    public void testNoLowercasePassword() {
        User updatedUser = pm.setPassword(currentUser, "NOLOWERCA1");

        assertEquals("oldpassword", updatedUser.password());
    }

    @DisplayName("Inserted password with no digits")
    @Test
    public void testNoDigitPassword() {
        User updatedUser = pm.setPassword(currentUser, "NoDigitpas");

        assertEquals("oldpassword", updatedUser.password());
    }
}
