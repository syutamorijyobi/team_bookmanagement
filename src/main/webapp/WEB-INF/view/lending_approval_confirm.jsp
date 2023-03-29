<%@page import="java.util.List"%>
<%@page import="dto.BookLogDTO"%>
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
		List<BookLogDTO> book_log=(List<BookLogDTO>)session.getAttribute("lending_approval_log");
			if(book_log==null){
		%>
		貸し出し承認待ちの本がありません。
		<%}else{ %>
		<table border=1>
		<tr><th>id</th>
		</tr>
		<%for(BookLogDTO b:book_log) {%>
		<tr><td><%=b.getBook_id() %></td>
		</tr>
		<%} %>
		</table>
		<a href="LendingApprovalExecuteServlet">承認</a>
		<%} %>
</body>
</html>