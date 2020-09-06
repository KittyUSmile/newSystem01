package com.bjpowernode.util;

import java.sql.*;

public class JdbcUtil {
//    final String driver = "com.mysql.jdbc.Driver";
    Connection conn = null;
    PreparedStatement ps = null;
    public JdbcUtil() {
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {

        final String url = "jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=UTC";
        final String user = "root";
        final String password = "2002";
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public PreparedStatement CreateStatement(String sql) {

        try {
            ps = getCon().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public void Close(Connection conn) {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void Close(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
