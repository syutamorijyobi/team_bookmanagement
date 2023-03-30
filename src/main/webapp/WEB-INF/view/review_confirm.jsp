<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.User_ArticleDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿確認画面</title>
</head>
<body>
	<%
	User_ArticleDTO ua = (User_ArticleDTO)session.getAttribute("user_article");
	%>
	<p>内容:<%=ua.getContent() %></p><br>
	<span class="rate_wrap">評価</span><span class="rate"></span><span class="num"><%=ua.getEvaluation() %></span>
	<p>こちらの内容でよろしいですか</p>
	<a href="RegisterReviewExecuteServlet">YES</a><p>/</p><a href="RegisterReviewServlet">NO</a>
</body>
</html>