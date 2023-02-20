package org.example.database;

import org.example.model.User;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;


public class UserData {
    private final List<User> db = new ArrayList<>();

    public int register(@NotNull User user) {
        if(user.getName().isEmpty() || user.getPassword().isEmpty()) {
            return 0;
        }
        for(User u: db) {
            if(user.getName().equals(u.getName())) {
                return 0;
            }
        }
        db.add(user);
        return 1;
    }

    public int login(@NotNull User user) {
        for (User u:
             db) {
            if(u.getName().equals(user.getName()) && u.getPassword().equals(user.getPassword())) {
                return 1;
            }
        }
        return 0;
    }

    public List<User> getAll() {
        return db;
    }

}
