<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>奥利给博客</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
	position: sticky;
	top: 0;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}


.userMenu {
	float: right;
}
</style>

</head>
<body>
	<div id="div1">
		<ul>
			<li><a href="home">首页</a></li>
			<li><a href="myBlog">我的博客</a></li>
			<li><a href="writeBlog">发布博客</a></li>
			<li class="userMenu"><c:if test="${not empty user}">
					<a href="loginOut">退出</a>
				</c:if></li>
			<li class="userMenu"><c:if test="${not empty user}">
					<a href="aboutMe">${user.name }</a>
				</c:if> <c:if test="${empty user }">
					<a href="login">登录</a>
				</c:if></li>

		</ul>
	</div>
</body>
</html>