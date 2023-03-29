<%@page import="dto.BookLogDTO"%>
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
	List<BookLogDTO> list = (ArrayList<BookLogDTO>)session.getAttribute("lending_log");
	if(list==null){
		%>
		<h1>結果</h1>
		<h1>貸出予定リストに	貸出予定の本がありません</h1>
	<% }else{%>
	<h1>貸出予定</h1>	
	<% for(BookLogDTO ab : list) {
	%>
	<p>id:<%= ab.getBook_id() %></p>
	<%} %>
	<a href="LendingRegisterExecuteServlet">貸出申請送信</a>
	<%} %>
</body>
</html>