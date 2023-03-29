<%@page import="dto.BookDTO"%>
<%@page import="dto.CategoryDTO"%>
<%@page import="dto.PublisherDTO"%>
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
			BookDTO book=(BookDTO)session.getAttribute("update_book");
			if(errorCode != null && errorCode.equals("1")){
	%>
		<p style="color:red">登録に失敗しました。</p>
		<h3>登録画面</h3>
		<form action="RegisterBookConfirmServlet?id=<%=book.getId() %>" method="post">
			<input type="number" name="isbn" placeholder="ISBN"value="<%=book.getIsbn()%>"><br>
			<input type="text"name="status" placeholder="ほんの"value="<%=book.getStatus()%>"><br>
			<select name="conditionnum">
				<option value="0">新書</option>
				<option value="1">旧書</option>
			</select>
			<input type="submit" value="登録">
		</form>
	<%
		} else {
	%>
	<div class="box3">
	<h3>登録画面</h3>
<form action="UpdateBookConfirmServlet?id=<%=book.getId() %>" method="post">
				<input type="number" name="isbn" placeholder="ISBN"value="<%=book.getIsbn()%>"><br>
			<input type="text"name="status" placeholder="ほんの"value="<%=book.getStatus()%>"><br>
			<select name="conditionnum">
				<option value="0">新書</option>
				<option value="1">旧書</option>
			</select>
			<input type="submit" value="登録">
		</form>
	</div>
	<%
		}
	%>
</body>
</html>