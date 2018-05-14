<%--
  Created by IntelliJ IDEA.
  User: 焱
  Date: 2018/5/13
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";

    String flag = request.getParameter("flag");
    String sign = request.getParameter("CheckLogin");
//    if (errorMsg == null) {
//        errorMsg = "";
//    }
    String errorMessage = "";
    if (flag != null) {
        session.removeAttribute("user");
    }
    if ("error".equals(flag)) {
        errorMessage = (String) session.getAttribute("errorMsg");
    }
%>


<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <!-- <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登录</title>

    <link href="<%=basePath%>style/login.css" rel="stylesheet"
          type="text/css"/>

    <link href="<%=basePath%>style/bootstrapDemo.css" rel="stylesheet"
          type="text/css"/>

    <link href="<%=basePath%>style/bootstrap.min.css" rel="stylesheet"
          type="text/css"/>

    <script src="jquery-3.1.1.js" language="JavaScript"></script>

    <style type="text/css">
        body {
            background-image: url("<%=basePath%>image/bkg2.jpg");
            background-size: cover;
        }

    </style>
</head>

<body>
<div class="container">
    <form name="form" id="form" action="login.do" method="post">
        <div style="padding: 6px">
            <div>
                <h2 style="text-align: center; margin-top: 0; color: white">欢迎使用lhz投票系统</h2>
            </div>
            <div style="margin-top: 200px">
                <table style="margin: auto;border: solid 2px #2891F8; color: #ffffff; ">
                    <tr>
                        <td>
                            <div>
                                <h3 style="text-align: center;height: 34px;margin: 0;padding: 6px;">欢迎登陆</h3>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 280px">
                            <div class="input-group" style="padding-left: 5px;padding-right: 5px;">
                                <span class="input-group-addon">用户名:</span>
                                <input id="user" name="vote_username" type="text" class="form-control"
                                       placeholder="Username"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 280px">
                            <div class="input-group" style="padding-left: 5px;padding-right: 5px;">
                                <span class="input-group-addon" style="letter-spacing: 4.66px;">密码:</span>
                                <input id="pass" name="vote_password" type="password" class="form-control"
                                       placeholder="Password"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: center">
                            <input id="login" name="login" type="submit" value="登录" class="btn btn-default"
                                   style="margin: auto"/>
                            <input id="register" name="register" type="button" value="注册" class="btn btn-default"
                                   style="margin: auto auto auto 50px;"
                                   onclick="window.location.href='<%=basePath%>register.jsp'"/>
                        </td>
                    </tr>
                </table>
                <div style="text-align: center">
                    <span style="color: red;">${msg }</span>
                    <span style="color: red;"><%=errorMessage%></span>
                </div>
            </div>
        </div>
    </form>
</div>
<footer class="blog-footer" style="text-align: center; color:white">
    <p>lhz的投票系统 </p>
</footer>
</body>
</html>
