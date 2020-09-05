package com.controller;

import com.Dao.userDao;
import com.entity.user;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PrimitiveIterator;

public class find_Stu_By_IdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
//通过 id 查找该学生的所有基本信息
//    需要参数：id
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "{}";
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        user user = null;
        userDao dao = new userDao();
        user = dao.findOne(Integer.valueOf(request.getParameter("id")),request);
        if(user!=null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(user);
        }
        out.print(json);
        out.flush();
        out.close();
    }
}    //返回一个装满该学生基本信息的 json 格式数据
