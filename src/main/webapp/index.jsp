<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("error") != null){	
	%>
		<p style="color:red">ログイン失敗</p>
	<form action="LoginServlet" method="post">
		○○図書館<br>
		E-mail：<input type="text" name="mail" value="<%=request.getParameter("mail") %>"><br>
		password：<input type="password" name="pw"><br>
		<input type="submit" value="SIGN-IN">
	</form>
	<a href="FormServlet">新規登録</a><br>
	<a href="">パスワードを忘れた方はこちらから</a>
	<%
		} else {
	%>
	<form action="LoginServlet" method="post">
		○○図書館<br>
		E-mail：<input type="text" name="mail"><br>
		password：<input type="password" name="pw"><br>
		<input type="submit" value="SIGN-IN">
	</form>
	<a href="FormServlet">新規登録</a><br>
	<a href="">パスワードを忘れた方はこちらから</a>
	<%
		}
	%>
</body>
</html>