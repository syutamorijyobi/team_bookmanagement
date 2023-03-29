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
		<p style="color:red">登録失敗</p>
		<h3>登録画面</h3>
		<form action="RegisterBookConfirmServlet" method="post">
				<input type="number" name="isbn" placeholder="ISBN"value="<%=book.getIsbn()%>"><br>
		<button type="submit"formaction="SelectIsbnServlet" formmethod="post">検索</button><br>
			<input type="text"name="status" placeholder="ほんの"value="<%=book.getStatus()%>"><br>
			<select name="category_id">
				<option value="0">新書</option>
				<option value="0">旧書</option>
			</select>
					<%for(AuthorDTO au:author_list){
			if(au.getId()==isbn.getAuthor_id()){
				%><%=au.getAuthor_name() %>
				<% } %>
		<% } %>
		<%for(PublisherDTO pu:publisher_list){
			if(pu.getId()==isbn.getPublisher_id()){
				%><%=pu.getPublisher_name() %>
				<% } %>
		<% } %>
		<%for(CategoryDTO ca:category_list){
			if(ca.getId()==isbn.getCategory_id()){
				%><%=ca.getCategory_name() %>
				<% } %>
		<% } %>
			<input type="submit" value="登録">
		</form>
	<%
		} else {
			String selectisbn=request.getParameter("serchisbn");
			if(selectisbn!=null &&selectisbn.equals("1")){
				IsbnDTO is = (IsbnDTO)session.getAttribute("serch_isbn");
	%>
	<h3>登録画面</h3>
	<form action="RegisterBookConfirmServlet" method="post">
		<input type="number" name="isbn" placeholder="ISBN"value="<%=is.getIsbn()%>"><br>
		<button type="submit"formaction="SelectIsbnServlet" formmethod="post">検索</button><br>
			<input type="text"name="status" placeholder="ほんの"><br>
			<select name="conditionnum">
				<option value="0">新書</option>
				<option value="1">旧書</option>
			</select>
		<%for(AuthorDTO au:author_list){
			if(au.getId()==is.getAuthor_id()){
				%><%=au.getAuthor_name() %>
				<% } %>
		<% } %>
		<%for(PublisherDTO pu:publisher_list){
			if(pu.getId()==is.getPublisher_id()){
				%><%=pu.getPublisher_name() %>
				<% } %>
		<% } %>
		<%for(CategoryDTO ca:category_list){
			if(ca.getId()==is.getCategory_id()){
				%><%=ca.getCategory_name() %>
				<% } %>
		<% } %>
		<input type="submit" value="登録" class="hoge">
	</form>
	<%}else{ %>
	<h3>登録画面</h3>
		<form action="RegisterBookConfirmServlet" method="post">
			<input type="number"name="isbn">
			<button type="submit"formaction="SelectIsbnServlet" formmethod="post">検索</button><br>
			<input type="text"name="status" placeholder="ほんの"><br>
			<select name="conditionnum">
				<option value="0">新書</option>
				<option value="1">旧書</option>
			</select>
			
			<input type="submit" value="登録">
		</form>
	<%} }  %>
</body>
</html>