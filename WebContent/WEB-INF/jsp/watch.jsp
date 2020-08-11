<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="model.Post,java.util.List,model.ListLogic,dao.PostDAO" %>
   <% List<Post> postList = (List<Post>)request.getAttribute("postList"); %>
   <% String name = (String)session.getAttribute("name"); %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="watch.css">
<style>
@import url('https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c');
.box {
    padding: 0.5em 1em;
    margin: 2em 0;
    font-weight: bold;
    border: solid 3px #000000
    background: #dcefff;
}
.box .box-title {
    font-size: 1.2em;
    background: #5fb3f5;
    padding: 4px;
    text-align: center;
    color: #FFF;
    font-weight: bold;
    letter-spacing: 0.05em;
}
.box p {
    margin: 0;
    padding: 0;
    color: black
}
p{
    font-family: 'M PLUS Rounded 1c', sans-serif;
    font-weight: bold;
}
</style>
</head>
<body>

<c:import url="/header.html" />
<% for(Post post : postList) { %>
<div class = "box">
<p>No<%= post.getNumber() %>
<p><%= post.getUserName() %>さんの投稿</p><br>
<div-class="box-title><p>タイトル :<%= post.getTitle() %></p><br></div-class>
<p>内容：<%= post.getContent() %></p><br>
<% int number = post.getNumber(); %>

<% ListLogic listLogic = new ListLogic(); %>
<% if(listLogic.execute(number, name)){ %>
<% PostDAO dao = new PostDAO(); %>
<% int pattern1_num = dao.getPattern1_num(number); %>
<% int pattern2_num = dao.getPattern2_num(number); %>
<p><%= post.getPattern1() %>：<%= pattern1_num %>  <%= post.getPattern2() %>：<%= pattern2_num %></p>
<% }else{ %>
<form action="/judge/JudgeServlet" method="post">
<input type="radio" name="pattern" value="1"><%= post.getPattern1() %>
<input type="radio" name="pattern" value="2"><%= post.getPattern2() %>
<input type="hidden" name="number" value=<%= post.getNumber() %>>
<input type="hidden" name="name" value=<%= post.getUserName() %>>
<input type="hidden" name="title" value=<%= post.getTitle() %>>
<input type="hidden" name="content" value=<%= post.getContent() %>>
<input type="submit" value="投稿する">
</form><% } %>
</div><% } %>

</body>
</html>