<%@page import="servlet.SearchBookCategoryServlet"%>
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
	List<IsbnDTO> list_category = (List<IsbnDTO>)session.getAttribute("category_name"); 
	List<CategoryDTO> category_list = (List<CategoryDTO>)session.getAttribute("searchcategory_id");
	List<AuthorDTO> author_list = (List<AuthorDTO>)session.getAttribute("author_name"); 
	List<PublisherDTO> publisher_list = (List<PublisherDTO>)session.getAttribute("publisher_name");
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
	<%
	
	for(IsbnDTO category:list_category){
		for(CategoryDTO searchcategoryid:category_list){
			for(PublisherDTO searchpublisherid:publisher_list){
				for(AuthorDTO searchauthorchid:author_list){
					if(category.getCategory_id() == searchcategoryid.getId()){
			
	%>
		<tr>
			<td><%category.getTitlel(); %></td>
			<td><%if(category.getPublisher_id()==searchpublisherid.getId()){
					searchpublisherid.getPublisher_name();
				} %></td>
			<td><%if(category.getAuthor_id()==searchauthorchid.getId()){
				searchauthorchid.getAuthor_name();
			}
				%></td>
			<td><%if(category.getCategory_id()==searchcategoryid.getId()){
				searchcategoryid.getCategory_name();
			}%></td>
			<td><%category.getIsbn();%>
		</tr>
	<%
					}
				}
			}
		}
	}
	%>
	</table>
</body>
</html>