package com.dzukk;

import java.util.List;

class UserManager {

  private final UserRepository userRepository;
  private final PasswordManagement passMgmt;

  public UserManager(UserRepository users, PasswordManagement passMgmt) {
    this.userRepository = users;
    this.passMgmt = passMgmt;
  }

  public void createNewUser(String fn, String ln, String dept) {
    var mail = generateEmail(fn, ln, dept);
    var pass = passMgmt.newRandomPassword();
    var user = new User(mail, pass);
    userRepository.addUser(user);
  }

  private String generateEmail(String fn, String ln, String dept) {
    var mail = new StringBuilder()
        .append(fn)
        .append(".")
        .append(ln)
        .append("@");

    if (dept != null && !dept.isEmpty()) {
      mail.append(dept).append(".");
    }

    mail.append("company.com");

    return mail.toString();
  }

  public List<User> printUsersList() {
    return userRepository.getUserList();
  }
}
