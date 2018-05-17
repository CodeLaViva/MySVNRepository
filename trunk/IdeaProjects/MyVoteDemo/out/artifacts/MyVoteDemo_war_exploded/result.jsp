<%@ page import="com.lhz.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lhz.util.Hibernate_Util" %><%--
  Created by IntelliJ IDEA.
  User: 焱
  Date: 2018/5/14
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    System.out.println(session.getAttribute("user"));
    List<User> list = Hibernate_Util.query();
    pageContext.setAttribute("list", list);

%>
<html>
<head>
    <title>登陆成功</title>

    <link href="<%=basePath%>style/my.css" rel="stylesheet"
          type="text/css"/>
    <link href="<%=basePath%>style/bootstrapDemo.css" rel="stylesheet"
          type="text/css"/>


    <style type="text/css">
        body {
            background-image: url("<%=basePath%>image/bkg2.jpg");
            background-size: cover;
        }
    </style>
    <script src="jquery-3.1.1.js" language="JavaScript"></script>

</head>
<body>
<div style="padding: 6px">
    <div>
        <h2 style="text-align: center; margin-top: 0; color: white">欢迎使用lhz投票系统</h2>
    </div>
    <div style="margin-top: 200px; color: white">
        <div style="margin: auto;border: solid 2px #2891F8; color: #ffffff; ">

            <div style="text-align: center; color:white">
                ${message}
            </div>

            <div style="text-align: center">
                <h3 style="color: white;">当前登录的用户为:${sessionScope.user}</h3>
                <!--span id="admin_tip" style="color: white;">123</span-->
                <a class="btn btn-default" id="cancel" href="<%=basePath%>login.jsp?flag=unlogin">注销</a>
            </div>
            <div style="text-align: center;">
                <table id="result" class="table table-hover table-bordered" style="color: white;margin: auto">
                    <tr>
                        <td><!--input type="checkbox" title="全选"/--></td>
                        <td>编号</td>
                        <td>姓名</td>
                        <td>票数</td>
                        <td>投票人</td>
                    </tr>
                    <c:forEach var="user" items="${list}" varStatus="status">
                        <tr>
                            <td><input type="checkbox" id="${status.index}" name="calculate"/></td>
                            <td id="name${status.index}">${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.count}</td>
                            <td>${user.voter}</td>
                            <!--td><a class="btn btn-default" href="<%=basePath%>DeleteServlet?id=${user.id}">删除</a></td-->
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
<footer class="blog-footer" style="text-align: center; color:white">
    <p>lhz的投票系统 </p>
</footer>

</body>
</html>
