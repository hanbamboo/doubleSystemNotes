<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x"
	uri="http://jakarta.apache.org/taglibs/standard/scriptfree"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./js/jquery-3.6.0.js" type="text/javascript"
	charset="utf-8"></script>
<script src="./js/jquerysession.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
	function checkRule() {
		if (document.getElementById("u_lname").value == '') {
			window.location.href = "${pageContext.request.contextPath}/home#notice-name";
			return false;
		}
		if (document.getElementById("u_pwd").value == '') {
			window.location.href = "${pageContext.request.contextPath}/home#notice-pwd";
			return false;
		}

		return true;
	}
</script>
<style type="text/css">
body {
	background-color: #A4D6A6;
	padding: 0;
	margin: 0;
	font-family: "arial,微软雅黑";
}

#footer {
	margin-top: 100px;
}

.font-grey {
	color: #B5BDCE;
	font-weight: bold;
	font-size: 20px;
}

.font-green {
	color: #A4D6A6;
	font-weight: bold;
	font-size: 20px;
	transition: 0.3s;
	text-decoration: none;
}

#login_page {
	background-color: #FFFFFF;
	position: absolute;
	top: 0px;
	padding-top: 100px;
	padding-right: 100px;
	padding-left: 100px;
	height: 80vh;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	box-shadow: 0 0 15px #adadad;
	border-radius: 10px;
	top: 50%;
	left: 50%;
}

.title {
	color: #555555;
	font-size: 32px;
	margin-bottom: 10px;
}

.show-title:hover {
	color: #87af87;
	cursor: pointer;
}

.little-title {
	font-weight: 700;
	color: #555555;
	font-size: 16px;
	margin-bottom: 20px;
}

.input-div {
	margin-top: 30px;
}

.little-div {
	padding-bottom: 30px;
}

.input {
	outline: none;
	border: none;
	border-radius: 15px;
	background-color: #F3F6F9;
	height: 60px;
	width: 400px;
	font-size: 16px;
	color: #555555;
	padding-left: 20px;
	padding-right: 20px;
	font-weight: 300;
	transition: 0.2s;
	margin-top: 5px;
	letter-spacing: 5px;
}

.input::-webkit-input-placeholder {
	color: #555555;
}

.input:focus {
	background-color: #EBEDF3;
}

.forgetpwd {
	float: right;
	font-size: 16px;
}

.login {
	background-color: #A4D6A6;
	outline: none;
	border: none;
	color: #FFFFFF;
	font-weight: 700;
	font-size: 16px;
	padding-top: 15px;
	padding-bottom: 15px;
	padding-left: 40px;
	padding-right: 40px;
	border-radius: 10px;
	margin-top: 40px;
	margin-right: 5px;
	transition: 0.3s;
}

.login:hover {
	background-color: #87af87;
}

.login-with {
	background-color: #c8d8c2;
	text-decoration: none;
	outline: none;
	border: none;
	color: #FFFFFF;
	margin-left: 5px;
	font-weight: 700;
	font-size: 16px;
	padding-top: 15px;
	padding-bottom: 15px;
	padding-left: 40px;
	padding-right: 40px;
	border-radius: 10px;
	margin-top: 40px;
	transition: 0.3s;
}

.login-with:hover {
	background-color: #A4D6A6;
	color: #FFFFFF;
}

.footer-tools {
	text-decoration: none;
}

.footer-tools:hover {
	text-decoration: none;
	color: #87af87;
	cursor: pointer;
}

.margin-horizontal-20 {
	margin-left: 20px;
	margin-right: 20px;
}

.modal-window {
	position: fixed;
	background-color: rgba(164, 214, 166, 0.25);
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	z-index: 999;
	visibility: hidden;
	opacity: 0;
	pointer-events: none;
	transition: all 0.3s;
}

.modal-window:target {
	visibility: visible;
	opacity: 1;
	pointer-events: auto;
}

.modal-window>div {
	width: 400px;
	position: absolute;
	top: 50%;
	left: 50%;
	-webkit-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
	padding: 2em;
	background: #A4D6A6;
	border-radius: 10px;
}

.modal-window header {
	font-weight: bold;
}

.notice-title {
	color: #455a45;
}

.modal-window h1 {
	font-size: 150%;
	margin: 0 0 15px;
}

.modal-close {
	cursor: pointer;
	color: #455a45;
	line-height: 50px;
	font-size: 14px;
	position: absolute;
	right: 0;
	text-align: center;
	top: 0;
	width: 70px;
	text-decoration: none;
}

.notice-context {
	font-weight: 500;
	color: #435844;
}
</style>
</head>
<body>
	<div id="notice-name" class="modal-window">
		<div>
			<a href="#" title="Close" class="modal-close">关闭</a>
			<h1 class="notice-title">你有一条新提示</h1>
			<div class="notice-context">请填写账号</div>

		</div>
	</div>
	<div id="notice-pwd" class="modal-window">
		<div>
			<a href="#" title="Close" class="modal-close">关闭</a>
			<h1 class="notice-title">你有一条新提示</h1>
			<div class="notice-context">请填写密码</div>

		</div>
	</div>
	<div id="login_page">
		<form action="checkUser" method="get">
			<div class="little-div">
			<!-- <embed src="assests/logo.svg" width="50" height="50" type="image/svg+xml"/> -->
				<h3 class="title">Welcome to MedicineGod</h3>
				<span class="font-grey">New Here? <a
					class="font-green show-title" href="register">Create an Account</a>
				</span>
			</div>
			<div class="input-div">
				<label class="little-title">Email / LoginName / Phone</label> <br>
				<input class="input" id="u_lname" type="text" name="u_lname"
					placeholder="" autocomplete="off">

			</div>

			<div class="input-div">
				<label class="little-title">Password</label> <a
					class="font-green show-title forgetpwd">Forgot Password ?</a> <br>
				<input class="input" type="password" id="u_pwd" name="u_pwd"
					placeholder="" autocomplete="off">
			</div>


			<div>
				<button class="login" onclick="return checkRule()">Sign In
				</button>
				<a class="login-with">Sign in with WeChat</a>
			</div>

		</form>
		<div id="footer">
			<a class="font-green footer-tools margin-horizontal-20" href="#">AboutUs</a>
			<a class="font-green footer-tools margin-horizontal-20" href="#">FeedBack</a>
			<a class="font-green footer-tools margin-horizontal-20" href="#">Contact
				Us</a>
		</div>
	</div>

</body>

</html>