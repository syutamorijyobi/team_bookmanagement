<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.IsbnDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/review.css">
<title>レビュー投稿</title>
</head>
<body>
	<%
	int isbn =Integer.parseInt( request.getParameter("isbn"));
	IsbnDTO ib = (IsbnDTO)session.getAttribute("input_isbn");
	%>
	<div class="logo">
<a href="/"><img src="images/aicon.jpg"></a>
</div>
<div class="header__flex">
    <nav>
      <ul>
        <li><a href="#" style="text-decoration:none;">検索:右向き虫眼鏡:</a></li>
        <li><a href="#" style="text-decoration:none;">貸出履歴:緑の本:</a></li>
        <li><a href="#" style="text-decoration:none;">返却:オレンジの本:</a></li>
        <li><a href="#" class="btn btn--orange">logout</a></li>
      </ul>
    </nav>
  </div>
  	<form action="RegisterReviewConfirmServlet?isbn=<%=isbn %>" method="post">
  	評価:<select name="evaluation">
  		<option value="1">1</option>
  		<option value="2">2</option>
  		<option value="3">3</option>
  		<option value="4">4</option>
  		<option value="5">5</option>
    </select><br>
			<input type="text" name="content" class="hoge"><br>
			<input type="submit" value="投稿" class="hoge2">
	</form>
</body>
</html>