<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン成功</title>
</head>
<body>
<c:import url="/header.html" />

<h1>ログインに成功しました</h1>
<p>ようこそ<c:out value="${name}" />さん</p>
<a href="/judge/JudgeServlet">投稿を見る</a>
<a href="/judge/PostServlet">投稿する</a>
</body>
</html>
