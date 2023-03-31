package com.dzukk;

class UserTuiApi {

  private final Input inputMgmt;
  private final UserManager userManager;
  private final static Command CLOSE_APP = Command.EXIT;
  private String currentCommand = "";



  public UserTuiApi(UserManager userManager, Input inputMgmt) {
    this.inputMgmt = inputMgmt;
    this.userManager = userManager;
  }

  public void run() {
    System.out.println("Welcome");
    while (running()) {
      currentCommand = inputMgmt.inputCommand();
      handleCommand(currentCommand);
    }

    System.out.println("Goodbye");
  }

  private void handleCommand(String cmd) {
    Command command = Command.from(cmd);
    switch (command) {
      case NEW_USER -> handleNewUser();
      case PRINT_USER -> printUsers();
      default -> notSupportedOption(cmd);
    }
  }

  private void printUsers() {
    var listOfUsers =  userManager.printUsersList();
    listOfUsers.forEach(System.out::println);
  }

  private void handleNewUser() {
    System.out.println("New user creator");
    System.out.print("First name: ");
    String fn = inputMgmt.readString();
    System.out.print("Last name: ");
    String ln = inputMgmt.readString();
    System.out.print("Department: ");
    String dept = inputMgmt.readString();

    userManager.createNewUser(fn, ln, dept);

  }

  private void notSupportedOption(String cmd) {
    System.out.println("Error: not supported option " + cmd);
  }

  private boolean running() {
    return !CLOSE_APP.getCommandName().equalsIgnoreCase(currentCommand);
  }
}
