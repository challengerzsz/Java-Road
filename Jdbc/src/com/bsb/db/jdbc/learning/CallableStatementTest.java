package com.bsb.db.jdbc.learning;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class CallableStatementTest {
    private String driver;
    private String url;
    private String user;
    private String pwd;


    public void initParam(String paramFile) throws IOException {
        //使用Properties类加载属性文件
        Properties prop = new Properties();
        prop.load(new FileInputStream(paramFile));
        driver = prop.getProperty("JDBC_DRIVER");
        url = prop.getProperty("URL");
        user = prop.getProperty("USER");
        pwd = prop.getProperty("PWD");
    }

    public void callProcedure() throws ClassNotFoundException {
        Class.forName(driver);
        try(
                Connection connection = DriverManager.getConnection(url, user, pwd);
                //创建一个CallableStatement对象
                CallableStatement callableStatement = connection.prepareCall("{call add_pro(?,?,?)}")
                ) {
            callableStatement.setInt(1, 4);
            callableStatement.setInt(2, 5);
            //注册callableStatement对象的第三个参数为int类型
            callableStatement.registerOutParameter(3, Types.INTEGER);
            //执行存储过程
            callableStatement.execute();
            //获取输出out参数
            System.out.println(callableStatement.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CallableStatementTest callableStatementTest = new CallableStatementTest();
        callableStatementTest.initParam("E:\\Java-Road\\Jdbc\\src\\jdbc.properties");
        callableStatementTest.callProcedure();
    }
}
