<%@page import="dto.AuthorDTO"%>
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
			String errorCode = request.getParameter("error");
			if(errorCode != null && errorCode.equals("1")){
		AuthorDTO au = (AuthorDTO)session.getAttribute("input_data");
	%>
		<p style="color:red">登録内容が重複</p>
		<h3>登録画面</h3>
		<form action="RegisterAuthorConfirmServlet" method="post">
			<input type="text" name="name" placeholder="name" value="<%=au.getAuthor_name()%>"><br>
			<input type="email" name="hiragana" placeholder="ひらがな" value="<%=au.getAuthor_hiragana() %>"><br>
			<input type="submit" value="登録">
		</form>
	<%
		} else {
	%>
	<div class="box3">
	<h3>登録画面</h3>
	<form action="RegisterAuthorConfirmServlet" method="post">
		<input type="text" name="name" placeholder="name"><br>
		<input type="text" name="hiragana" placeholder="ひらがな"><br>
		<input type="submit" value="登録" class="hoge">
	</form>
	</div>
	<%
		}
	%>

</body>
</html>