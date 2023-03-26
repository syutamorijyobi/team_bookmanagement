<%@page import="dto.AllBookDTO"%>
<%@page import="dto.BookLogDTO"%>
<%@page import="dto.BookDTO"%>
<%@page import="dao.BookDAO"%>
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
		List<AllBookDTO> book_list=(List<AllBookDTO>)session.getAttribute("lending");
			if(book_list==null){
		%>
		<h1>検索結果</h1>
		<h1>貸出予定リストに図書がありません</h1>
		<% }else{%>
		<h1>貸出リスト</h1>	
		<table border="1">
			<tr>
				<th>ID</th>
				<th>isbn</th>
				<th>タイトル</th>
				<th>追加</th>
			</tr>
		<% 
			for(AllBookDTO ab:book_list){
			%>
			<tr>
				<td><a href="Servlet?id=<%=ab.getId()%>"><%=ab.getId() %></a></td>
				<td><%=ab.getIsbn() %></td>
				<td><%=ab.getTitle()%></td>
				<td><a href="LendingDeleteServlet?id=<%=ab.getId()%>">削除</a></td>
			</tr>
			<%
			}
		%>
		</table>
		<%} %>
		<a href="LendingRegisterConfirmServlet">貸出確認画面へ</a>
		<a href="../">戻る	</a>
</body>
</html>