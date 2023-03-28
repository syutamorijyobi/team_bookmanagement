<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@page import="dto.AuthorDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
			String errorCode = request.getParameter("error");
			if(errorCode != null && errorCode.equals("1")){
		AuthorDTO au = (AuthorDTO)session.getAttribute("input_data");
	%>
		<p style="color:red">削除内容が見つからない</p>
		<h3>削除画面</h3>
		<form action="DropAuthorConfirmServlet" method="post">
			<input type="text" name="name" placeholder="name" value="<%=au.getAuthor_name()%>"><br>
			<input type="submit" value="削除">
		</form>
	<%
		} else {
	%>
<h1>図書削除</h1>
<form action="DropAuthorConfirmServlet" method="post">
著者名：<input type="text"  name="name"placeholder="name" ><br>
<input type="submit" value="削除">
</form>
<%
		}
	%>
</body>
</html>