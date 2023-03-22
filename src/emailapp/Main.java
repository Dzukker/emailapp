package emailapp;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {

    public static String email;
    public static String password;
    public static int mailboxCapacity;
    public static String altEmail;


    public static void main(String[] args) {
        while(true){
            UI();
        }
    }

    public static void UI(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command.");
        String option = scanner.nextLine().toLowerCase();

        switch (option){
            case "exit":
                System.out.println("Exiting the program.");
                System.exit(0);

            case "new account":
                newEmail();
                newPassword();
                System.out.println("Completed.");
                break;

            case "get email":
                if (email==null){
                    System.out.println("No email generated.");
                    break;}
                System.out.println(email);
                break;

            case "get password":
                if (password==null){
                    System.out.println("No password generated.");
                    break;}
                System.out.println(password);
                break;

            case "get mailbox capacity":
                if (mailboxCapacity==0){
                    System.out.println("No mailbox capacity generated.");
                    break;
                }
                System.out.println(mailboxCapacity);
                break;

            case "get alternate email":
                if (altEmail==null){
                    System.out.println("No alternate email generated.");
                    break;}
                System.out.println(altEmail);
                break;

            case "change password":
                changePassword();
                break;

            case "set mailbox capacity":
                mailboxCapacity();
                break;

            case "set alternate email":
                setAlterEmail();
                break;

            default:
                System.out.println("Unknown command.");
        }
    }

    public static void newEmail() {
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


        String emailb;

        if (department.equals("sales") || department.equals("development") || department.equals("accounting")) {
            emailb = firstname + "." + lastname + "@" + department + ".company.com";
        }else {
            emailb = firstname + "." + lastname + "@company.com";
        }
        email = emailb;

    }

    public static void newPassword() {
        String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuv";

        StringBuilder passwordb = new StringBuilder(10);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(alphanumericCharacters.length());
            char randomChar = alphanumericCharacters.charAt(randomIndex);
            passwordb.append(randomChar);
        }

        password = passwordb.toString();
    }

    public static void changePassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type new password");
        password=scanner.next();
        System.out.println("Completed.");
    }

    public static void mailboxCapacity(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the capacity of the mailbox.");
        try{
            mailboxCapacity = scanner.nextInt();
            System.out.println("Completed.");
        }catch(InputMismatchException e){
            System.out.println("Error, You should enter numbers");
        }
    }

    public static void setAlterEmail(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter alternate email.");
        String emailAlt = scanner.next();

        if (isEmailValid(emailAlt)){
            altEmail = emailAlt;
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
}