<%@page import="dto.PublisherDTO"%>
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
		PublisherDTO us = (PublisherDTO)session.getAttribute("input_update_publisher");
			if(errorCode != null && errorCode.equals("1")){
	%>
		<p style="color:red">登録に失敗しました。</p>
		<h3>登録画面</h3>
		<form action="UpdatePublisherConfirmServlet?id=<%=us.getId() %>" method="post">
			<input type="text" name="name" placeholder="name" value="<%=us.getPublisher_name()%>"><br>
			<input type="email" name="mail" placeholder="hiragana" value="<%=us.getPublisher_hiragana() %>"><br>
			<input type="submit" value="登録">
		</form>
	<%
		} else {
	%>
	<div class="box3">
	<h3>登録画面</h3>
	<form action="UpdatePublisherConfirmServlet?id=<%=us.getId() %>" method="post">
			<input type="text" name="name" placeholder="name" value="<%=us.getPublisher_name()%>"><br>
			<input type="email" name="mail" placeholder="hiragana" value="<%=us.getPublisher_hiragana()%>"><br>
			<input type="submit" value="登録">
	</form>
	</div>
	<%
		}
	%>
</body>
</html>