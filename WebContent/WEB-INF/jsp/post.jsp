<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post</title>
</head>
<body>

<c:import url="/header.html" />
<div class ="box">
<form action="/judge/PostServlet" method="post">
ユーザ名：<c:out value="${name}" /><br>
タイトル：<input type="text" name = "title" required maxlength='20'><p>※20字以下で入力してください。</p><br>
投稿内容：<input type="text" name = "content" required maxlength='400'><p>※400字以下で入力してください。</p><br>
選択１：<input type="text" name = "pattern1" required maxlength='20'><p>※20字以下で入力してください。</p><br>
選択２：<input type="text" name = "pattern2" required maxlength='20'><p>※20字以下で入力してください。</p><br>
<input type="submit" value = "投稿する">
</form></div>
</body>
</html>
