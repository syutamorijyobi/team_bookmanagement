<%@page import="java.util.ArrayList"%>
<%@page import="dto.AllBookDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
	request.setCharacterEncoding("UTF-8");
	List<AllBookDTO> list = (ArrayList<AllBookDTO>)session.getAttribute("root_book_list");
	if(list==null){
		%>
		<nav class="box1">
		<h1>検索結果</h1>
		<h1>一致する図書がありません</h1>
		</nav>
	<% }else{%>
<h1>検索結果</h1>	
<table border="1">
		<tr>
			<th>ID</th>
			<th>ISBN</th>
			<th>状態</th>
			<th>削除</th>
			<th>更新</th>
		</tr>
	<% for(AllBookDTO ab : list) {
		
	%>
		<tr>
		<td><%=ab.getId() %></td>
			<td><%=ab.getIsbn()%></td>
			<td><%=ab.getStatus() %></td>
			<td><a href="Servlet?id=<%=ab.getId()%>">削除</a></td>
			<td><a href="UpdateBookFormServlet?id=<%=ab.getId()%>">更新</a></td>
		</tr>
	<%} %>
	</table>
	<%} %>
</body>
</html>