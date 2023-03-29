<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/forget-form.css">
<title>パスワード再設定画面</title>
</head>
<body>
<%
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
		String mail=request.getParameter("email");
%>
<h1>お客様情報の入力</h1>
<p>パスワードの再設定を行うE-mailを入力してください</p>
<form action="ForgetPasswordResultServlet">
<input type="email"name="email" value="<%=mail%>"required><br>
<input type= "submit"value="送信"><br>
</form>
<%}else{ %>
<div class="box">
<form action="ForgetPasswordResultServlet">
<h1>お客様情報の入力</h1>
<p>パスワードの再設定を行うE-mailを入力してください</p>
<input type="email"name="email" placeholder="E-mail" required><br>
<input type= "submit"value="送信" class="send"><br>
</form>
</div>
<%}%>
</body>
</html>