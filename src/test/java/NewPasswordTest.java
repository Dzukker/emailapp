package test.java;

import main.java.PasswordManagement;
import main.java.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class NewPasswordTest {
    @DisplayName("newPassword() matches validation")
    @Test
    public void testPasswordGeneration() {
        String password = PasswordManagement.newPassword(new User("test@test.com", null, null, 0))
                .password();
        assertTrue(password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{10}$"));
    }
}
