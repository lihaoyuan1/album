<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2018/9/5
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="../../css/register.css">
    <link rel="stylesheet" href="../../css/login.css">
</head>
<body>
    <header class="top">
        <h2>云相册</h2>
    </header>
    <section class="section">
        <article class="article1">
            <header>Sign In</header>
            <form onsubmit="return Check()" action="doregister" method="post">
                <article class="input">
                    <div>
                        <div class="img"><img src="../../images/User.png"></div>
                        <input id="username" name="username" placeholder="username">
                    </div>
                    <div>
                        <div class="img"><img src="../../images/password.png"></div>
                        <input id="password" name="password" placeholder="password" type="password">
                    </div>
                    <div>
                        <div class="img"><img src="../../images/password.png"></div>
                        <input id="password1" name="password1" placeholder="repeat" type="password">
                    </div>
                    <p id="err"></p>
                    <button type="submit" style="cursor:pointer;">Sign In</button>
                </article>
            </form>
        </article>
    </section>
</body>
<script type="text/javascript" src="../../js/register.js"></script>
</html>
