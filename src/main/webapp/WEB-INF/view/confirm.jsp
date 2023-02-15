<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>
	<p>下記の内容で登録します。よろしいですか？</p>
	<%
		User user = (User)session.getAttribute("input_data");
	%>
	名前：<%=user.getName() %><br>
	メール：<%=user.getMail() %><br>
	パスワード：********<br>
	<a href="ExecuteServlet">OK</a><br>
	<a href="FormServlet">戻る</a>
</body>
</html>