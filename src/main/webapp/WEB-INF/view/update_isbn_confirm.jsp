<%@page import="dto.IsbnDTO"%>
<%@page import="dto.CategoryDTO"%>
<%@page import="dto.PublisherDTO"%>
<%@page import="dto.AuthorDTO"%>
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
	IsbnDTO isbn = (IsbnDTO)session.getAttribute("input_update_isbn");
	%>
	ISBN：<%=isbn.getIsbn()%><br>
	タイトル：<%=isbn.getTitlel() %><br>
	著者：<%for(AuthorDTO au:author_list){
		if(au.getId()==isbn.getAuthor_id()){
			%><%= au.getAuthor_name() %><%
		}
	} %>
	出版社：<%for(PublisherDTO pu:publisher_list){
		if(pu.getId()==isbn.getPublisher_id()){
			%><%= pu.getPublisher_name() %>
			<%}
	} %>
	カテゴリ：<%for(CategoryDTO ca:category_list){
		if(ca.getId()==isbn.getCategory_id()){
			%><%= ca.getCategory_name() %><%
		}
	} %>
	<a href="UpdateIsbnExecuteServlet">OK</a><br>
	<a href="RootTopServlet">戻る</a>
</body>
</html>