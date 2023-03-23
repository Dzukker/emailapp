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
        User user = null;
        List<User> userList = new ArrayList<>();
        userManager users = new userManager(user, userList);
        while(true){
            users = UI(users);
        }
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
                users.setUser(new User());
                newEmail(users.getUser());
                newPassword(users.getUser());

                System.out.println("Completed.");

                users.getUserList().add(users.getUser());
                users.setSelectedUser(users.getUser());
                break;

            case "get email":
                if (users.getSelectedUser()!=null){
                    System.out.println(users.getSelectedUser().getEmail());
                    break;
                }
                System.out.println("User not created.");
                break;

            case "get password":
                if (users.getSelectedUser()!=null){
                    System.out.println(users.getSelectedUser().getPassword());
                    break;
                }
                System.out.println("User not created.");
                break;

            case "get mailbox capacity":
                if (users.getSelectedUser()!=null){
                    if (users.getSelectedUser().getAltEmail()!=null) {
                        System.out.println(users.getSelectedUser().getMailboxCapacity());
                        break;
                    }
                    System.out.println("Users mailbox capacity not created.");
                    break;
                }
                System.out.println("User not created.");
                break;

            case "get alternate email":
                if (users.getSelectedUser()!=null){
                    if (users.getSelectedUser().getAltEmail()!=null) {
                        System.out.println(users.getSelectedUser().getAltEmail());
                        break;
                    }
                    System.out.println("Users alternate email not created.");
                    break;
                }
                System.out.println("User not created.");
                break;

            case "set password":
                changePassword(users.getSelectedUser());
                break;

            case "set mailbox capacity":
                mailboxCapacity(users.getSelectedUser());
                break;

            case "set alternate email":
                setAlterEmail(users.getSelectedUser() );
                break;

            default:
                System.out.println("Unknown command. Type 'commands' for command list.");
        }
        return users;
    }

    public static void newEmail(User user) {
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
        user.setEmail(email);

    }

    public static void newPassword(User user) {
        String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuv";

        StringBuilder password = new StringBuilder(10);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(alphanumericCharacters.length());
            char randomChar = alphanumericCharacters.charAt(randomIndex);
            password.append(randomChar);
        }

        user.setPassword(password.toString());
    }

    public static void changePassword(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type new password");
        user.setPassword(scanner.next());
        System.out.println("Completed.");
    }

    public static void mailboxCapacity(User user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the capacity of the mailbox.");
        try{
            user.setMailboxCapacity(scanner.nextInt());
            System.out.println("Completed.");
        }catch(InputMismatchException e){
            System.out.println("Error, You should enter numbers");
        }
    }

    public static void setAlterEmail(User user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter alternate email.");
        String emailAlt = scanner.next();

        if (isEmailValid(emailAlt)){
            user.setAltEmail(emailAlt);
            System.out.println("Completed.");
            return;
        }
        System.out.println("Incorrect email.");
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
            System.out.println("Selected user: " + users.getSelectedUser().getEmail());
            System.out.println("Select user:");
            for (int i = 0; i < users.getUserList().size(); i++) {
                System.out.println((i + 1) + ". " + users.getUserList().get(i).getEmail());
            }
            try{
                int selectedUserIndex = scanner.nextInt();
                User selectedUser = users.getUserList().get(selectedUserIndex - 1);
                System.out.println("Selected user: " + selectedUser.getEmail());
                users.setSelectedUser(selectedUser);
            }catch(InputMismatchException e){
                System.out.println("Error, You should enter numbers");
            }catch(IndexOutOfBoundsException e){
                System.out.println("Error, You should enter number in bounds of user list");
            }
        }
    }
}