<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/register_form.css">
<title>登録画面</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
			String errorCode = request.getParameter("error");
			if(errorCode != null && errorCode.equals("1")){
		UserDTO us = (UserDTO)session.getAttribute("input_data");
	%>
		<p style="color:red">登録に失敗しました。</p>
		<h3>登録画面</h3>
		<form action="RegisterConfirmServlet" method="post">
			<input type="text" name="name" placeholder="name" value="<%=us.getName()%>"><br>
			<input type="email" name="mail" placeholder="E-mail" value="<%=us.getMail() %>"><br>
			<input type="password" name="pw" placeholder="password"><br>
			<input type="submit" value="登録">
		</form>
	<%
		} else {
	%>
	<div class="box3">
	<h3>登録画面</h3>
	<form action="RegisterConfirmServlet" method="post">
		<input type="text" name="name" placeholder="name"><br>
		<input type="email" name="mail" placeholder="E-mail"><br>
		<input type="password" name="pw" placeholder="password"><br>
		<input type="submit" value="登録" class="hoge">
	</form>
	</div>
	<%
		}
	%>
</body>
</html>