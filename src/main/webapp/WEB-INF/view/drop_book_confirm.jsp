<%@page import="dto.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>下記のIsbnを削除します。よろしいですか？</p>
	<%
	BookDTO drop= (BookDTO)session.getAttribute("input_book");
	%>
	ISBN：<%=drop.getIsbn()%><br>
	<a href="DropBookExecuteServlet">OK</a><br>
	<a href="DropBookFormServlet">戻る</a>
</body>
</html>