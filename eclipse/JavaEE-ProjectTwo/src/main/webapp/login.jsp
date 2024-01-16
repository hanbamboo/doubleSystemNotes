<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录到奥利给博客</title>
<style type="text/css">
body {
	padding: 0;
	margin: 0;
}

form {
	width: 500px;
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

.title {
	color: white;
	font-size: 50px;
}

.className {
	color: #FFFFFF;
	font-size: 30px;
	margin: 10px;
}

#u_name, #u_pwd, #u_phone, #u_mail {
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

#u_login {
	width: 30%;
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

#u_login:hover {
	background-color: rgba(85, 85, 255, 0.7);
	color: #FFFFFF;
	cursor: pointer;
}

.toRe {
	color: #FFFFFF;
	font-size: 20px;
	margin: 10px;
}
</style>
</head>
<body>
	<form action="checkUser" method="get">
		<h1 class="title">登录</h1>
		<a class="className">用户名</a><input type="text" id="u_name"
			name="u_name" placeholder="请填写用户名" /> <br> <a class="className">密&nbsp;&nbsp;&nbsp;码</a><input
			type="text" id="u_pwd" name="u_pwd" placeholder="请填写登录密码" /> <br>
		<input type="submit" id="u_login" value="登录" /><br> <a
			href="register" class="toRe">去注册</a>
	</form>
</body>
</html>