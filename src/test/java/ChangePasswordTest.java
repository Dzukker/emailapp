package test.java;

import main.java.PasswordManagement;
import main.java.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
public class ChangePasswordTest {

    @DisplayName("Valid password inserted")
    @Test
    public void testValidChangePassword() {
        User currentUser = new User("test@test.com", "oldpassword", "alt@test.com", 100);

        String input = "newPasswo1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        User updatedUser = PasswordManagement.changePassword(currentUser);

        assertEquals("newPasswo1", updatedUser.password());
    }

    @DisplayName("Invalid password inserted")
    @Test
    public void testInvalidChangePassword() {
        User currentUser = new User("test@test.com", "oldpassword", "alt@test.com", 100);

        String input = "newinvalidpassword\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        User updatedUser = PasswordManagement.changePassword(currentUser);

        assertEquals("oldpassword", updatedUser.password());
    }

    @DisplayName("Null password inserted")
    @Test
    public void testNullChangePassword() {
        User currentUser = new User("test@test.com", "oldpassword", "alt@test.com", 100);

        String input = null+"\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        User updatedUser = PasswordManagement.changePassword(currentUser);

        assertEquals("oldpassword", updatedUser.password());
    }
}
