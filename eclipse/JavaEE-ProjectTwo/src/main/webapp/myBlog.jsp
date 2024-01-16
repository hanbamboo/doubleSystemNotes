<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="daohang.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人博客</title>
<style type="text/css">
#title {
	background-color: orange;
	width: 100%;
	padding-left: 10px;
	padding-top: 5px;
	padding-bottom: 5px;
	border-radius: 5px;
}

#blog {
	margin: 15px;
	background-color: #FFC75F;
	padding: 10px;
	border-radius: 5px;
}

#context {
	color: black;
	text-indent: 34px
}

#dp, #time {
	color: white;
	text-align: right;
}

button {
	background-color: rgba(255, 255, 255, 0.7);
	outline: none;
	border: none;
	cursor: pointer;
	border-radius: 5px;
}

.action {
	color: black;
	text-decoration: none;
}

.action:hover {
	color: red;
	text-decoration: underline;
	cursor: pointer;
}
</style>
</head>
<body>
	<c:if test="${empty blog}">
		<h1>
			无博客，请先<a href="writeBlog">写博客</a>
		</h1>
	</c:if>
	<c:if test="${not empty blog}">
		<c:forEach var="b" items="${blog}">
			<div id="blog">
				<h1 id="title">${b.title}</h1>
				<p id="context">${b.context}</p>
				<br> <br>
				<p id="dp">
					<a href="editBlog?id=${b.id }" class="action">修改</a> <a href="delBlog?id=${b.id }" class="action">删除</a>
				<p id="time">我发布于${b.time}</p>

			</div>
			<hr>
		</c:forEach>

	</c:if>
</body>
</html>