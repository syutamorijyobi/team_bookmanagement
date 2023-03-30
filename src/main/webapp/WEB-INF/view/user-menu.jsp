<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/user-menu.css">
<title>Insert title here</title>
</head>
<body>
	<div class="logo">
<a href="/"><img src="images/aicon.jpg"></a>
</div>
<div class="header__flex">
    <nav>
      <ul>
        <li><a href="#" style="text-decoration:none;">検索:右向き虫眼鏡:</a></li>
        <li><a href="BookLogListServlet" style="text-decoration:none;">貸出履歴:緑の本:</a></li>
        <li><a href="#" style="text-decoration:none;">返却:オレンジの本:</a></li>
        <li><a href="#" class="btn btn--orange">logout</a></li>
      </ul>
    </nav>
  </div>
  <div class="menu">
  	<div class="yoko">
  		<div class="kensaku">
  			<a href="">検索</a>
  		</div>
  		<div class="henkyaku">
  			<a href="">返却</a>
  		</div>
  	</div>	
  </div>
	<a href="SelectAllBookServlet">図書取得</a>
</body>
</html>