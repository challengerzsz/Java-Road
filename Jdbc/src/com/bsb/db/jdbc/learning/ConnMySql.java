package com.bsb.db.jdbc.learning;

import java.sql.*;

public class ConnMySql {
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/login?useSSL=false";
    public static final String USER = "root";
    public static final String PWD = "agytorudhcv11";
    private static final String SQL = "select * from login_info";
    public static void main(String[] args) throws ClassNotFoundException {
        //加载驱动，使用反射
        Class.forName("com.mysql.jdbc.Driver");
        try (
                //使用DriverManager获取数据库连接
                //其中返回的Connection就代表了Java程序和数据库的连接
                Connection connection  = DriverManager.getConnection(URL, USER, PWD);
                //使用Connection创建一个Statement对象
                Statement statement = connection.createStatement();
                //执行SQL语句
                ResultSet resultSet = statement.executeQuery(SQL)

                ) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "  "
                + resultSet.getString(2) + "  " + resultSet.getString(3));
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
