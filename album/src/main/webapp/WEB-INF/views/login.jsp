<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2018/9/4
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="../../css/login.css">
</head>
<%
    String fail = (String) session.getAttribute("fail");
    if(fail != "")
        session.removeAttribute("fail");
%>
<body onload="OnLoad()">
    <header class="top">
        <h2>云相册</h2>
    </header>
    <section class="section">
        <header class="welcome">
            <h2>welcome to you!</h2>
        </header>
        <article class="article">
            <header>Log In</header>
            <form onsubmit="return Check()" action="login" method="post">
                <article class="input">
                    <div>
                        <div class="img"><img src="../../images/User.png"></div>
                        <input id="username" name="username" placeholder="username">
                    </div>
                    <div>
                        <div class="img"><img src="../../images/password.png"></div>
                        <input id="password" name="password" placeholder="password" type="password">
                    </div>
                    <p id="err"></p>
                    <button type="submit" style="cursor: pointer">GO!</button>
                    <button type="button"><a href="register">Sign In</a></button>
                    <div class="remember">
                        <input id="remember" type="checkbox">
                        <span>Remember me</span>
                    </div>
                </article>
            </form>
        </article>
    </section>
<div class="fail" id="fail"><%=fail%></div>
</body>
<script type="text/javascript" src="../../js/login.js"></script>
</html>
