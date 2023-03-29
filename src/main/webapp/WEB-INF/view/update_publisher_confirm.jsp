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
	<p>下記の内容で更新します。よろしいですか？</p>
	<%
	PublisherDTO publisher = (PublisherDTO)session.getAttribute("input_update_publisher");
	%>
	名前：<%=publisher.getPublisher_name()%><br>
	名前（ひらがな）：<%=publisher.getPublisher_hiragana() %><br>
	<a href="UpdatePublisherExecuteServlet">OK</a><br>
	<a href="RootTopServlet">戻る</a>
</body>
</html>