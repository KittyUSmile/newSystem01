<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/8/12
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考生登录页面测试</title>
</head>
<body>
<center>
    <form action = "" method = "">
        <table>
            <tr>
                <td>姓名</td>
                <td><input type = "text" name = "userName"/></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type = "password" name = "password"/></td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <input type = "radio" name = "sex" value = "boy"/>男
                    <input type = "radio" name = "sex" value = "girl"/>女
                </td>
            </tr>
            <tr>
                <td>外貌</td>
                <td><input type = "text" name = "email"/></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type = "submit" name = "注册"/>
                    <input type = "reset" name="清空"/>
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
