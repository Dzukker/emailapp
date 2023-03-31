package com.dzukk;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private final Map<String, User> userStorage;
    private User selectedUser;

    public UserRepository(){
        this.userStorage = new HashMap<>();
    }

    public List<User> getUserList(){
        return userStorage.values().stream().toList();
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
    
    public void printUserList(UserRepository users) {
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

    public void addUser(User user) {
        userStorage.put(user.email(), user);
    }
}
