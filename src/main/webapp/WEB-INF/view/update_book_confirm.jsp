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
<p>下記の内容で登録します。よろしいですか？</p>
	<%
	BookDTO book= (BookDTO)session.getAttribute("input_book");
	%>
	ISBN：<%=book.getIsbn()%><br>
	本の状態：<%=book.getStatus()%>
	状態：<%if(book.isCondition()){ %>
	新書
	<%}else{ %>
	旧書
	<%} %>
	<a href="RegisterBookExecuteServlet">OK</a><br>
	<a href="RegisterBookFormServlet">戻る</a>
</body>
</html>