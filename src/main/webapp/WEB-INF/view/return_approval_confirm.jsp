<%@page import="dto.AllBookDTO"%>
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
		List<BookLogDTO> book_log=(List<BookLogDTO>)session.getAttribute("return_approval_log");
		List<AllBookDTO> all_book=(List<AllBookDTO>)session.getAttribute("book_list");
		if(book_log==null){
		%>
		返却承認待ちの本がありません。
		<%}else{ %>
		<table border=1>
		<tr><th>id</th>
			<th>タイトル</th>
		</tr>
		<%
		for(AllBookDTO al:all_book){
		for(BookLogDTO b:book_log) {
			if(al.getId()==b.getBook_id()){
		%>
		<tr><td><%=b.getBook_id() %></td>
			<td><%=al.getTitle() %>
		</tr>
		<%}}} %>
		</table>
		<a href="ReturnApprovalExecuteServlet">承認</a>
		<%} %>
</body>
</html>