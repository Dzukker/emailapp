package com.dzukk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Input {

    Scanner scanner = new Scanner(System.in);

    public String inputPassword() {
        System.out.println("Insert Password:");
        return scanner.next();
    }

    public String[] inputUserData(){
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

    public int inputMailboxCapacity(){
        try{
            System.out.println("Input mailbox capacity:");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            return 0;
        }
    }

    public String inputEmail(){
        System.out.println("Enter alternate email.");
        return scanner.next();
    }

    public int inputIndex(){
        try {
            return scanner.nextInt();
        }catch(NoSuchElementException e){
            System.out.println("Error, You should enter numbers");
            return 0;
        }
    }

    public String inputCommand(){
        try {
            System.out.println("Enter command.");
            return scanner.nextLine().toLowerCase();
        }catch(NoSuchElementException e){
            System.out.println("Exiting the program.");
            System.exit(0);
            return null;
    }
    }

    public void commandList(){
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

    public String readString() {
        return scanner.nextLine();
    }
    public int readNumber() {
        return scanner.nextInt();
    }
}
