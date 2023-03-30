<%@page import="dto.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.AllBookDTO"%>
<%@page import="dto.BookLogDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
				<th>ID</th>
				<th>名前</th>
				<th>メール</th>
				<th>権限</th>
			</tr>
<% List<UserDTO> user = (ArrayList<UserDTO>)session.getAttribute("user_list");
	List<UserDTO> root= (ArrayList<UserDTO>)session.getAttribute("root_list");
	for(UserDTO us:user){
		for(UserDTO ro:root){
			if(us.getId()==ro.getId()){
		%>
		<tr><td><%=us.getId() %></td>
			<td><%=us.getName() %></td>
			<td><%=us.getMail() %></td>
			<td><a href="DeleteRootServlet?id=<%= us.getId()%>">権限剥奪</a></td>
		</tr>
		<%}else{%>
		
		<tr><td><%=us.getId() %></td>
		<td><%=us.getName() %></td>
		<td><%=us.getMail() %></td>
		<td><a href="RegisterRootServlet?id=<%= us.getId()%>">権限付与</a></td>
		</tr>
		<%} }
	}
	%>
	</table>
</body>
</html>