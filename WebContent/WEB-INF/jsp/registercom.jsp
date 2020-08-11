<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了</title>
</head>
<body>
<c:import url="/header.html" />
<p>登録が完了しました。</p><br>
<p>あなたのユーザ名は <%= request.getParameter("name") %> です。</p>
<a href="/judge/">メインページへ</a>
</body>
</html>