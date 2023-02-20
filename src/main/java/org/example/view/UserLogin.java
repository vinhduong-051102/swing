package org.example.view;

import org.example.controller.UserLoginController;
import org.example.database.UserData;
import org.example.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserLogin extends JFrame {
    private UserData userData;
    // khai bao wrapper
    private JPanel mainPanel;
    private JPanel userNamePanel;
    private JPanel passwordPanel;
    private JPanel buttonSubmitPanel;
    // khai bao label
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    // khai bao text field
    private JTextField userNameField;
    private JPasswordField passwordField;
    // khai bao button submit
    private JButton buttonSubmit;
    private JButton buttonRegister;
    private JButton loginBtn = new JButton();
    // khai bao dialog
    private JDialog dialog;
    public UserLogin(UserData userData) {
        this.userData = userData;
        ActionListener ac = new UserLoginController(this);
        // constants
        String LABEL_USERNAME = "Tên đăng nhập";
        String LABEL_PASSWORD = "Mật khẩu";
        String LABEL_SUBMIT_BUTTON = "Đăng nhập";
        String LABEL_REGISTER_BUTTON = "Đăng ký";

        // khai bao thuoc tinh co ban cho main frame
        setTitle("Form đăng nhập");
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));

        // khoi tao cac thuoc tinh co ban cho cac components
        // --- Jpanel
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3,1));

        userNamePanel = new JPanel();
        userNamePanel.setLayout(new GridLayout(2, 1));

        passwordPanel = new JPanel();
        passwordPanel.setLayout(new GridLayout(2,1));

        buttonSubmitPanel = new JPanel();
        buttonSubmitPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // --- JLabel
        userNameLabel = new JLabel();
        passwordLabel = new JLabel();
        userNameLabel.setText(LABEL_USERNAME);
        passwordLabel.setText(LABEL_PASSWORD);

        // --- JTextField and JPasswordField
        userNameField = new JTextField();
        userNameField.setPreferredSize(new Dimension(400, 40));
        passwordField = new JPasswordField();

        // --- JButton
        buttonSubmit = new JButton();
        buttonSubmit.setText(LABEL_SUBMIT_BUTTON);
        buttonSubmit.setActionCommand("2");
        loginBtn.setActionCommand("2");
        buttonRegister = new JButton();
        buttonRegister.setText(LABEL_REGISTER_BUTTON);
        buttonRegister.setActionCommand("1");

        // add cac components
        userNamePanel.add(userNameLabel);
        userNamePanel.add(userNameField);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        buttonSubmitPanel.add(buttonSubmit);
        buttonSubmitPanel.add(buttonRegister);
        mainPanel.add(userNamePanel);
        mainPanel.add(passwordPanel);
        mainPanel.add(buttonSubmitPanel);
        add(mainPanel);
        // add action listener
        buttonSubmit.addActionListener(ac);
        loginBtn.addActionListener(ac);
        buttonRegister.addActionListener(ac);

        // show frame
        setVisible(true);

    }
    public void register() {
        int result = userData.register(new User(userNameField.getText(), String.valueOf(passwordField.getPassword())));
        dialog = new JDialog(this, "Thông báo");
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 40));
        JLabel label = new JLabel();
        String SUCCESS_LABEL = "Đăng ký thành công";
        String FAULT_LABEL = "Đăng ký thất bại";
        String LABEL_BUTTON_SUCCESS = "Đăng nhập";
        dialog.setSize(300, 300);
        dialog.setLocationRelativeTo(null);
        if (result == 1) {
            label.setText(SUCCESS_LABEL);
            loginBtn.setText(LABEL_BUTTON_SUCCESS);
            textPanel.add(label);
            textPanel.add(loginBtn);
        }
        else {
            textPanel.remove(loginBtn);
            label.setText(FAULT_LABEL);
            textPanel.add(label);
        }
        dialog.add(textPanel);
        dialog.setVisible(true);
    }

    public void login() {
        dialog.setVisible(false);
    }

}
