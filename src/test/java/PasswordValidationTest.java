package test.java;

import main.java.PasswordManagement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PasswordValidationTest {
    @DisplayName("Inserted valid password")
    @Test
    void testValidPassword() {
        Assertions.assertTrue(PasswordManagement.passwordValidation("Passw0rdte"));
    }

    @DisplayName("Inserted too short password")
    @Test
    void testInvalidPasswordTooShort() {
        assertFalse(PasswordManagement.passwordValidation("Passw0r"));
    }

    @DisplayName("Inserted password with no uppercases")
    @Test
    void testInvalidPasswordNoUppercase() {
        assertFalse(PasswordManagement.passwordValidation("passw0rdtest"));
    }

    @DisplayName("Inserted password with no lowercases")
    @Test
    void testInvalidPasswordNoLowercase() {
        assertFalse(PasswordManagement.passwordValidation("PASSW0RDTEST"));
    }

    @DisplayName("Inserted password with no digits")
    @Test
    void testInvalidPasswordNoDigit() {
        assertFalse(PasswordManagement.passwordValidation("PasswordTest"));
    }
}
