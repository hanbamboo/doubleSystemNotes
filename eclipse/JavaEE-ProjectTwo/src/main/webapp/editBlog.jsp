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

.className {
	color: #FFFFFF;
	font-size: 30px;
	margin: 10px;
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

#b_context {
	width: 70%;
	border-radius: 10px;
	background-color: rgba(255, 255, 255, 0.7);
	padding: 10px;
	outline: none;
	font-family: "微软雅黑";
	border: none;
	font-weight: 500;
	font-size: 30px;
	color: #1d6eee;
	margin-top: 10px;
	margin-bottom: 10px;
}

#b_editBlog {
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

#b_editBlog:hover {
	background-color: rgba(85, 85, 255, 0.7);
	color: #FFFFFF;
	cursor: pointer;
}
</style>
<meta charset="UTF-8">
<title>修改页面</title>
</head>
<body>
	<form action="changeBlog" method="get">
		<h1 id="title">修改博客</h1>
		<input type="hidden" name="id" value="${oneBlog.id}" /> <a
			class="className">标题</a> <input type="text" id="b_title"
			name="b_title" value="${oneBlog.title }" /> <br> <a
			class="className">内容</a>
		<textarea cols="10" rows="5" id="b_context" name="b_context">${oneBlog.context }</textarea>
		<br> <br> <input type="submit" id="b_editBlog" value="修改" />
	</form>

</body>
</html>