package com.bjpowernode.entity;

public class Users {
   private int userId;
   private String userName;
   private String password;
   private String sex;
   private String email;

   public Users(){
   }
   public Users(int userId, String userName, String password, String sex, String email){
       this.sex = sex;
       this.password = password;
       this.email = email;
       this.userId = userId;
       this.userName = userName;
   }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setSex(String Sex) {
        this.sex = Sex;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
