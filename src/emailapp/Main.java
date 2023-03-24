package emailapp;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
public class Main {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userManager users = new userManager(userList);

        while(true) users = UI(users);
    }

    public static userManager UI(userManager users){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command.");
        String option = scanner.nextLine().toLowerCase();

        switch (option){
            case "exit":
                System.out.println("Exiting the program.");
                System.exit(0);

            case "commands":
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
                break;

            case "select user":
                userSelect(users);
                break;

            case "new user":
                User user = new User("null@null.null", null, null, 0);
                user = newEmail(user);
                user = newPassword(user);
                users.setSelectedUser(user);

                System.out.println("Completed.");

                users.getUserList().add(users.getSelectedUser());
                break;

            case "get email":
                if (users.getSelectedUser()!=null){
                    System.out.println(users.getSelectedUser().email());
                    break;
                }
                System.out.println("User not created.");
                break;

            case "get password":
                if (users.getSelectedUser()!=null){
                    System.out.println(users.getSelectedUser().password());
                    break;
                }
                System.out.println("User not created.");
                break;

            case "get mailbox capacity":
                if (users.getSelectedUser()!=null){
                    if (users.getSelectedUser().mailboxCapacity()!=0) {
                        System.out.println(users.getSelectedUser().mailboxCapacity());
                        break;
                    }
                    System.out.println("Users mailbox capacity not created.");
                    break;
                }
                System.out.println("User not created.");
                break;

            case "get alternate email":
                if (users.getSelectedUser()!=null){
                    if (users.getSelectedUser().altEmail()!=null) {
                        System.out.println(users.getSelectedUser().altEmail());
                        break;
                    }
                    System.out.println("Users alternate email not created.");
                    break;
                }
                System.out.println("User not created.");
                break;

            case "set password":
                if (users.getSelectedUser()!=null) {
                    int index = users.getUserList().indexOf(users.getSelectedUser());
                        users.setSelectedUser(changePassword(users.getSelectedUser()));
                    users.getUserList().set(index, users.getSelectedUser());
                    break;
                }
                System.out.println("User not created.");
                break;

            case "set mailbox capacity":
                if (users.getSelectedUser()!=null) {
                    int index = users.getUserList().indexOf(users.getSelectedUser());
                        users.setSelectedUser(mailboxCapacity(users.getSelectedUser()));
                    users.getUserList().set(index, users.getSelectedUser());
                    break;
                }
                System.out.println("User not created.");
                break;

            case "set alternate email":
                if (users.getSelectedUser()!=null) {
                    int index = users.getUserList().indexOf(users.getSelectedUser());
                        users.setSelectedUser(setAlterEmail(users.getSelectedUser()));
                    users.getUserList().set(index, users.getSelectedUser());
                    break;
                }
                System.out.println("User not created.");
                break;

            default:
                System.out.println("Unknown command. Type 'commands' for command list.");
        }
        return users;
    }

    public static User newEmail(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input first name and last name:");
        String firstname = scanner.next();
        String lastname = scanner.next();

        String department;
        System.out.println("""
                Input the department name (leave blank if none).
                List of departments:
                sales, development, accounting.""");
        scanner.nextLine();
        department = scanner.nextLine().toLowerCase();


        String email;

        if (department.equals("sales") || department.equals("development") || department.equals("accounting")) {
            email = firstname + "." + lastname + "@" + department + ".company.com";
        }else {
            email = firstname + "." + lastname + "@company.com";
        }
        return new User(email, user.password(), user.altEmail(), user.mailboxCapacity());

    }

    public static User newPassword(User user) {
        String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuv";

        StringBuilder password = new StringBuilder(10);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(alphanumericCharacters.length());
            char randomChar = alphanumericCharacters.charAt(randomIndex);
            password.append(randomChar);
        }

        return new User(user.email(), password.toString(), user.altEmail(), user.mailboxCapacity());
    }

    public static User changePassword(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type new password");
        String newPassword = scanner.next();
        System.out.println("Completed.");
        return new User(user.email(), newPassword, user.altEmail(), user.mailboxCapacity());
    }

    public static User mailboxCapacity(User user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the capacity of the mailbox.");
        try{
            int newMailboxCapacity = scanner.nextInt();
            System.out.println("Completed.");
            return new User(user.email(), user.password(), user.altEmail(), newMailboxCapacity);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            return user;
        }
    }

    public static User setAlterEmail(User user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter alternate email.");
        String emailAlt = scanner.next();

        if (isEmailValid(emailAlt)){
            System.out.println("Completed.");
            return new User(user.email(), user.password(), emailAlt, user.mailboxCapacity());
        }
        System.out.println("Incorrect email.");
        return user;
    }

    public static boolean isEmailValid(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+.)+[a-zA-Z]{2,}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public static void userSelect(userManager users) {
        Scanner scanner = new Scanner(System.in);
        if (users.getUserList().isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("Selected user: " + users.getSelectedUser().email());
            System.out.println("Select user:");
            for (int i = 0; i < users.getUserList().size(); i++) {
                System.out.println((i + 1) + ". " + users.getUserList().get(i).email());
            }
            try{
                int selectedUserIndex = scanner.nextInt();
                User selectedUser = users.getUserList().get(selectedUserIndex - 1);
                System.out.println("Selected user: " + selectedUser.email());
                users.setSelectedUser(selectedUser);
            }catch(InputMismatchException e){
                System.out.println("Error, You should enter numbers");
            }catch(IndexOutOfBoundsException e){
                System.out.println("Error, You should enter number in bounds of user list");
            }
        }
    }
}