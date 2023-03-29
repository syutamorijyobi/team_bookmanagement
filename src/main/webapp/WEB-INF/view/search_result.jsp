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
	List<IsbnDTO> searchresult = (List<IsbnDTO>)request.getAttribute("searchresult");
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
	
	for(IsbnDTO result:searchresult){
	%>
		<tr>
			<td><%result.getTitlel(); %></td>
			<td><%for (PublisherDTO searchpublishername:publisher_list){
				if(result.getPublisher_id()==searchpublishername.getId()){
					searchpublishername.getPublisher_name();
				}
				} %></td>
			<td><%for (CategoryDTO searchcategoryname:category_list){
				if(result.getCategory_id()==searchcategoryname.getId()){
				searchcategoryname.getCategory_name();
			}
			}%></td>
			<td><%for (CategoryDTO searchcategoryname:category_list){
				if(result.getAuthor_id()==searchcategoryname.getId()){
				searchcategoryname.getCategory_name();
			}
			}
				%></td>
			<td><%result.getIsbn();%></td>
		</tr>
	<%
	
	}
	%>
	</table>
</body>
</html>