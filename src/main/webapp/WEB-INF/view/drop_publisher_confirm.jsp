<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dto.PublisherDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>下記の内容で削除します。よろしいですか？</p>
	<%
	PublisherDTO publisher = (PublisherDTO)session.getAttribute("input_publisher");
	%>
	名前：<%=publisher.getPublisher_name()%><br>
	<a href="DropPublisherExecuteServlet">OK</a><br>
	<a href="DropPublisherFormServlet">戻る</a>
</body>
</html>