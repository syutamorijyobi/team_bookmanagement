<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dto.AuthorDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>下記の内容を削除します。よろしいですか？</p>
	<%
	AuthorDTO au = (AuthorDTO)session.getAttribute("input_author");
	%>
	名前：<%=au.getAuthor_name()%><br>
	<a href="DropAuthorExecuteServlet">OK</a><br>
	<a href="DropAuthorFormServlet">戻る</a>
</body>
</html>