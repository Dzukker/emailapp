package main.java;

import java.util.regex.Pattern;

public class UserManagement {

    public User newEmail(User currentUser, String[] userData) {
        String email;

//        userData[0] = firstname, userData[0] = lastname, userData[2] = department
        if (userData[2].equals("sales") || userData[2].equals("development") || userData[2].equals("accounting")) {
             email = String.format("%s.%s@%s.company.com", userData[0], userData[1], userData[2]);
        } else {
             email = String.format("%s.%s@company.com", userData[0], userData[1]);
        }
        return new User(email, currentUser.password(), currentUser.altEmail(), currentUser.mailboxCapacity());

    }

    public User mailboxCapacity(User currentUser, int newMailboxCapacity){
        System.out.println("Completed.");
        return new User(currentUser.email(), currentUser.password(), currentUser.altEmail(), newMailboxCapacity);
    }

    public User setAlterEmail(User currentUser, String emailAlt){

            if (emailValidation(emailAlt)) {
                System.out.println("Completed.");
                return new User(currentUser.email(), currentUser.password(), emailAlt, currentUser.mailboxCapacity());
            }
            System.out.println("Incorrect email.");
            return currentUser;
    }

    private boolean emailValidation(String email){
        final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+.)+[a-zA-Z]{2,}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
