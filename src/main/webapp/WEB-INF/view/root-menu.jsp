<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/root-menu.css">
<title>管理者画面</title>
</head>
<body>
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
<h1>管理者ページ</h1>
<%
	UserDTO pu = (UserDTO)session.getAttribute("root");
%>
<div class="namae">
	<p>ようこそ<%=pu.getName() %>さん</p>
</div>
<div class="menu">
            <div class="yoko">
                <div class="touroku">                    
                    <a href="RegisterAuthorFormServlet">図書登録</a> 
                </div>
                <div class="sakujyo">
                    <a href="">図書削除</a>
                </div>
            </div>
            <div class="yoko">
                <div class="hensyuu">
                    <a href="">図書編集</a> 
                </div>
                <div class="user">
                    <a href="SelectAllUser">ユーザー</a>
                </div>
            </div>
            <div class="yoko">
                <div class="kasidasi">
                    <a href="LendingApprovalListServlet">貸出待ち</a> 
                </div>
                <div class="henkyaku">
                    <a href="ReturnApprovalListServlet">返却待ち</a>
                </div>
            </div>
            <div class="rv">
                <a href="">レビュー承認待ち</a>
            </div>

        </div>
</body>
</html>