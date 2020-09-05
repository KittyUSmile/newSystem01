package com.Dao;

import com.entity.grade;
import com.entity.title;
import com.sun.java.accessibility.util.GUIInitializedListener;
import com.util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//考试题目Dao类
public class titleDao {
    private JdbcUtil util = new JdbcUtil();
    //教师端试题添加
    public int titleAdd(title title){
        PreparedStatement ps = null;
        String sql = "insert into title()values(?,?,?,?,?,?,?)";
        Integer result = null;
        try {
            ps = util.getCon().prepareStatement(sql);
            ps.setString(1,null);
            ps.setString(2,title.getTitle());
            ps.setString(3,title.getOptionA());
            ps.setString(4,title.getOptionB());
            ps.setString(5,title.getOptionC());
            ps.setString(6,title.getOptionC());
            ps.setString(7,title.getAnswer());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }//返回 1 则添加成功
    //教师端快速试题添加[通过 Listener 快速进行添加]
    public int titleAdd(title title, HttpServletRequest request){
        PreparedStatement ps = null;
        String sql = "insert into title()values(?,?,?,?,?,?,?)";
        Integer result = null;
        try {
            ps = util.getCon(request).prepareStatement(sql);
            ps.setString(1,null);
            ps.setString(2,title.getTitle());
            ps.setString(3,title.getOptionA());
            ps.setString(4,title.getOptionB());
            ps.setString(5,title.getOptionC());
            ps.setString(6,title.getOptionC());
            ps.setString(7,title.getAnswer());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }//返回 1 则添加成功

    //教师端试题删除
    public int titleDelete(String titleId){
        Integer result = null;
        PreparedStatement ps = null;
        String sql = " delete from title where titleId = ?";
        try {
            ps = util.getCon().prepareStatement(sql);
            ps.setString(1,titleId);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return  result;
    }//返回 1 则删除成功
    //教师端试题删除[通过 Listener 快速进行删除]
    public int titleDelete(String titleId,HttpServletRequest request){
        Integer result = null;
        PreparedStatement ps = null;
        String sql = " delete from title where titleId = ?";
        try {
            ps = util.getCon(request).prepareStatement(sql);
            ps.setString(1,titleId);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return  result;
    }//返回 1 则删除成功

    //教师端修改试题
    public int titleChange(title title){
        Integer result = null;
        PreparedStatement ps = null;
        String sql = " update title set title = ?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where titleId = ?";
        try {
            ps = util.getCon().prepareStatement(sql);
            ps.setString(1,title.getTitle());
            ps.setString(2,title.getOptionA());
            ps.setString(3,title.getOptionB());
            ps.setString(4,title.getOptionC());
            ps.setString(5,title.getOptionD());
            ps.setString(6,title.getAnswer());
            ps.setString(7, String.valueOf(title.getTitleId()));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return  result;
    }//返回 1 则修改成功
    //教师端修改试题[通过 Listener 快速进行修改]
    public int titleChange(title title,HttpServletRequest request){
        Integer result = null;
        PreparedStatement ps = null;
        String sql = " update title set title = ?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where titleId = ?";
        try {
            ps = util.getCon(request).prepareStatement(sql);
            ps.setString(1,title.getTitle());
            ps.setString(2,title.getOptionA());
            ps.setString(3,title.getOptionB());
            ps.setString(4,title.getOptionC());
            ps.setString(5,title.getOptionD());
            ps.setString(6,title.getAnswer());
            ps.setString(7, String.valueOf(title.getTitleId()));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return  result;
    }//返回 1 则修改成功

    //教师端查询所有试题
    public List<title> findAllTitles(){
         List<title> titleList = new ArrayList<>();
         title title = null;
         String sql = "select titleId,title,optionA,optionB,optionC,optionD,answer from title";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = util.getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                title = new title(Integer.valueOf(rs.getString("titleId")),rs.getString("title"),
                        rs.getString("optionA"),rs.getString("optionB"),
                        rs.getString("optionC"),rs.getString("optionD"),rs.getString("answer"));
                titleList.add(title);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
            util.close();
        }
        return  titleList;
    }//返回一个 List 集合
    //教师端查询所有试题[通过 Listener 快速进行查询]
    public List<title> findAllTitles(HttpServletRequest request){
        List<title> titleList = null;
        title title = null;
        String sql = "select titleId,title,optionA,optionB,optionC,optionD,answer from title";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = util.getCon(request).prepareStatement(sql);
            rs = ps.executeQuery();
            titleList = new ArrayList<>();
            while(rs.next()){
                title = new title(rs.getInt("titleId"),rs.getString("title"),
                        rs.getString("optionA"),rs.getString("optionB"),rs.getString("optionC"),
                        rs.getString("optionD"),rs.getString("answer"));
                titleList.add(title);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
            util.close(request);
        }
        return  titleList;
    }//返回一个 List 集合

    //教师端通过id查询试题
    public title findTitle(Integer titleId){
        String sql = "select titleId,title,optionA,optionB,optionC,optionD,answer from title where titleId =?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        title title = null;
        try {
            ps = util.getCon().prepareStatement(sql);
            ps.setInt(1,titleId);
            rs = ps.executeQuery();
            if(rs!=null){
                title = new title(rs.getInt("titleId"),rs.getString("title"),
                    rs.getString("optionA"),rs.getString("optionB"),rs.getString("optionC"),
                    rs.getString("optionD"),rs.getString("answer"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
            util.close();
        }
        return  title;
    }//返回一个 title 类实体，若无此题，返回 null
    //教师端通过id查询试题[通过 Listener 快速进行查询]
    public title findTitle(Integer titleId,HttpServletRequest request){
        String sql = "select titleId,title,optionA,optionB,optionC,optionD,answer from title where titleId =?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        title title = null;
        try {
            ps = util.getCon(request).prepareStatement(sql);
            ps.setInt(1,titleId);
            rs = ps.executeQuery();
            if(rs!=null){
                title = new title(rs.getInt("titleId"),rs.getString("title"),
                        rs.getString("optionA"),rs.getString("optionB"),rs.getString("optionC"),
                        rs.getString("optionD"),rs.getString("answer"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
            util.close(request);
        }
        return  title;
    }//返回一个 title 类实体，若无此题，返回 null

    //随机出题[通过 Listener 快速进行查询]
    public List<title> randTitles(HttpServletRequest request){
        List<title> titles = null;
        title title = null;
        String sql = "select titleId,title,optionA,optionB,optionC,optionD,answer from title order by rand() limit 0,5";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = util.getCon(request).prepareStatement(sql);
            rs = ps.executeQuery();
            titles = new ArrayList<>();
            while(rs.next()){
                title = new title(rs.getInt("titleId"),rs.getString("title"),
                        rs.getString("optionA"),rs.getString("optionB"),
                        rs.getString("optionC"),rs.getString("optionD"),
                        rs.getString("answer"));
                titles.add(title);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
            util.close(request);
        }
        return  titles;
    }//返回装满五道题的 List 集合

    //注册进成绩表
    public int add_In_Grade(grade grade, HttpServletRequest request){
        PreparedStatement ps = null;
        Integer result = null;
        String sql = "insert into stuGrade()values(?,?)";
        try {
            ps = util.getCon(request).prepareStatement(sql);
            ps.setInt(1,grade.getId());
            ps.setInt(2,grade.getGrade());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }//返回 1 则插入成功

    //教师端查询所有学生成绩表
    public List<grade> find_AllStu_Grade(HttpServletRequest request){
         String sql = "select stuId,grade from stuGrade";
         PreparedStatement ps = null;
         ResultSet rs = null;
         grade grade = null;
         List<grade> list = new ArrayList<>();
        try {
            ps = util.getCon(request).prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                grade = new grade(rs.getInt("stuId"),rs.getInt("grade"));
                list.add(grade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
            util.close(request);
        }
        return list;
    }//返回一个List集合，装满了所有学生的id和grade

    //教师端通过 id 查询该生的所有成绩
    public List<grade> find_stu_Grade(Integer id , HttpServletRequest request){
        List<grade> list = new ArrayList<>();
        String sql = "select stuId,grade from stuGrade where stuId = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        grade grade = null;
        try {
            ps = util.getCon().prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                grade = new grade(rs.getInt("stuId"),rs.getInt("grade"));
                list.add(grade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
            util.close(request);
        }
        return list;
    }//返回一个List集合，装满该学生的所有考试成绩
}

