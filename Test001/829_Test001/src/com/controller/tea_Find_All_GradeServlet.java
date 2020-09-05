package com.controller;

import com.Dao.titleDao;
import com.entity.grade;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class tea_Find_All_GradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    //教师查找所有学生所有成绩
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out =  response.getWriter();
        titleDao dao = new titleDao();
        String json = "{}";
        List<grade> list = null;
        list = dao.find_AllStu_Grade(request);
        if(list!=null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(list);
        }
        out.print(json);
        out.flush();
        out.close();
    }
}  //返回一个 json 格式的所有学生的成绩数据
