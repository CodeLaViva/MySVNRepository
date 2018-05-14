<%--
  Created by IntelliJ IDEA.
  User: 焱
  Date: 2018/5/14
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";

    if (session.getAttribute("user") == null) {
        session.setAttribute("errorMsg", "请先登录！");
        response.sendRedirect(basePath + "login.jsp?flag=error");
    }

%>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>登录成功！</title>
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
            <div class="masthead clearfix">
                <div class="inner">
                    <h1 class="cover-heading" style="text-align: center;">欢迎${user}来投票</h1>
                </div>
            </div>
            <span style="color: red;">${msg }</span>

            <div class="inner cover">
                <p class="lead"></p>
                <p class="lead" style="text-align: center;">
                    <a href="<%=basePath%>vote.jsp" class="btn btn-lg btn-default" >点击投票</a>
                    <a href="<%=basePath%>login.jsp" class="btn btn-lg btn-default">返回</a>
                </p>
            </div>
            <div class="mastfoot">
                <div class="inner">
                    <p style="text-align: center; margin-top: 0; color: white">lhz的投票系统 </p>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
