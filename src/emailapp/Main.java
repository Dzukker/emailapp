package emailapp;
import java.util.List;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userManager users = new userManager(userList);

        while(true) users = userInterface.UI(users);
    }

}