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
	<p>下記の内容で登録します。よろしいですか？</p>
	<%
	PublisherDTO publisher = (PublisherDTO)session.getAttribute("input_publisher");
	%>
	名前：<%=publisher.getPublisher_name()%><br>
	名前（ひらがな）：<%=publisher.getPublisher_hiragana() %><br>
	<a href="RegisterPublisherExecuteServlet">OK</a><br>
	<a href="RegisterPublisherFormServlet">戻る</a>
</body>
</html>