<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="daohang.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>奥利给博客主页</title>
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

.action {
	color: white;
	text-decoration: none;
	margin-bottom: 10px;
}

.action:hover {
	color: red;
	text-decoration: underline;
	cursor: pointer;
}

#dianzan {
	color: black;
	border: 1px #000000 solid;
	border-radius: 5px;
	cursor: pointer;
	padding: 5px;
	margin-top: 10px
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
					<c:if test="${b.uid == user.id }">
						<b><a href="editBlog?id=${b.id }" class="action">修改</a></b>
		
						<b><a href="delBlog?id=${b.id }" class="action">删除</a></b>
					</c:if>
					<br> 
					<br> 
					<b>点赞:${b.zan}</b>
					<c:if test="${b.uid != user.id }">
						<a id="dianzan">赞</a>
					</c:if>

					<b> 评论:${b.pinglun}</b>
				</p>
				<c:if test="${b.uid != user.id }">
					<p id="time">${b.uname}发布于${b.time}</p>
				</c:if>
				<c:if test="${b.uid == user.id }">
					<p id="time">我发布于${b.time}</p>
				</c:if>

			</div>
			<hr>

		</c:forEach>
	</c:if>

</body>
</html>