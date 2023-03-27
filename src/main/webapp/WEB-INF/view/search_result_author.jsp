<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.BookDTO"%>
<%@page import="dto.AuthorDTO"%>
<%@page import="dto.PublisherDTO"%>
<%@page import="dto.CategoryDTO"%>
<%@page import="dto.IsbnDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	List<IsbnDTO> list_category = (List<IsbnDTO>)session.getAttribute("search_author"); 
	List<CategoryDTO> category_list = (List<CategoryDTO>)session.getAttribute("category_list");

	%>
	<h3>検索結果</h3>
	<%
	
	%>
	<table>
		<tr>
			<th>タイトル</th>
			<th>出版社</th>
			<th>著者</th>
			<th>カテゴリ</th>
			<th>ISBN</th>
		</tr>
	<%for(IsbnDTO category:list_category){
		if(category.getCategory_id()==searchcategory_id.)
	%>
		<tr>
			<td><%category.getTitlel(); %></td>
			<td><%if(category.getPublisher_id()== %>
		</tr>
	<%
	}
	%>
	</table>
</body>
</html>