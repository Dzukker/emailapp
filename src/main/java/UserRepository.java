package main.java;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;

public class UserRepository {
    private final List<User> userList;
    private User selectedUser;

    public UserRepository(List<User> userList){
        this.userList = userList;
    }

    public List<User> getUserList(){
        return this.userList;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }


    public static void userSelect(UserRepository users,int selectedUserIndex) {
        if (users.getUserList().isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("Selected user: " + users.getSelectedUser().email());
            System.out.println("Select user:");
            for (int i = 0; i < users.getUserList().size(); i++) {
                System.out.println((i + 1) + ". " + users.getUserList().get(i).email());
            }
            try{
                User selecteduser = users.getUserList().get(selectedUserIndex - 1);
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
