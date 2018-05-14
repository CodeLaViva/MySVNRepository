<%--
  Created by IntelliJ IDEA.
  User: 焱
  Date: 2018/5/11
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
</head>

<body>
<center>
    <h1>欢迎你，${sessionScope.acc.nickName }</h1>
</center>
<table align="center" border="1px;" width="40%">
    <tr align="center">
        <td>序号</td>
        <td>账号</td>
        <td>密码</td>
        <td>余额</td>
        <td>昵称</td>
        <td>操作</td>
    </tr>
    <c:forEach var="acc" items="${ls }">
        <tr align="center">
            <td>${acc.id }</td>
            <td>${acc.cardNo }</td>
            <td>${acc.pwd }</td>
            <td>${acc.balance }</td>
            <td>${acc.nickName }</td>
            <td>
                <a href="#">删除</a>
                <a href="#">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
