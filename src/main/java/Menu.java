package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
    UserManagement um = new UserManagement();
    Input input = new Input();
    PasswordManagement pm = new PasswordManagement();
    public UserRepository userInterface(UserRepository users) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter command.");
            String option = scanner.nextLine().toLowerCase();

            switch (option) {
                case "exit" -> {
                    System.out.println("Exiting the program.");
                    System.exit(0);
                }
                case "commands" -> {
                    File file = new File("commands.txt");
                    try {
                        Scanner readfile = new Scanner(file);

                        while (readfile.hasNextLine()) {
                            String line = readfile.nextLine();
                            System.out.println(line);
                        }
                        readfile.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("No command list found.");
                    }
                }
                case "select user" -> UserRepository.userSelect(users, input.inputIndex());
                case "new user" -> {
                    User newUser = new User("null@null.null", null, null, 0);
                    newUser = um.newEmail(newUser, input.inputUserData());
                    newUser = pm.newPassword(newUser);
                    users.setSelectedUser(newUser);
                    System.out.println("Completed.");
                    users.getUserList().add(users.getSelectedUser());
                }
                case "get email" -> {
                    if (users.getSelectedUser() != null) {
                        System.out.println(users.getSelectedUser().email());
                        break;
                    }
                    System.out.println("User not created.");
                }
                case "get password" -> {
                    if (users.getSelectedUser() != null) {
                        System.out.println(users.getSelectedUser().password());
                        break;
                    }
                    System.out.println("User not created.");
                }
                case "get mailbox capacity" -> {
                    if (users.getSelectedUser() != null) {
                        if (users.getSelectedUser().mailboxCapacity() != 0) {
                            System.out.println(users.getSelectedUser().mailboxCapacity());
                            break;
                        }
                        System.out.println("Users mailbox capacity not created.");
                        break;
                    }
                    System.out.println("User not created.");
                }
                case "get alternate email" -> {
                    if (users.getSelectedUser() != null) {
                        if (users.getSelectedUser().altEmail() != null) {
                            System.out.println(users.getSelectedUser().altEmail());
                            break;
                        }
                        System.out.println("Users alternate email not created.");
                        break;
                    }
                    System.out.println("User not created.");
                }
                case "set password" -> {
                    if (users.getSelectedUser() != null) {
                        int index = users.getUserList().indexOf(users.getSelectedUser());
                        users.setSelectedUser(pm.changePassword(users.getSelectedUser(), input.inputPassword()));
                        users.getUserList().set(index, users.getSelectedUser());
                        break;
                    }
                    System.out.println("User not created.");
                }
                case "set mailbox capacity" -> {
                    if (users.getSelectedUser() != null) {
                        int index = users.getUserList().indexOf(users.getSelectedUser());
                        users.setSelectedUser(um.mailboxCapacity(users.getSelectedUser(), input.inputMailboxCapacity()));
                        users.getUserList().set(index, users.getSelectedUser());
                        break;
                    }
                    System.out.println("User not created.");
                }
                case "set alternate email" -> {
                    if (users.getSelectedUser() != null) {
                        int index = users.getUserList().indexOf(users.getSelectedUser());
                        users.setSelectedUser(um.setAlterEmail(users.getSelectedUser(), input.inputEmail()));
                        users.getUserList().set(index, users.getSelectedUser());
                        break;
                    }
                    System.out.println("User not created.");
                }
                default -> System.out.println("Unknown command. Type 'commands' for command list.");
            }
            return users;
        }catch(NoSuchElementException e){
            System.out.println("Exiting the program.");
            System.exit(0);
            return users;
        }
    }

}
