package com.wjz.springboot.database;

import com.wjz.springboot.domain.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Database {

    private static List<User> users = null;

    static {
        users = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("Name_" + i);
            users.add(user);
        }
    }

    public static List<User> users() {
        return users;
    }

    public static void save(List<User> users) {
        Database.users = users;
    }
}
