<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/8/17
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师注册页面</title>
    <script src="级联查询js代码块.jsp">

    </script>
</head>
<body>
<center>
    <table>
        <br>
        <tr>
            <td>用户名：</td>
            <td><input type="text" id="teaUser"></td>
            <td></td>
        </tr>
        <br>
        <tr>
            <td>用户密码：</td>
            <td><input type="password" id = "teaPassword"></td>
            <td></td>
        </tr>
        <tr>
            <td>籍贯:</td>
            <td>
                <select id = "province">
                    <option value = "0">请选择....</option>
                </select>
            </td>
            <td>
                <select id = "city">
                    <option value = "0">请选择....</option>
                </select>
            </td>
    </table>
    <br>
    <input type="submit"value="注册">
    &emsp;&emsp;&emsp;
    <input type="reset">
</center>
</body>
</html>
