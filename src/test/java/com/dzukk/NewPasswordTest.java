package com.dzukk;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class NewPasswordTest {
    PasswordManagement pm = new PasswordManagement();
    @DisplayName("newPassword() matches validation")
    @Test
    public void testPasswordGeneration() {
        String password = pm.newPassword(new User("test@test.com", null, null, 0))
                .password();
        assertTrue(password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{10}$"));
    }
}
