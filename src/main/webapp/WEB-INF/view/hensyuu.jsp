<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.BookDTO" %>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>図書編集</h1>
<form action="Hensyuuservlet" method="post">
ISBN：<input type="text"  name="ISBN"><br>
<input type="submit" value="指定">
</form>
<table border="1">
	<tr>
	    <th>ID</th>
	    <th>タイトル</th>
		<th>出版社</th>
		<th>著者</th>
		<th>カテゴリー</th>
		<th>ISBN</th>
	</tr>
<%
List<BookDTO> booklist = (ArrayList<BookDTO>)request.getAttribute("list");
for(BookDTO s : booklist) {
%>
	<tr>

		
	</tr>
<%} %>
</table>
</body>
</html>