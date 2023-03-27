<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>図書検索</h1>
	<form action="SearchBookConfirmServlet" method="post">
		<select name="sch">
		<option value="author">著者名</option>
		<option value="publisher">出版社名</option>
		<option value="title">著書名</option>
		<option value="category">カテゴリ</option>
		<option value="isbn">ISBN</option>
		</select>
		<input type="text" name="search">
		<input type="submit" value="検索">
	</form>
	<a href="SearchBookAllItemServlet">複数項目から検索</a>
	
</body>
</html>