package com.bsb.db.jdbc.transaction;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/*
    程序出现未处理异常时 自动回滚事务
 */
public class TransactionTest {
    private String driver;
    private String url;
    private String user;
    private String pwd;

    public void initParam(String paramFile) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(paramFile));
        driver = prop.getProperty("JDBC_DRIVER");
        url = prop.getProperty("URL");
        user = prop.getProperty("USER");
        pwd = prop.getProperty("PWD");
    }

    public void insertInTransaction(String[] sqls) throws ClassNotFoundException {
        Class.forName(driver);
        try(
                Connection connection = DriverManager.getConnection(url, user, pwd)
                ) {
            connection.setAutoCommit(false);
            try(
                    Statement statement = connection.createStatement();
                    ) {
                for (String sql: sqls) {
                    System.out.println(statement.executeUpdate(sql));
                }
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TransactionTest transactionTest = new TransactionTest();
        transactionTest.initParam("E:\\Java-Road\\Jdbc\\src\\jdbc.properties");
        String[] sqls = {
                "insert into test_1 (id,username) value (5, 'testName')",
                "insert into test_table values (1,2)"
        };
        transactionTest.insertInTransaction(sqls);
    }
}
