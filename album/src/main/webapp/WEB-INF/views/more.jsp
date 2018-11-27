<%@ page import="java.util.List" %>
<%@ page import="com.lhy.demo.Entity.Photo" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2018/9/7
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        if (session.getAttribute("user") == null)
            response.sendRedirect("/album/");
        String albumName = (String) session.getAttribute("albumName");
        session.removeAttribute("albumName");
        List<String> photos = (List<String>) session.getAttribute("album");
        session.removeAttribute("album");
        List<String> categoryName = (List<String>) session.getAttribute("categoryName");
        session.removeAttribute("categoryName");
        Integer id = (Integer) session.getAttribute("id");
        session.removeAttribute("id");
    %>
    <title><%=albumName%></title>
    <link rel="stylesheet" href="../../css/more.css">
</head>
<body onload="init(<%=id%>, <%=photos.size()%>)">
<header class="top" id="top">
    <h2>相册:&nbsp;<%=albumName%></h2>
    <a href="../home">首页</a>
</header>
<section id="section">
    <div class="msg">没有下一张</div>
    <input id="flag" style="display: none">
    <%
        for (int i=0; i<photos.size(); i++){
    %>
    <div class="img" id="<%=i%>">
        <button onclick="move1()" style="left: 39%">移动</button>
        <button onclick="delete1()" style="right: 39%">删除</button>
        <a href="../ShowPicture/<%=photos.get(i)%>">
            <img src="../../images/photos/<%=photos.get(i)%>.jpg">
        </a>
    </div>
    <%
        }
    %>
    <button class="before btn" onclick="Before()"><</button>
    <button class="next btn" onclick="Next(<%=photos.size()-1%>)">></button>
    <%
        int num = photos.size()/6;
        if (photos.size()%6 !=0)
            num = num + 1;
        for (int i=0; i<num; i++){
    %>
    <div class="bottom_box"  id="bottom<%=i%>">
        <div class="bottom">
            <%
                for (int j=i*6; j<i*6 + 6; j++){
                    if (j < photos.size()){
            %>
            <div class="bottom-img" onclick="toImg(<%=j%>, <%=photos.size()%>)">
                <img id="bottom-img<%=j%>" src="../../images/photos/<%=photos.get(j)%>.jpg">
            </div>
            <%
                    }
                    else {
            %>
            <div class="bottom-img"></div>
            <%
                        }
                }
            %>
        </div>
    </div>
    <%
        }
    %>
    <div class="msg" id="msg"></div>
</section>
<div class="move" id="move">
    <form onsubmit="return Check()" action="../move" method="post">
        <select name="category" id="category">
            <option style="display: none">移动到</option>
            <%
                for (int i=0; i<categoryName.size(); i++){
            %>
            <option><%=categoryName.get(i)%></option>
            <%
                }
            %>
        </select>
        <input name="photo_name" id="photo_name1" style="display: none">
        <input name="album_name" value="<%=albumName%>" style="display: none;">
        <button type="submit" type="submit">移动</button>
        <button type="button" onclick="closeMove()">关闭</button>
        <p id="err">请选择一个相册</p>
    </form>
</div>
<div class="delete" id="delete">
    <p>确定删除?</p>
    <form action="../delete" method="post">
        <input name="photo_name" id="photo_name2" style="display: none;">
        <input name="album_name" value="<%=albumName%>" style="display: none;">
        <button style="left: 30%" type="submit">删除</button>
        <button style="right: 30%;" type="button" onclick="closeDelete()">取消</button>
    </form>
</div>
</body>
<script type="text/javascript" src="../../js/more.js"></script>
</html>
