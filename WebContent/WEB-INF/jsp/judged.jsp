<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投票結果</title>
</head>
<body>
<c:import url="/header.html" />
<div class="box">
<c:out value="${title}" /><br>
<c:out value="${content}" /><br>
<c:out value="${pattern1}" />
<c:out value="${pattern1_num}" /><br>
<c:out value="${pattern2}" />
<c:out value="${pattern2_num}" />
</div>
<a href="/judge/JudgeServlet">一覧へ戻る</a>
</body>
</html>