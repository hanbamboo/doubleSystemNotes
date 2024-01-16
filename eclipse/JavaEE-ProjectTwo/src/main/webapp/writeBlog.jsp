<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="daohang.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>写博客</title>

<style type="text/css">
body {
	padding: 0;
	margin: 0;
}

form {
	width: 450px;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background-color: #007AFF;
	border-radius: 10px;
	margin: 10px;
	padding: 10px;
	text-align: center;
}

h1 {
	color: white;
	font-size: 50px;
}

#b_title {
	width: 70%;
	border-radius: 10px;
	background-color: rgba(255, 255, 255, 0.7);
	padding: 10px;
	outline: none;
	font-family: "微软雅黑";
	border: none;
	text-align: center;
	font-weight: 500;
	font-size: 30px;
	color: #1d6eee;
	margin-top: 10px;
	margin-bottom: 10px;
}

textarea {
	width: 70%;
	font-family: "微软雅黑";
	border-radius: 10px;
	background-color: rgba(255, 255, 255, 0.7);
	padding: 10px;
	outline: none;
	font-weight: 500;
	border: none;
	font-size: 20px;
	color: #000000;
}

#b_write, #b_reset {
	width: 70%;
	font-family: "微软雅黑";
	border-radius: 10px;
	background-color: rgba(255, 255, 255, 0.7);
	padding: 10px;
	outline: none;
	font-weight: 500;
	border: none;
	font-size: 20px;
	color: #000000;
	margin-top: 10px;
	margin-bottom: 10px;
	cursor: pointer;
}

#b_write:hover, #b_reset:hover {
	color: #ffffff;
}

#nologin {
	font-size: 50px;
}
</style>
</head>
<body>
	<c:if test="${empty user}">
		<p id="nologin">
			未登录，请先<a href="login">登录</a>
		</p>
	</c:if>
	<c:if test="${not empty user}">
		<form action="createBlog" method="get">
			<h1>新的博客</h1>
			<input type="text" id="b_title" name="b_title" placeholder="请填写博客标题" />
			<br>
			<textarea id="b_context" name="b_context" placeholder="请设置博客内容"
				rows="5" cols="25"></textarea>
			<br> <br> <input type="submit" id="b_write" value="发布" />
			<input type="reset" id="b_reset" value="清空" />
		</form>
	</c:if>

</body>
</html>