<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿完了画面</title>
</head>
<body>
<c:import url="/header.html" />
<div class="box">
<h1>投稿完了画面</h1>
<p>投稿が完了しました。</p>
<p>投稿した内容</p><br>
<p>タイトル :<c:out value="${title}" /></p><br>
<p>内容 :<c:out value="${content}" /></p><br>
<p>選択１ :<c:out value="${pattern1}" /></p><br>
<p>選択２ :<c:out value="${pattern2}" /></p><br>

<a href="/judge/JudgeServlet">投稿一覧を見る</a><br>
<a href="/judge/PostServlet">投稿をする</a>

</div>
</body>
</html>