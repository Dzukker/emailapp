package test.java;

import main.java.PasswordManagement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PasswordValidationTest {
    @Test
    void testValidPassword() {
        Assertions.assertTrue(PasswordManagement.passwordValidation("Passw0rdte"));
    }

    @Test
    void testInvalidPasswordTooShort() {
        assertFalse(PasswordManagement.passwordValidation("Passw0r"));
    }

    @Test
    void testInvalidPasswordNoUppercase() {
        assertFalse(PasswordManagement.passwordValidation("passw0rdtest"));
    }

    @Test
    void testInvalidPasswordNoLowercase() {
        assertFalse(PasswordManagement.passwordValidation("PASSW0RDTEST"));
    }

    @Test
    void testInvalidPasswordNoDigit() {
        assertFalse(PasswordManagement.passwordValidation("PasswordTest"));
    }
}
