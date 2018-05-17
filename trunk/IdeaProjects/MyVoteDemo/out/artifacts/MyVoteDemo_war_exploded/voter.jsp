<%@ page import="com.lhz.model.Voter" %>
<%@ page import="com.lhz.util.Hibernate_Util" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 焱
  Date: 2018/5/14
  Time: 17:14
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
    List<Voter> list = Hibernate_Util.queryVoter();
    pageContext.setAttribute("list", list);
%>

<html>
<head>
    <title>voter</title>

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
    <div>
        <div>
        </div>
        <div style="text-align: center">
            <h3 style="color: white;">当前登录的用户为:${sessionScope.user}</h3>
            <a class="btn btn-default" id="cancel" href="<%=basePath%>login.jsp?flag=unlogin">注销</a>
        </div>
        <div style="text-align: center;">
            <table id="result" class="table table-hover table-bordered" style="color: white;margin: auto">
                <tr>
                    <td></td>
                    <td>投票人Id</td>
                    <td>投票人</td>
                    <td>投票时间</td>
                </tr>
                <c:forEach var="voter" items="${list}" varStatus="status">
                    <tr>
                        <td><input type="checkbox" id="${status.index}" name="calculate"/></td>
                        <td id="name${status.index}">${voter.id}</td>
                        <td>${voter.vote_username}</td>
                        <td>${voter.vote_Date}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
<footer class="blog-footer" style="text-align: center; color:white">
    <p>lhz的投票系统 </p>
</footer>
</body>
</html>
