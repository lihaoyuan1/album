<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2018/9/5
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片</title>
    <style>
        html, body{
            margin: 0;
            padding: 0;
            width: 100%;
            height: 100%;
            text-align: center;
            cursor: pointer;
        }
        img{
            width: auto;
            height: auto;
            max-width: 100%;
            max-height: 100%;
        }
    </style>
</head>
<body>
<%
    if (session.getAttribute("user") == null)
        response.sendRedirect("/album/");
    String id = (String) session.getAttribute("id");
    session.removeAttribute("id");
%>
<img src="../../images/photos/<%=id%>.jpg" style="line-height: 100%">
</body>
</html>
