package org.example;

import org.example.database.RoomData;
import org.example.database.UserData;
import org.example.view.Manage;
import org.example.view.UserLogin;

public class Main {

    public static void main(String[] args) {
        UserData userDB = new UserData();
        RoomData roomDB = new RoomData();
        new UserLogin(userDB);
        new Manage(userDB, roomDB);
    }
}