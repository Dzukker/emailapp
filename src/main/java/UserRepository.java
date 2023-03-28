package main.java;

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
}
