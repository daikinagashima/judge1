<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録画面</title>
</head>
<body>
<h1>ユーザ登録画面</h1>
<p>ユーザ名、パスワード共に10字以内で入力してください。</p>

<p>そのユーザ名は既に登録されています。</p><br>
<form action="/judge/RegisterServlet" method="post">
ユーザ名：<input type="text"name="name" required maxlength='10'><br>
パスワード：<input type="password" name="pass" required maxlength='10'><br>
<input type="submit" value="登録する"></form>
</body>
</html>