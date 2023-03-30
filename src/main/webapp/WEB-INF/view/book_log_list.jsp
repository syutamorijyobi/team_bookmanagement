<%@page import="dto.BookLogDTO"%>
<%@page import="java.util.*"%>
<%@page import="dto.AllBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/book_log_list.css">
<title>貸出履歴</title>
</head>
<body>
		<%
	request.setCharacterEncoding("UTF-8");
	List<AllBookDTO> list = (ArrayList<AllBookDTO>)session.getAttribute("book_list");
	List<BookLogDTO> list2= (ArrayList<BookLogDTO>)session.getAttribute("book_log_list");
	if(list==null){
		%>
		<nav class="box1">
		<h1></h1>
		<h1>図書がありません</h1>
		</nav>
	<% }else{%>
<h1 class="title">貸出履歴</h1>
<table border="1">
		<tr>
			<th>ID</th>
			<th>ISBN</th>
			<th>タイトル</th>
			<th>カテゴリ</th>
			<th>追加</th>
			<th>レビュー</th>
		</tr>
	<% for(AllBookDTO ab : list) {
		for(BookLogDTO log:list2){
			if(ab.getId()==log.getBook_id()){
			
		%>	
		<tr>
			<td><a href="Servlet?id=<%=ab.getId()%>"><%=ab.getId() %></a></td>
			<td><a href="Servlet?id=<%=ab.getId()%>"><%=ab.getIsbn()%></a></td>
			<td><%=ab.getTitle()%></td>
			<td><%=ab.getCategory() %>
			<td><a href="LendingRegisterServlet?id=<%=log.getId()%>&title=<%=ab.getTitle() %>&isbn=<%=ab.getIsbn()%>">追加</a></td>
			<td><a href="RegisterReviewServlet?isbn=<%=ab.getIsbn() %>">レビュー</a>
		</tr>
	<%		}
		}
	} %>
	</table>
	<%} %>
	<a href="LendingListServlet">返却予定リスト</a>
</body>
</html>