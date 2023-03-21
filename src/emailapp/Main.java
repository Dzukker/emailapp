package emailapp;
import java.util.Random;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input first name and last name:");
        String firstname = scanner.next();
        String lastname = scanner.next();

        System.out.println("Input the department name");
        String department = scanner.next();

        System.out.print(getEmail(firstname, lastname, department));
    }

    public static String getEmail(String firstname, String lastname, String department) {

        if (!department.equals(null)) {
            String email = firstname + "." + lastname + "@" + department + ".company.com";
            return email;
        }
        String email = firstname + "." + lastname + "@company.com";
        return email;
    }
}