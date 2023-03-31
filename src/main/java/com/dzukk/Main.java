package com.dzukk;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    UserRepository users = new UserRepository();
    PasswordManagement passMgmt = new PasswordManagement();
    Input inputMgmt = new Input();
    UserManager userManager = new UserManager(users, passMgmt);

    UserTuiApi tui = new UserTuiApi(userManager, inputMgmt);

    tui.run();

  }

}
