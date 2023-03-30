<%@page import="java.util.ArrayList"%>
<%@page import="dto.BookLogDTO"%>
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
	List<BookLogDTO> list = (ArrayList<BookLogDTO>)session.getAttribute("return");
	if(list==null){
		%>
		<h1>結果</h1>
		<h1>返却予定リストに	貸出予定の本がありません</h1>
	<% }else{%>
	<h1>返却予定</h1>	
	<% for(BookLogDTO ab : list) {
	%>
	<p>id:<%= ab.getBook_id() %></p>
	<%} %>
	<a href="ReturnRegisterExecuteServlet">返却申請送信</a>
	<%} %>
</body>
</html>