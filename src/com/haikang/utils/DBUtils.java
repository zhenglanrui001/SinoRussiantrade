package com.haikang.utils;

import java.sql.*;

public class DBUtils {
    //mysql8.0后有时区概念
    private static final String url = "jdbc:mysql://127.0.0.1:3306/zemyld?serverTimezone=GMT";
    private static final String userName = "root";
    private static final String password = "zlr15908209105";

    //1.加载驱动类
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动类失败！");
            throw new RuntimeException(e);
        }
    }

    //2.获取连接
    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            System.out.println("创建链接异常");
            throw new RuntimeException(e);
        }
        return conn;
    }

    //3.释放资源
    public static void closeAll(Connection conn, Statement stmt, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
