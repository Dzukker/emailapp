package emailapp;
import java.util.List;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        List<user> userList = new ArrayList<>();
        userRepository users = new userRepository(userList);

        while(true) users = menu.userInterface(users);
    }

}