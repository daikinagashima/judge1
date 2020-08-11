<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<h1>ログイン画面</h1>
<p>ログインに失敗しました。</p>
<form action="/judge/LoginServlet" method="post">
ユーザ名：<input type="text"name="name" required><br>
パスワード：<input type="password" name="pass" required><br>
<input type="submit" value="ログインする"></form>
</body>
</html>