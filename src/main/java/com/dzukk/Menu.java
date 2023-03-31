package com.dzukk;

public class Menu {
    UserManagement um = new UserManagement();
    Input input = new Input();
    PasswordManagement pm = new PasswordManagement();

    public UserRepository userInterface(UserRepository users) {

            switch (input.inputCommand()) {
                case "exit" -> {
                    System.out.println("Exiting the program.");
                    System.exit(0);
                }
                case "commands" ->
                        input.commandList();
                case "select user" ->{
                    users.printUserList(users);
                    users.userSelect(users, input.inputIndex());
                }
                case "new user" ->
                        um.newUser(users);
                case "get email" ->
                        System.out.println(um.getEmail(users));
                case "get password" ->
                        System.out.println(um.getPassword(users));
                case "get mailbox capacity" ->
                        System.out.println(um.getMailboxCapacity(users));
                case "get alternate email" -> {
                        System.out.println(um.getAltEmail(users));
                }
                case "set password" -> {
                    if (users.getSelectedUser() != null) {
                        int index = users.getUserList().indexOf(users.getSelectedUser());
                        users.setSelectedUser(pm.setPassword(users.getSelectedUser(), input.inputPassword()));
                        users.getUserList().set(index, users.getSelectedUser());
                        break;
                    }
                    System.out.println("User not created.");
                }
                case "set mailbox capacity" -> {
                    if (users.getSelectedUser() != null) {
                        int index = users.getUserList().indexOf(users.getSelectedUser());
                        users.setSelectedUser(um.setMailboxCapacity(users.getSelectedUser(), input.inputMailboxCapacity()));
                        users.getUserList().set(index, users.getSelectedUser());
                        break;
                    }
                    System.out.println("User not created.");
                }
                case "set alternate email" -> {
                    if (users.getSelectedUser() != null) {
                        int index = users.getUserList().indexOf(users.getSelectedUser());
                        users.setSelectedUser(um.setAltEmail(users.getSelectedUser(), input.inputEmail()));
                        users.getUserList().set(index, users.getSelectedUser());
                        break;
                    }
                    System.out.println("User not created.");
                }
                default -> System.out.println("Unknown command. Type 'commands' for command list.");
            }
            return users;
    }

}
