package com.controller;

import com.Dao.titleDao;
import com.entity.title;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class addTitleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    //添加题目
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
        response.setContentType("application/json;charset=utf-8");
        titleDao dao = new titleDao();
        title title = new title(null,request.getParameter("title"),request.getParameter("optionA"),
                request.getParameter("optionB"),request.getParameter("optionC"),
                request.getParameter("optionD"),request.getParameter("answer"));
        Integer result = null;
        result = dao.titleAdd(title,request);
        PrintWriter out = response.getWriter();
        out.println(result);//返回 1 则添加成功
    }
}
