<%--
  Created by IntelliJ IDEA.
  User: 焱
  Date: 2018/5/11
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";

    String flag = request.getParameter("flag");
    String sign = request.getParameter("CheckLogin");
    String errorMsg = (String) request.getAttribute("errorMsg");
//    if (errorMsg == null) {
//        errorMsg = "";
//    }
    if(flag != null){
        session.removeAttribute("ID");
        session.removeAttribute("username");
        session.removeAttribute("Admin");
    }
//    if ("1".equals(sign)) {
//        out.print("<script language='javascript'>alert('手机号或邮箱已存在');</script>");
//    }
    System.out.println(errorMsg);
    System.out.println(sign);
    System.out.println(flag);
%>

<html>
<head>
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
<body onload="Check()">
<form name="form" id="form" action="<%=basePath%>Login" method="post" onsubmit="">
    <div style="padding: 6px">
        <div>
            <h2 style="text-align: center; margin-top: 0; color: white">欢迎使用本系统</h2>
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
                            <input id="user" name="user" type="text" class="form-control" placeholder="Username"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td style="width: 280px">
                        <div class="input-group" style="padding-left: 5px;padding-right: 5px;">
                            <span class="input-group-addon" style="letter-spacing: 4.66px;">密码:</span>
                            <input id="pass" name="pass" type="password" class="form-control" placeholder="Password"/>
                        </div>
                    </td>
                </tr>
                <tr id="Check_tr">
                    <td colspan="2" style="text-align: center;">
                        <span style="color:red;" id="CheckLogin"></span>
                    </td>
                </tr>
                <tr>
                    <td style="text-align: center">
                        <input id="login" name="login" type="submit" value="登录" class="btn btn-default"
                               style="margin: auto"/>
                        <input id="register" name="register" type="button" value="注册" class="btn btn-default"
                               style="margin: auto; margin-left: 50px;"
                               onclick="window.location.href='<%=basePath%>register.jsp'"/>
                    </td>
                </tr>


            </table>
        </div>


    </div>


</form>
</body>
</html>
