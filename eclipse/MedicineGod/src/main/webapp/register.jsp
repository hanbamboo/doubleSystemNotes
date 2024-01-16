<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
	function checkRule() {
		if (document.getElementById("u_lname").value == '') {
			window.location.href = "${pageContext.request.contextPath}/register#notice-r-lname1";
			return false;
		}
		if (document.getElementById("u_sname").value == '') {
			window.location.href = "${pageContext.request.contextPath}/register#notice-r-sname1";
			return false;
		}
		if (document.getElementById("u_pwd").value == '') {
			window.location.href = "${pageContext.request.contextPath}/register#notice-r-pwd1";
			return false;
		}
		if (document.getElementById("u_phone").value == '') {
			window.location.href = "${pageContext.request.contextPath}/register#notice-r-phone1";
			return false;
		}
		if (document.getElementById("u_mail").value == '') {
			window.location.href = "${pageContext.request.contextPath}/register#notice-r-mail1";
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
	margin-top: 150px;
}

.font-grey {
	color: #B5BDCE;
	font-weight: bold;
	font-size: 20px;
}

.little-notice {
	color: #B5BDCE;
	font-weight: bold;
	font-size: 16px;
}

.little-notice-green {
	color: #A4D6A6;
	font-weight: bold;
	font-size: 16px;
	text-decoration: none;
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
}

.title {
	color: #555555;
	font-size: 32px;
	margin-bottom: 10px;
	margin-top: -60px;
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
	padding-bottom: 10px;
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
	color: #ababab;
}

.input:focus {
	background-color: #EBEDF3;
}

.forgetpwd {
	float: right;
	font-size: 16px;
}

.register {
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
	margin-top: 20px;
	margin-right: 5px;
	transition: 0.3s;
}

.register:hover {
	background-color: #87af87;
}

.go-login {
	background-color: #c8d8c2;
	outline: none;
	border: none;
	color: #FFFFFF;
	margin-left: 5px;
	text-decoration: none;
	font-weight: 700;
	font-size: 16px;
	padding-top: 15px;
	padding-bottom: 15px;
	padding-left: 40px;
	padding-right: 40px;
	border-radius: 10px;
	margin-top: 20px;
	transition: 0.3s;
}

.go-login:hover {
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

.conditions {
	transition: all 0.3s;
}

.conditions:hover {
	text-decoration: underline;
	color: #87af87;
}

.conditions-context {
	margin-top: 15px;
	margin-bottom: 5px;
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
	<div id="notice-r-lname1" class="modal-window">
		<div>
			<a href="#" title="Close" class="modal-close">关闭</a>
			<h1 class="notice-title">你有一条新提示</h1>
			<div class="notice-context">请填写注册的账号</div>

		</div>
	</div>
	<div id="notice-r-sname1" class="modal-window">
		<div>
			<a href="#" title="Close" class="modal-close">关闭</a>
			<h1 class="notice-title">你有一条新提示</h1>
			<div class="notice-context">请填写注册的用户名</div>

		</div>
	</div>
	<div id="notice-r-pwd1" class="modal-window">
		<div>
			<a href="#" title="Close" class="modal-close">关闭</a>
			<h1 class="notice-title">你有一条新提示</h1>
			<div class="notice-context">请填写注册的密码</div>

		</div>
	</div>
	<div id="notice-r-phone1" class="modal-window">
		<div>
			<a href="#" title="Close" class="modal-close">关闭</a>
			<h1 class="notice-title">你有一条新提示</h1>
			<div class="notice-context">请填写注册的手机号</div>

		</div>
	</div>
	<div id="notice-r-mail1" class="modal-window">
		<div>
			<a href="#" title="Close" class="modal-close">关闭</a>
			<h1 class="notice-title">你有一条新提示</h1>
			<div class="notice-context">请填写注册的邮箱</div>

		</div>
	</div>

	<div id="login_page">
		<form action="saveUser" method="get">
			<div class="little-div">
				<h3 class="title">Sign Up</h3>
				<p class="font-grey">Enter your details to create your account</p>
			</div>
			<div class="input-div">
				<label class="little-title">LoginName <a
					class="little-notice"> (6-10 Num or word) </a></label> <br> <input
					class="input" type="text" id="u_lname" name="u_lname"
					placeholder="登录使用名" autocomplete="off">
			</div>
			<div class="input-div">
				<label class="little-title">ShowName <a
					class="little-notice"> (6-12 length) </a></label> <br> <input
					class="input" type="text" id="u_sname" name="u_sname"
					placeholder="外显用户名" type="text" autocomplete="off">
			</div>
			<div class="input-div">
				<label class="little-title">Password <a
					class="little-notice"> (6-12 length) </a></label> <br> <input
					class="input" type="text" id="u_pwd" name="u_pwd"
					placeholder="登录的密码" type="password" autocomplete="off">
			</div>
			<div class="input-div">
				<label class="little-title">Email <a class="little-notice">
						(your email) </a></label> <br> <input class="input" id="u_mail"
					name="u_mail" placeholder="请填写邮箱" type="email" autocomplete="off">
			</div>
			<div class="input-div">
				<label class="little-title">Phone <a class="little-notice">
						(your Phone) </a></label> <br> <input class="input" type="text"
					id="u_phone" name="u_phone" placeholder="请填写手机" autocomplete="off">
			</div>
			<div class="conditions-context">
				<label class="little-title"> <input type="checkbox"">
					I Agree the <a href="#" class="little-notice-green conditions">terms
						and conditions</a>.
				</label>
			</div>
			<div>
				<button class="register" onclick="return checkRule()">Sign
					In</button>
				<a class="go-login" href="login"> Go Login </a>
			</div>
		</form>

	</div>

	</form>
</body>
</html>