<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="./js/jquery-3.6.0.js" type="text/javascript"
	charset="utf-8"></script>
<script src="./js/jquerysession.js" type="text/javascript"
	charset="utf-8"></script>

<style type="text/css">
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
	<div id="open-modal" class="modal-window">
		<div>
			<a href="#" title="Close" class="modal-close">关闭</a>

			<h1 class="notice-title">你有一条新提示</h1>

			<div class="notice-context" id="dic"></div>

		</div>
	</div>
</body>
</html>