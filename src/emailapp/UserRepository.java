package emailapp;
import java.util.List;

public class UserRepository {
    private List<User> userList;
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
