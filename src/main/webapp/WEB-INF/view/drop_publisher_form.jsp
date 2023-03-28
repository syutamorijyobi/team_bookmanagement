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
			if(errorCode != null && errorCode.equals("1")){
				PublisherDTO pu = (PublisherDTO)session.getAttribute("input_publisher");
	%>
		<p style="color:red">削除内容が重複</p>
		<h3>削除画面</h3>
		<form action="DropPublisherConfirmServlet" method="post">
			<input type="text" name="name" placeholder="name" value="<%=pu.getPublisher_name()%>"><br>
			<input type="submit" value="登録">
		</form>
	<%
		} else {
	%>
	<div class="box3">
	<h3>削除画面</h3>
	<form action="DropPublisherConfirmServlet" method="post">
		<input type="text" name="name" placeholder="name"><br>
		<input type="submit" value="登録" class="hoge">
	</form>
	</div>
	<%
		}
	%>
</body>
</html>