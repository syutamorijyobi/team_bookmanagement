<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dto.IsbnDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>下記の内容を削除します。よろしいですか？</p>
	<%
	IsbnDTO isbn = (IsbnDTO)session.getAttribute("input_isbn");
	%>
    Isbn:<%=isbn.getIsbn()%><br>
	<a href="DropIsbnExecuteServlet">OK</a><br>
	<a href="DropIsbnFormServlet">戻る</a>
</body>
</html>