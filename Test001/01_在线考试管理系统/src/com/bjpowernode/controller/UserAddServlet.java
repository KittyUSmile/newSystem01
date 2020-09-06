package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String userName,password,sex,email;
        UserDao dao = new UserDao();
        PrintWriter out = response.getWriter();
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        Users user = new Users(10,userName,password,sex,email);
        int result = dao.add(user);
        if(result > 0){
            out.print("<font style = 'color:red;font-size:40px'>用户信息注册成功</font>");
        }else{
            out.print("<font style = 'color:red;font-size:40px'>用户信息注册失败</font>");
        }
    }
}
