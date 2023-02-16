<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			User us = (User)session.getAttribute("input_data");
	%>
		<p style="color:red">登録に失敗しました。</p>
		<h3>登録画面</h3>
		<form action="ConfirmServlet" method="post">
			<input type="text" name="name" placeholder="name" value="<%=us.getName()%>"><br>
			<input type="email" name="mail" placeholder="E-mail" value="<%=us.getMail() %>"><br>
			<input type="password" name="pw" placeholder="password"><br>
			<input type="submit" value="登録">
		</form>
	<%
		} else {
	%>
	<h3>登録画面</h3>
	<form action="ConfirmServlet" method="post">
		<input type="text" name="name" placeholder="name"><br>
		<input type="email" name="mail" placeholder="E-mail"><br>
		<input type="password" name="pw" placeholder="password"><br>
		<input type="submit" value="登録">
	</form>
	<%
		}
	%>
</body>
</html>