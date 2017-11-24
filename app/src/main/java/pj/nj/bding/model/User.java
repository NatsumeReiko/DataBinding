package pj.nj.bding.model;

import android.databinding.BaseObservable;

import java.util.ArrayList;
import java.util.List;

public class User extends BaseObservable {


    private final String firstName;
    private final String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            users.add(new User("f" + i, "l" + i));
        }

        return users;

    }


}
