package emailapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    public static UserRepository userInterface(UserRepository users){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command.");
        String option = scanner.nextLine().toLowerCase();

        switch (option) {
            case "exit" -> {
                System.out.println("Exiting the program.");
                System.exit(0);
            }
            case "commands" -> {
                File file = new File("src/emailapp/commands.txt");
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
            case "select user" -> UserManagement.userSelect(users);
            case "new user" -> {
                User newUser = new User("null@null.null", null, null, 0);
                newUser = UserManagement.newEmail(newUser);
                newUser = PasswordManagement.newPassword(newUser);
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
                    users.setSelectedUser(PasswordManagement.changePassword(users.getSelectedUser()));
                    users.getUserList().set(index, users.getSelectedUser());
                    break;
                }
                System.out.println("User not created.");
            }
            case "set mailbox capacity" -> {
                if (users.getSelectedUser() != null) {
                    int index = users.getUserList().indexOf(users.getSelectedUser());
                    users.setSelectedUser(UserManagement.mailboxCapacity(users.getSelectedUser()));
                    users.getUserList().set(index, users.getSelectedUser());
                    break;
                }
                System.out.println("User not created.");
            }
            case "set alternate email" -> {
                if (users.getSelectedUser() != null) {
                    int index = users.getUserList().indexOf(users.getSelectedUser());
                    users.setSelectedUser(UserManagement.setAlterEmail(users.getSelectedUser()));
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
