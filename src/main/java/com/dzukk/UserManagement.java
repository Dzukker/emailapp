package com.dzukk;

import java.util.regex.Pattern;

public class UserManagement {
    PasswordManagement pm = new PasswordManagement();
    Input input = new Input();

    public void newUser(UserRepository users){
        User newUser = new User("null@null.null", null, null, 0);
        newUser = newEmail(newUser, input.inputUserData());
        newUser = pm.newPassword(newUser);
        users.setSelectedUser(newUser);
        System.out.println("Completed.");
        users.getUserList().add(users.getSelectedUser());
    }

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

    public User setMailboxCapacity(User currentUser, int newMailboxCapacity){
        System.out.println("Completed.");
        return new User(currentUser.email(), currentUser.password(), currentUser.altEmail(), newMailboxCapacity);
    }

    public User setAltEmail(User currentUser, String emailAlt){

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

    public String getEmail(UserRepository users){
        if (users.getSelectedUser() != null) {
            return users.getSelectedUser().email();

        }
        return "User not created.";
    }

    public String getPassword(UserRepository users){
        if (users.getSelectedUser() != null) {
            System.out.println(users.getSelectedUser().password());
            return users.getSelectedUser().password();
        }
        return "User not created.";
    }

    public String getMailboxCapacity(UserRepository users){
        if (users.getSelectedUser() != null) {
            if (users.getSelectedUser().mailboxCapacity() != 0) {
                return String.valueOf(users.getSelectedUser().mailboxCapacity());
            }
            return "Users mailbox capacity not created.";
        }
        return "User not created.";
    }

    public String getAltEmail(UserRepository users){
        if (users.getSelectedUser() != null) {
            if (users.getSelectedUser().altEmail() != null) {
                return users.getSelectedUser().altEmail();
            }
            return "Users alternate email not created.";
        }
        return "User not created.";
    }
}
