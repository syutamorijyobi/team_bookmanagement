<%@page import="java.util.ArrayList"%>
<%@page import="dto.BookLogDTO"%>
<%@page import="java.util.List"%>
<%@page import="dto.AllBookDTO"%>
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
		List<BookLogDTO> book_list=(List<BookLogDTO>)session.getAttribute("return");
		List<AllBookDTO> list = (ArrayList<AllBookDTO>)session.getAttribute("book_list");
			if(book_list==null){
		%>
		<h1>検索結果</h1>
		<h1>返却予定リストに図書がありません</h1>
		<% }else{%>
		<h1>返却リスト</h1>	
		<table border="1">
			<tr>
				<th>ID</th>
				<th>isbn</th>
				<th>タイトル</th>
				<th>追加</th>
			</tr>
		<% 
		for(AllBookDTO ab : list) {
			for(int num=0;num<book_list.size();num++) {
				if(ab.getId()==book_list.get(num).getBook_id()){
			%>
			<tr>
				<td><a href="Servlet?id=<%=book_list.get(num).getId()%>"><%=book_list.get(num).getId() %></a></td>
				<td><%=ab.getIsbn() %></td>
				<td><%=ab.getTitle()%></td>
				<td><a href="ReturnDeleteListServlet?num=<%=num %>">削除</a></td>
			</tr>
			<%
				}
			}
		}
		%>
		</table>
		<%} %>
		<a href="ReturnRegisterConfirmServlet">返却確認画面へ</a>
		<a href="../">戻る	</a>
</body>
</html>