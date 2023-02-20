package org.example.controller;

import org.example.view.UserLogin;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginController implements ActionListener {
    private UserLogin userRegister;

    public UserLoginController(UserLogin userRegister) {
        this.userRegister = userRegister;
    }

    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        int i = Integer.parseInt(e.getActionCommand());
        switch (i) {
            case 1:
                userRegister.register();
                break;
            case 2:
                userRegister.login();
                break;
        }
    }
}
