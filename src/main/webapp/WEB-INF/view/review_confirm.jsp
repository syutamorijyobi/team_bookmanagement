<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.User_ArticleDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/review_confirm.css">
<title>投稿確認画面</title>
</head>
<body>
	<%
	User_ArticleDTO ua = (User_ArticleDTO)session.getAttribute("user_article");
	%>
	<p>評価:<%=ua.getEvaluation() %></p><br>
	<p>内容:<%=ua.getContent() %></p><br>
	<p>こちらの内容でよろしいですか</p>
	<div class="yoko">
	<a href="RegisterReviewExecuteServlet">YES</a>
	<a href="RegisterReviewServlet" class="no">NO</a>
	</div>
</body>
</html>