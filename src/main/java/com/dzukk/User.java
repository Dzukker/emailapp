package com.dzukk;

public record User(String email, String password, String altEmail, int mailboxCapacity) {

  public User(String email, String password) {
    this(email, password, null, 0);
  }

  @Override
  public String toString() {
    return "User{" +
        "email='" + email + '\'' +
        ", password='*********'" +
        ", altEmail='" + altEmail + '\'' +
        ", mailboxCapacity=" + mailboxCapacity +
        '}';
  }
}

