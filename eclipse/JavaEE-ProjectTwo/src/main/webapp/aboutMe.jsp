<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="daohang.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">


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

#title {
	color: white;
	font-size: 50px;
}

.className{
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

#u_edituser {
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

#u_edituser:hover {
	background-color: rgba(85, 85, 255, 0.7);
	color: #FFFFFF;
	cursor: pointer;
}
</style>
<meta charset="UTF-8">
<title>${user.name }的个人中心</title>
</head>
<body>
	<form action="changeUser" method="get">
		<h1 id="title">个人中心</h1>
		<a class="className">用户名 </a><input type="text" id="u_name" name="u_name"
			value="${user.name }" /> <br> <a class="className">密&nbsp;&nbsp;&nbsp;码</a> <input
			type="text" id="u_pwd" name="u_pwd" value="${user.pwd }" /> <br>
		<a class="className"> 手机号</a> <input type="text" id="u_phone" name="u_phone"
			value="${user.phone }" /> <br> <a class="className">邮&nbsp;&nbsp;&nbsp;箱</a> <input
			type="text" id="u_mail" name="u_mail" value="${user.emai }" /> <br>
		<input type="submit" id="u_edituser" value="修改" />
	</form>

</body>
</html>