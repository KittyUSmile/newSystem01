package com.entity;

//成绩表类

public class grade {
    Integer id;
    Integer grade;

    public grade(Integer id, Integer grade) {
        this.id = id;
        this.grade = grade;
    }

    public grade() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
