package com.controller;

import com.Dao.titleDao;
import com.entity.grade;
import com.entity.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class add_In_GradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    //录入学生考试成绩,学生考完试后提交自动登记[无需手动调用]
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user user = (user)request.getServletContext().getAttribute("user");
        titleDao dao = new titleDao();
        if(Integer.valueOf(user.getBelong()) == 0){
            //学生
            grade grade = new grade(user.getId(),(Integer) request.getAttribute("stuGrade"));
            dao.add_In_Grade(grade,request);
        }else{
            //教师，返回,暂不登记
            return;
        }
    }
}
