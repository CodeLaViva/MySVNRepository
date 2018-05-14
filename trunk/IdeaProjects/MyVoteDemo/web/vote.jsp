<%--
  Created by IntelliJ IDEA.
  User: 焱
  Date: 2018/5/14
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>
<head>

    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>投票</title>
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
<!-- 主体 -->
<div class="container">
    <div class="blog-post form-signin">

    </div>
</div>

<div style="padding: 6px">
    <div>
        <h2 style="text-align: center; margin-top: 0; color: white">欢迎使用lhz投票系统</h2>
    </div>
    <div style="margin-top: 200px; color: white">
        <div style="margin: auto;border: solid 2px #2891F8; color: #ffffff; ">

            <form action="vote.do" method="post" style="text-align: center">
                <div class="masthead clearfix">
                    <div class="inner">
                        <h2 class="cover-heading" style="text-align: center;">欢迎${user}来投票</h2>
                    </div>
                </div>
                <div class="radio">
                    <label> <input type="radio" name="username"
                                   id="optionsRadios1" value="lhz1" checked> lhz1
                    </label>
                </div>
                <div class="radio">
                    <label> <input type="radio" name="username"
                                   id="optionsRadios2" value="lhz2"> lhz2
                    </label>
                </div>
                <div class="radio">
                    <label> <input type="radio" name="username"
                                   id="optionsRadios3" value="lhz3"> lhz3
                    </label>
                </div>
                <div class="radio">
                    <label> <input type="radio" name="username"
                                   id="optionsRadios4" value="lhz4"> lhz4
                    </label>
                </div>
                <p>
                    <input type="submit" value="投ta一票" class="btn btn-success"/>
                </p>
                <p>
                    <input type="button" onclick="location.href='result.jsp'" value="查看投票結果" class="btn btn-success" />
                </p>
                <span style="color: red;">${error_message}</span>
            </form>
        </div>
    </div>
</div>
<!-- 页脚 -->
<footer class="blog-footer" style="text-align: center; color:white">
    <p>lhz的投票系统 </p>
</footer>
</body>
</html>
