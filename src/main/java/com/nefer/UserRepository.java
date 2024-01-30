package com.nefer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserRepository {

    private ArrayList<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
    }

    public void add(User user) {
        this.userList.add(user);
    }

    public User findByName(String name) {
        for (User user : userList) {
            if(user.getName().equals(name)) {
                return user;
            }
        }

        return null;
    }


}
