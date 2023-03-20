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
<p>下記の内容で登録します。よろしいですか？</p>
	<%
	List<AuthorDTO> author_list = (List<AuthorDTO>)session.getAttribute("author_list");
	List<PublisherDTO> publisher_list = (List<PublisherDTO>)session.getAttribute("publisher_list");
	List<CategoryDTO> category_list = (List<CategoryDTO>)session.getAttribute("category_list");
	BookDTO book= (BookDTO)session.getAttribute("input_book");
	%>
	ISBN：<%=book.getIsbn()%><br>
	本の状態：<%=book.getStatus()%>
	状態：<%if(book.isCondition()){ %>
	新書
	<%}else{ %>
	旧書
	<%} %>
	<a href="RegisterBookExecuteServlet">OK</a><br>
	<a href="RegisterBookFormServlet">戻る</a>
</body>
</html>