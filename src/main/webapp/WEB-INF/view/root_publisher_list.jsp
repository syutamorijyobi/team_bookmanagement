<%@page import="dto.PublisherDTO"%>
<%@page import="java.util.*"%>
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
	List<PublisherDTO> list = (ArrayList<PublisherDTO)session.getAttribute("root_publisher_list");
	if(list==null){
		%>
		<nav class="box1">
		<h1>結果</h1>
		<h1>著者がありません</h1>
		</nav>
	<% }else{%>
<h1>結果</h1>	
<table border="1">
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>名前（ひらがな）</th>
			<th>削除</th>
			<th>更新</th>
		</tr>
	<% for(AuthorDTO ab : list) {
		
	%>
		<tr>
		<td><%=ab.getId() %></td>
			<td><%=ab.getAuthor_name()%></td>
			<td><%=ab.getAuthor_hiragana()%></td>
			<td><a href="Servlet?id=<%=ab.getId()%>">削除</a></td>
			<td><a href="UpdatePublisherFormServlet?id=<%=ab.getId()%>">更新</a></td>
		</tr>
	<%} %>
	</table>
	<%} %>
</body>
</html>