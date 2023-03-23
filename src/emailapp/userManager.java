package emailapp;
import java.util.List;

public class userManager {
    private User user;
    private List<User> userList;
    private User selectedUser;

    public userManager(User user, List<User> userList){
        this.user = user;
        this.userList = userList;
    }

    public User getUser(){
        return this.user;
    }
    public List<User> getUserList(){
        return this.userList;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
}
