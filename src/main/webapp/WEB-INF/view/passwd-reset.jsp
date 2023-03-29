<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/passwd-reset.css">
<title>パスワード再設定</title>
</head>
<body>
<div class="box">
<form action="ChangePasswdResultServlet">
<h1>パスワード再設定</h1>
<p>新しいパスワード</p>
<input type="password"name="pw" placeholder="password" required><br>
<input type="submit"value="送信" class="send">
</form>
</div>
</body>
</html>