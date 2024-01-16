<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="changeUser" method="get">
		<h1 class="title">个人信息</h1>
		<a class="className">用户名</a> <input type="hidden" id="u_lname"
			name="u_lname"  value="${user.lname}" /> <input
			type="text" id="u_sname" name="u_sname" placeholder="请设置用户名"
			value="${user.sname}" /> <br> <a class="className">密&nbsp;&nbsp;&nbsp;码
		</a> <input type="password" id="u_pwd" name="u_pwd" placeholder="请设置登录密码"
			value="${user.pwd}" /> <br> <a class="className">手机号 </a> <input
			type="text" id="u_phone" name="u_phone" placeholder="请设置手机号"
			value="${user.phone}" /> <br> <a class="className">邮&nbsp;&nbsp;&nbsp;箱</a>
		<input type="text" id="u_mail" name="u_mail" placeholder="请设置邮箱"
			value="${user.mail}" /> <br> <input type="submit"
			id="u_changeUser" value="保存修改" />
	</form>
</body>
</html>