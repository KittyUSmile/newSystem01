<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/8/17
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>级联查询</title>
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript" >
        function loadDateAjax(){
            //做AJAX请求，使用jQuery的$.ajax()
            $.ajax({
                url:"province",
                dataType:"json",
                success:function (resp) {
                    //删除旧数据，将已存在的数据删除
                    $("#province").empty();
                    //each遍历
                    $.each(resp,function (i,n) {
                        //格式：[{"id":1,"name":"北京市","abbr":"京","mainCity":"北京市"}{}]
                        $("#province").append("<option value = '"+n.id+"'>"+n.name+"</option>")
                    })
                }
            })
        }
        $(function () {
            //在页面的dom对象加载成功后执行的函数，在此发起ajax请求
            //  loadDateAjax();
            //绑定事件
            // $("#btnLoad").click(function () {
            $("#city").empty();
            loadDateAjax();
            // })
            //给省份的select绑定一个change事件，当select改变时触发
            $("#province").change(function () {
                //下级被选择
                var obj = $("#province>option:selected");
                //alert("select的change事件"+obj.val()+"-->"+obj.text())
                var id = obj.val();
                //做ajax请求，获取省份的所有城市信息
                $.post("city",{pId:id},function (resp) {
                    //清空select 列表
                    $("#city").empty();
                    $.each(resp,function (i,n) {
                        $("#city").append("<option value = '"+n.id+"'>"+n.name+"</option>")
                    })
                },"json")
            })
        })
    </script>
</head>
<body>
<center>
    <table>
        <%--       <input type="button" value="获取省份数据" id = "btnLoad"/>--%>
        <tr>
            <td>省份列表:</td>
            <td>
                <select id = "province">
                    <option value = "0">请选择....</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>城市列表:</td>
            <td>
                <select id = "city">
                    <option value = "0">请选择....</option>
                </select>
            </td>
        </tr>
    </table>
</center>
</body>
</html>
