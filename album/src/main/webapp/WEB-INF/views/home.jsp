<%@ page import="java.util.List" %>
<%@ page import="com.lhy.demo.Entity.Category" %>
<%@ page import="javax.validation.constraints.Null" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2018/9/5
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="../../css/home.css">
</head>
<body>
<header class="top" id="top">
    <h2>我的云相册</h2>
    <button onclick="upload()" style="margin-right: 10%">上传照片</button>
    <button onclick="newAlbum()" style="margin-right: 5%">新建相册</button>
</header>
<section class="section" id="section">
    <%
        if (session.getAttribute("user") == null)
            response.sendRedirect("/album/");
        List<Category> categories = (List<Category>) session.getAttribute("categories");
        List<List<String>> pictureList = (List<List<String>>) session.getAttribute("photos");
        session.removeAttribute("categories");
        session.removeAttribute("photos");
        int n = 0;
        for (int i=0; i<categories.size(); i++){
    %>
        <article class="article">
            <div class="title">
                <div id="name"><%=categories.get(i).getCategory_name()%></div>
                <button id="label"><%=categories.get(i).getPhoto_count()%></button>
                <button id="btn"><a href="more/<%=categories.get(i).getCategory_name() + "_" + 0%>">More</a></button>
                <button id="dropbtn"></button>
                <div class="contain">
                    <div class="right_box">
                        <button onclick="reset('<%=categories.get(i).getCategory_name()%>')" type="button">重命名</button>
                        <button onclick="delete1('<%=categories.get(i).getCategory_name()%>')" type="button">删除</button>
                    </div>
                </div>
            </div>
            <div class="box">
                <%
                    if (categories.get(i).getPhoto_count() > 0){
                        for (int j=0; j<6; j++){
                            if (j < pictureList.get(n).size()){
                %>
                    <a href="more/<%=categories.get(i).getCategory_name() + "_" + j%>">
                        <img src="../../images/photos/<%=pictureList.get(n).get(j)%>.jpg">
                    </a>
                <%
                            }
                            else{
                %>
                    <a></a>
                <%
                            }
                        }
                        n++;
                    }
                    else{
                %>
                    <div class="no">暂无图片</div>
                <%
                    }
                %>
            </div>
        </article>
    <%
        }
    %>
    <footer><span>Created by lhy</span></footer>
</section>
<div class="newAlbum" id="newAlbum">
    <form onsubmit="return Check1()" action="album" method="post">
        <input name="album" id="album" placeholder="输入相册名" autofocus="autofocus">
        <button type="submit">新建</button>
        <button type="button" onclick="closeNewAlbum()">关闭</button>
        <p id="err1">相册名为空</p>
    </form>
</div>
<div class="upload" id="upload">
    <form action="upload" method="post" onsubmit="return Check()" enctype="multipart/form-data">
        <input type="file" name="picture" id="picture" multiple="multiple">
        <select name="category" id="category">
            <option style="display: none">选择图片分类</option>
            <%
                for (int i=0; i<categories.size(); i++){
            %>
                <option><%=categories.get(i).getCategory_name()%></option>
            <%
                }
            %>
        </select>
        <p id="err">文件或图片分类为空</p>
        <button type="submit">上传</button>
        <button type="button" onclick="closeUpload()">关闭</button>
    </form>
</div>
<div class="delete" id="delete">
    <p>确定删除?</p>
    <form action="deleteAlbum" method="post">
        <input name="album_name" id="album_name1" style="display: none;">
        <button style="left: 30%" type="submit">删除</button>
        <button style="right: 30%;" type="button" onclick="closeDelete()">取消</button>
    </form>
</div>
<div class="reset" id="reset">
    <form onsubmit="return Check2()" action="reset" method="post">
        <input name="album1" id="album_name2" style="display: none;">
        <input name="album2" id="album_name3" placeholder="输入新名称">
        <button type="submit">提交</button>
        <button type="button" onclick="closeReset()">关闭</button>
        <p id="err2">相册名为空</p>
    </form>
</div>
</body>
<script type="text/javascript" src="../../js/home.js"></script>
</html>
