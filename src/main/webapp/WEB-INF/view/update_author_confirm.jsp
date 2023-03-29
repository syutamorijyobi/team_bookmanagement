<%@page import="dto.AuthorDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>下記の内容で登録します。よろしいですか？</p>
	<%
	AuthorDTO au = (AuthorDTO)session.getAttribute("input_update_author");
	%>
	名前：<%=au.getAuthor_name()%><br>
	名前（ひらがな）：<%=au.getAuthor_hiragana() %><br>
	<a href="UpdateAuthorExecuteServlet">OK</a><br>
	<a href="UpdateAuthorFormServlet">戻る</a>
</body>
</html>