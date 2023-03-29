<%@page import="java.util.ArrayList"%>
<%@page import="dto.IsbnDTO"%>
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
	List<IsbnDTO> list = (ArrayList<IsbnDTO>)session.getAttribute("root_isbn_list");
	if(list==null){
		%>
		<nav class="box1">
		<h1>結果</h1>
		<h1>isbnがありません</h1>
		</nav>
	<% }else{%>
<h1>結果</h1>	
<table border="1">
		<tr>
			<th>isbn</th>
			<th>タイトル</th>
			<th>削除</th>
			<th>更新</th>
		</tr>
	<% for(IsbnDTO ab : list) {
		
	%>
		<tr>
		<td><%=ab.getIsbn() %></td>
			<td><%=ab.getTitlel()%></td>
			<td><a href="Servlet?id=<%=ab.getIsbn()%>">削除</a></td>
			<td><a href="UpdateIsbnFormServlet?id=<%=ab.getIsbn()%>">更新</a></td>
		</tr>
	<%} %>
	</table>
	<%} %>
</body>
</html>