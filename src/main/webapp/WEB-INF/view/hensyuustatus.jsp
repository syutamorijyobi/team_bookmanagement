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
String title = request.getParameter("title");
String author_name = request.getParameter("author_name");
String category_name = request.getParameter("category_name");
int isbn = Integer.parseInt(request.getParameter("isbn"));
String publicher_name = request.getParameter("publisher_name");
String status = request.getParameter("status");
String condition = request.getParameter("condition");
%>
<p>タイトル:<%= title %><br>
<p>著者：<%= author_name %><br>
<p>カテゴリー:<%= category_name %><br>
<p>ISBN:<%= isbn %><br>
<p>出版社:<%= publicher_name %><br>
<p>状態:<%= status %><br>
<input type="radio" name="radiobutton" value="sinsyo"> 新書
<input type="radio" name="radiobutton" value="kyuuayo"> 旧書
</body>
</html>