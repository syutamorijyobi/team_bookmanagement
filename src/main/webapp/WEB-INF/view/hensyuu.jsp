<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
List<bookdto> booklist = (ArrayList<bookdto>)request.getAttribute("list");
for(bookdto s : booklist) {
%>
	<tr>
	    <td><%=s.getId() %></td>
		<td><a href= "HensyuAllServlet?Title=<%=s.getTitle() %>"><%=s.getTitle() %></a></td>
		<td><%=s.getPublicher_name() %></td>
		<td><%=s.getAuthor_name() %></td>
		<td><%=s.getCategory_name() %></td>
		<td><%=s.getiSBN() %></td>
		
	</tr>
<%} %>
</table>
</body>
</html>