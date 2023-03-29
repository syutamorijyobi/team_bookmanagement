<%@page import="java.util.List"%>
<%@page import="dto.UserDTO"%>
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
		List<UserDTO> log_user=(List<UserDTO>)session.getAttribute("log_user");
			if(log_user==null){
		%>
		貸し出し承認待ちのユーザがいません。
		<%}else{ %>
		<table border=1>
		<tr><th>名前</th>
			<th>メールアドレス</th>
		</tr>
		<%for(UserDTO u:log_user) {%>
		<tr>
			<td><a href="LendingApprovalConfirmServlet?user_id=<%= u.getId()%>"><%=u.getName() %></td>
			<td><%=u.getMail() %></td>
		</tr>
		<%} %>
		</table>
		<%} %>
</body>
</html>