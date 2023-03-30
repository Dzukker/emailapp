package main.java;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Input {
    public static String inputPassword() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert Password:");
        return scanner.next();
    }

    public static String[] inputUserData(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input first name and last name:");
        String firstname = scanner.next();
        String lastname = scanner.next();
        String department;System.out.println("""
                    Input the department name (leave blank if none).
                    List of departments:
                    sales, development, accounting.""");
        scanner.nextLine();
        department = scanner.nextLine().toLowerCase();

        return new String[]{firstname, lastname, department};
    }

    public static int inputMailboxCapacity(){
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Input mailbox capacity:");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            return 0;
        }
    }

    public static String inputEmail(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter alternate email.");
        return scanner.next();
    }

}
