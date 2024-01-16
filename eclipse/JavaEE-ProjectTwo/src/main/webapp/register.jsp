<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册奥利给博客</title>
<style type="text/css">
body {
	padding: 0;
	margin: 0;
}

form {
	width: 600px;
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

#u_register {
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

#u_register:hover {
	background-color: rgba(85, 85, 255, 0.7);
	color: #FFFFFF;
	cursor: pointer;
}

.toLo {
	color: #FFFFFF;
	font-size: 20px;
	margin: 10px;
}
</style>
</head>
<body>
	<form action="saveUser" method="get">
		<h1 class="title">注册</h1>
		<a class="className">用户名</a> <input type="text" id="u_name"
			name="u_name" placeholder="请设置用户名" /> <br>
		<a class="className">密&nbsp;&nbsp;&nbsp;码 </a> <input type="text"
			id="u_pwd" name="u_pwd" placeholder="请设置登录密码" /> <br> <a
			class="className">手机号 </a> <input type="text" id="u_phone"
			name="u_phone" placeholder="请设置手机号" /> <br> <a
			class="className">邮&nbsp;&nbsp;&nbsp;箱</a> <input type="text"
			id="u_mail" name="u_mail" placeholder="请设置邮箱" /> <br> <input
			type="submit" id="u_register" value="注册" /> <br>
		<a href="login" class="toLo">去登录</a>
	</form>
</body>
</html>