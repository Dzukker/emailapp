package com.dzukk;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<User> userList = new ArrayList<>();
    UserRepository users = new UserRepository(userList);
    Menu m = new Menu();

    m.userInterface(users);
  }

}
