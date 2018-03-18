package com.bsb.db.jdbc.learning;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class LoginFrame {
    private final String PropertiesFile = "E:\\Java-Road\\Jdbc\\src\\jdbc.properties";
    private String driver;
    private String url;
    private String user;
    private String pwd;

    private static String SQL = null;



    private JFrame jFrame = new JFrame("登陆");
    private JTextField userField = new JTextField(20);
    private JTextField userPwdField = new JTextField(20);
    private JButton loginButton = new JButton("登陆");

    public void init() throws ClassNotFoundException, SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(PropertiesFile));
        driver = properties.getProperty("JDBC_DRIVER");
        url = properties.getProperty("URL");
        user = properties.getProperty("USER");
        pwd = properties.getProperty("PWD");
        Connection connection = null;
        Statement statement = null;
        //加载驱动
        Class.forName(driver);
        loginButton.addActionListener(e -> {
            //登陆成功显示成功
            if (validate(userField.getText(), userPwdField.getText())) {
                JOptionPane.showConfirmDialog(jFrame, "登陆成功");
            } else {
                JOptionPane.showConfirmDialog(jFrame, "登陆失败");
            }
        });
        jFrame.add(userField, BorderLayout.NORTH);
        jFrame.add(userPwdField);
        jFrame.add(loginButton, BorderLayout.SOUTH);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public boolean validate(String userName, String userPwd) {
        SQL = "select * from login_info where username = ? and password = ?";
        System.out.println(SQL);

        try (
                Connection connection = DriverManager.getConnection(url, user, pwd);
                PreparedStatement preparedStatement = connection.prepareStatement(SQL)
                ){
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPwd);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        new LoginFrame().init();
    }
}
