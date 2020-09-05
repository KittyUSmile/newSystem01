package com.controller;

import com.Dao.titleDao;
import com.entity.grade;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class find_Grade_By_IdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    //通过学生 id 查询该生所有成绩
    //需要参数：学生 id
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String json = "{}";
        titleDao dao = new titleDao();
        List<grade> list = null;
        list = dao.find_stu_Grade(Integer.valueOf(request.getParameter("id")),request);
        if(list!=null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(list);
        }
        out.print(json);
        out.flush();
        out.close();
    }
    //返回一个json格式数据，装有该生Id和考试成绩
}
