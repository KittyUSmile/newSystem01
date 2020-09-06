package com.bjpowernode.dao;

import com.bjpowernode.entity.Users;
import com.bjpowernode.util.JdbcUtil;
import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
    private JdbcUtil util = new JdbcUtil();
//    用户注册
    public int add(Users user){
        String sql = "insert into user(userName,password,sex,email)values(?,?,?,?)";
        int result = 0;
        PreparedStatement ps = util.CreateStatement(sql);
        try {
             ps.setString(1,user.getUserName());
             ps.setString(2,user.getPassword());
             ps.setString(3,user.getSex());
             ps.setString(4,user.getEmail());
             result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
//    用户登录

}
