<%@page import="dto.BookDTO"%>
<%@page import="dto.AuthorDTO"%>
<%@page import="dto.PublisherDTO"%>
<%@page import="dto.CategoryDTO"%>
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
	List<AuthorDTO> author_list = (List<AuthorDTO>)session.getAttribute("author_list");
	List<PublisherDTO> publisher_list = (List<PublisherDTO>)session.getAttribute("publisher_list");
	List<CategoryDTO> category_list = (List<CategoryDTO>)session.getAttribute("category_list");
			String errorCode = request.getParameter("error");
			if(errorCode != null && errorCode.equals("1")){
				BookDTO book = (BookDTO)session.getAttribute("input_book");
				IsbnDTO isbn=(IsbnDTO)session.getAttribute("serch_isbn");
	%>
		<p style="color:red">削除失敗</p>
		<h3>削除画面</h3>
		<form action="DropBookConfirmServlet" method="post">
				<input type="number" name="isbn" placeholder="ISBN"value="<%=book.getIsbn()%>"><br>
			<input type="submit" value="削除">
		</form>
	<%
		} else {
			String selectisbn=request.getParameter("serchisbn");
			if(selectisbn!=null &&selectisbn.equals("1")){
				IsbnDTO is = (IsbnDTO)session.getAttribute("serch_isbn");
	%>
	<h3>削除画面</h3>
	<form action="DropBookConfirmServlet" method="post">
		<input type="number" name="isbn" placeholder="ISBN"value="<%=is.getIsbn()%>"><br>
		<input type="submit" value="削除" class="hoge">
	</form>
	<%}else{ %>
	<h3>削除画面</h3>
		<form action="DropBookConfirmServlet" method="post">
			<input type="number"name="isbn">
			<input type="submit" value="削除">
		</form>
	<%} }  %>
</body>
</html>