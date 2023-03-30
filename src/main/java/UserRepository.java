package main.java;

import java.util.InputMismatchException;
import java.util.List;

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

    public void PrintUserList(UserRepository users) {
        if (users.getUserList().isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("Selected user: " + users.getSelectedUser().email());
            System.out.println("Select user:");
            for (int i = 0; i < users.getUserList().size(); i++) {
                System.out.println((i + 1) + ". " + users.getUserList().get(i).email());
            }
        }
    }
    public void userSelect(UserRepository users,int selectedUserIndex) {
        try{
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
