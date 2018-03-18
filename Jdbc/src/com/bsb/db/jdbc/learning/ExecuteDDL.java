package com.bsb.db.jdbc.learning;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDDL {
    private String driver;
    private String url;
    private String user;
    private String pwd;

    private String SQL;

    public void initParam(String paramFile) throws IOException {
        //使用Properties类加载文件
        Properties properties = new Properties();
        properties.load(new FileInputStream(paramFile));
        driver = properties.getProperty("JDBC_DRIVER");
        url = properties.getProperty("URL");
        user = properties.getProperty("USER");
        pwd = properties.getProperty("PWD");
    }

    public void createTable(String SQL) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        //加载驱动
        Class.forName(driver);
        try {
            connection = DriverManager.getConnection(url, user, pwd);
            statement = connection.createStatement();
            statement.executeUpdate(SQL);
        } finally {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
        }
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        ExecuteDDL executeDDL = new ExecuteDDL();
        executeDDL.initParam("E:\\Java-Road\\Jdbc\\src\\jdbc.properties");
        executeDDL.SQL = "create table test_table (id int primary key);";
        executeDDL.createTable(executeDDL.SQL);
        System.out.println("建表成功");
    }
}
