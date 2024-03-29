<%@page import="dto.IsbnDTO"%>
<%@page import="dto.AuthorDTO"%>
<%@page import="dto.CategoryDTO"%>
<%@page import="dto.PublisherDTO"%>
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
				IsbnDTO isbn = (IsbnDTO)session.getAttribute("input_isbn");
	%>
		<p style="color:red">登録内容が重複</p>
		<h3>ISBN登録画面</h3>
		<form action="RegisterIsbnConfirmServlet" method="post">
			<input type="number" name="isbn" placeholder="ISBN" value="<%=isbn.getIsbn()%>"><br>
			<input type="text"name="title" placeholder="タイトル"value="<%=isbn.getTitlel()%>"><br>
			<select name="author_id">
			<%for(AuthorDTO au:author_list){%>
				<option value="<%=au.getId()%>"><%=au.getAuthor_name() %>
			<% } %>
			</select>
			<select name="publisher_id">
			<%for(PublisherDTO pu:publisher_list){%>
				<option value="<%=pu.getId()%>"><%=pu.getPublisher_name() %>
			<% } %>
			</select>
			<select name="category_id">
				<%for(CategoryDTO ca:category_list){%>
				<option value="<%=ca.getId()%>"><%=ca.getCategory_name() %>
			<% } %>
			</select>
			<input type="submit" value="登録">
		</form>
	<%
		} else {
	%>
	<div class="box3">
	<h3>ISBN登録画面</h3>
	<form action="RegisterIsbnConfirmServlet" method="post">
		<input type="number" name="isbn" placeholder="ISBN"><br>
		<input type="text"name="title" placeholder="タイトル"><br>
		<select name="author_id">
		<%for(AuthorDTO au:author_list){%>
			<option value="<%=au.getId()%>"><%=au.getAuthor_name() %>
		<% } %>
		</select>
		<select name="publisher_id">
		<%for(PublisherDTO pu:publisher_list){%>
			<option value="<%=pu.getId()%>"><%=pu.getPublisher_name() %>
		<% } %>
		</select>
		<select name="category_id">
		<%for(CategoryDTO ca:category_list){%>
			<option value="<%=ca.getId()%>"><%=ca.getCategory_name() %>
		<% } %>
		</select>
		<input type="submit" value="登録" class="hoge">
	</form>
	</div>
	<%
		}
	%>
</body>
</html>