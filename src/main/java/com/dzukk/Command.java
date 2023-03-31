package com.dzukk;

import java.util.Arrays;

enum Command {
  EXIT("exit"),
  NEW_USER("new user"),
  PRINT_USER("print users"),
  NO_EXIST("invalid option");

  private final String command;

  Command(String command) {
    this.command = command;
  }

  String getCommandName() {
    return this.command;
  }

  static Command from(String cmd) {
    return Arrays.stream(Command.values())
        .filter(c -> c.getCommandName().equalsIgnoreCase(cmd))
        .findFirst()
        .orElse(Command.NO_EXIST);
  }

}
