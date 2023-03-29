<%@page import="dto.IsbnDTO"%>
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
				IsbnDTO isbn = (IsbnDTO)session.getAttribute("input_isbn");
	%>
		<p style="color:red">削除内容が重複</p>
		<h3>削除画面</h3>
		<form action="DropConfirmServlet" method="post">
			<input type="number" name="isbn" placeholder="ISBN" value="<%=isbn.getIsbn()%>"><br>
			<input type="submit" value="削除">
		</form>
	<%
		} else {
	%>
	<div class="box3">
	<h3>削除画面</h3>
	<form action="DropIsbnConfirmServlet" method="post">
		<input type="number" name="isbn" placeholder="ISBN"><br>
		<input type="submit" value="削除" class="hoge">
	</form>
	</div>
	<%
		}
	%>
</body>
</html>