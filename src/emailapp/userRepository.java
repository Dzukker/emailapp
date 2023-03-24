package emailapp;
import java.util.List;

public class userRepository {
    private List<user> userList;
    private user selectedUser;

    public userRepository(List<user> userList){
        this.userList = userList;
    }

    public List<user> getUserList(){
        return this.userList;
    }

    public user getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(user selectedUser) {
        this.selectedUser = selectedUser;
    }
}
