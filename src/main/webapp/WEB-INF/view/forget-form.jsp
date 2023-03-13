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
		String mail=request.getParameter("email");
%>
<form action="ForgetPasswordResultServlet">
<input type="email"name="email" value="<%=mail%>"required><br>
<input type= "submit"value="送信"><br>
</form>
<%}else{ %>
<form action="ForgetPasswordResultServlet">
<input type="email"name="email"required><br>
<input type= "submit"value="送信"><br>
</form>
<%}%>
</body>
</html>