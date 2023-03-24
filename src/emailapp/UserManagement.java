
package emailapp;

        import java.util.InputMismatchException;
        import java.util.Random;
        import java.util.Scanner;
        import java.util.regex.Pattern;

public class UserManagement {

    public static User newEmail(User currentUser) {
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
        return new User(email, currentUser.password(), currentUser.altEmail(), currentUser.mailboxCapacity());

    }

    public static User newPassword(User currentUser) {
        String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuv";

        StringBuilder password = new StringBuilder(10);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(alphanumericCharacters.length());
            char randomChar = alphanumericCharacters.charAt(randomIndex);
            password.append(randomChar);
        }

        return new User(currentUser.email(), password.toString(), currentUser.altEmail(), currentUser.mailboxCapacity());
    }

    public static User changePassword(User currentUser) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type new password");
        String newPassword = scanner.next();
        System.out.println("Completed.");
        return new User(currentUser.email(), newPassword, currentUser.altEmail(), currentUser.mailboxCapacity());
    }

    public static User mailboxCapacity(User currentUser){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the capacity of the mailbox.");
        try{
            int newMailboxCapacity = scanner.nextInt();
            System.out.println("Completed.");
            return new User(currentUser.email(), currentUser.password(), currentUser.altEmail(), newMailboxCapacity);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            return currentUser;
        }
    }

    public static User setAlterEmail(User currentUser){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter alternate email.");
        String emailAlt = scanner.next();

        if (isEmailValid(emailAlt)){
            System.out.println("Completed.");
            return new User(currentUser.email(), currentUser.password(), emailAlt, currentUser.mailboxCapacity());
        }
        System.out.println("Incorrect email.");
        return currentUser;
    }

    public static boolean isEmailValid(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+.)+[a-zA-Z]{2,}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public static void userSelect(UserRepository users) {
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
                int selecteduserIndex = scanner.nextInt();
                User selecteduser = users.getUserList().get(selecteduserIndex - 1);
                System.out.println("Selected user: " + selecteduser.email());
                users.setSelectedUser(selecteduser);
            }catch(InputMismatchException e){
                System.out.println("Error, You should enter numbers");
            }catch(IndexOutOfBoundsException e){
                System.out.println("Error, You should enter number in bounds of user list");
            }
        }
    }
}
