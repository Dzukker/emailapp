package main.java;
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        UserRepository users = new UserRepository(userList);

        while(true) {
            Menu m = new Menu();
            users = m.userInterface(users);
        }
    }

}