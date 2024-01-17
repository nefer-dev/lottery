package com.nefer;

import java.util.ArrayList;

public class UserRepository {

    private ArrayList<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
    }

    private boolean duplicateUser(User user) {
        return true;
    }

    public void add(User user) {
        this.userList.add(user);
    }
}
