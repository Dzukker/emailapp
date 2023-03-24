package emailapp;
import java.util.List;

public class userManager {
    private List<User> userList;
    private User selectedUser;

    public userManager(List<User> userList){
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
