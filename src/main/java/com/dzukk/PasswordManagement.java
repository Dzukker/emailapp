package com.dzukk;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordManagement {

  private final static String AVAILABLE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuv";
  private final static String EMAIL_PATTERN = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{10}$";

  public User newPassword(User currentUser) {

    List<Character> characterList = AVAILABLE_CHARS.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.toList());
    Collections.shuffle(characterList);

    String password = characterList.stream().limit(10)
        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
        .toString();

    if (validPassword(password)) {
      return new User(currentUser.email(), password, currentUser.altEmail(), currentUser.mailboxCapacity());
    }
    return newPassword(currentUser);
  }

  public User setPassword(User currentUser, String newPassword) {
    if (validPassword(newPassword)) {
      System.out.println("Completed.");
      return new User(currentUser.email(), newPassword, currentUser.altEmail(), currentUser.mailboxCapacity());
    }
    System.out.println("Password should be 10 letters long and contain at least 1 uppercase letter, 1 lowercase letter and 1 number. ");
    return new User(currentUser.email(), currentUser.password(), currentUser.altEmail(), currentUser.mailboxCapacity());
  }

  private boolean validPassword(String password) {
    return password.matches(EMAIL_PATTERN);
  }

  public String newRandomPassword() {
    String password = "";
    while (!validPassword(password)) {
      List<Character> characterList = AVAILABLE_CHARS.chars()
          .mapToObj(c -> (char) c)
          .collect(Collectors.toList());
      Collections.shuffle(characterList);

      password = characterList.stream().limit(10)
          .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
          .toString();
    }
    return password;
  }
}
