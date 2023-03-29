<%@page import="dto.AllBookDTO"%>
<%@page import="java.util.*" %>
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
	List<AllBookDTO> list = (ArrayList<AllBookDTO>)session.getAttribute("book_list");
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
			<th>タイトル</th>
			<th>カテゴリ</th>
			<th>追加</th>
		</tr>
	<% for(AllBookDTO ab : list) {
		
	%>
		<tr>
		<td><a href="Servlet?id=<%=ab.getId()%>"><%=ab.getId() %></a></td>
			<td><a href="Servlet?id=<%=ab.getId()%>"><%=ab.getIsbn()%></a></td>
			<td><%=ab.getTitle()%></td>
			<td><%=ab.getCategory() %>
			<td><a href="LendingRegisterServlet?id=<%=ab.getId()%>&title=<%=ab.getTitle() %>&isbn=<%=ab.getIsbn()%>">追加</a></td>
		</tr>
	<%} %>
	</table>
	<%} %>
	<a href="LendingListServlet">貸出予定リスト</a>
</body>
</html>