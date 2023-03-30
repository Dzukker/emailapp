package main.java;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordManagement {
    public User newPassword(User currentUser) {
        final String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuv";

        List<Character> characterList = alphanumericCharacters.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(characterList);

        String password = characterList.stream().limit(10)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        if(passwordValidation(password)){
            return new User(currentUser.email(), password, currentUser.altEmail(), currentUser.mailboxCapacity());
        }
        return newPassword(currentUser);
    }

    public User setPassword(User currentUser, String newPassword){
            if (passwordValidation(newPassword)) {
                System.out.println("Completed.");
                return new User(currentUser.email(), newPassword, currentUser.altEmail(), currentUser.mailboxCapacity());
            }
            System.out.println("Password should be 10 letters long and contain at least 1 uppercase letter, 1 lowercase letter and 1 number. ");
            return new User(currentUser.email(), currentUser.password(), currentUser.altEmail(), currentUser.mailboxCapacity());
    }

    private boolean passwordValidation(String password) {
        final String pattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{10}$";
        return password.matches(pattern);
    }
}
