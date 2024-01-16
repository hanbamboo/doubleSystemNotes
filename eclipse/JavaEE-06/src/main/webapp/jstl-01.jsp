<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- taglib 是标签库指令
		prefix前缀，jstl标签前缀的意思
		uri的值是标签库的地址
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		jstl 
			java server pages tag library jsp标签库
		为什么要有jstl
			有了jstl之后，可以结合el表达式，让jsp更像html一样
			或者可以认为，让java开发程序员可以像写html一样来实现页面的布局
		怎么用:
			(1)在webapp下的web-inf目录下的lib中添加jstl相关的jar包
				add to library
			(2)使用在jsp当中使用taglib指令来引用jstl标签库
				类似于java当中的import
			(3)使用jstl标签+el表达式来实现页面布局
			
		jstl语法:
			<c:标签名 属性 = 值...></c:标签名>
			<c:标签名 属性 = 值.../>
			属性的值可以用el表达式,内容也可以是el表达式或是标签
			
		(1)c:if选择结构
			如果test内容为true，显示内容
			<c:if test=""></c:if> 是一个布尔表达式(可以是el)
		(2)c:choose选择器，类似于switch
			c:when是当条件符合的意思
			c:otherwise是否则的意思
			<c:choose>
				<c:when test="布尔或el表达式">内容</c:when> 
				<c:when test="布尔或el表达式">内容</c:when>
				......
				<c:otherwise>内容</c:otherwise>
			</c:choose>
			
			choose当中如果有多个when，找到符合条件的标签
			就将内容输出，不再执行下面其他的when语句了
		(3)c:foreach 是循环、遍历标签
			两种使用方式:
			foreach属性：
						begin:开始值
						end:结束值
						var:变量名:类似于java当中for循环定义的int i
						setp:增量
						item:要遍历的对象(数组和集合)
						varStatus:变量属性
							index:下标
							cont:当前循环次数
				1.普通遍历
					<c:forEach begin="1" end="10" var="x" step="2">
						${x }
					</c:forEach>
				2.遍历数组、集合
						
					<c:forEach items=${arr } var="h">{#h}
						${h }
					</c:forEach>
					
	--%>

	<%--
		给定一个整数，如果这个数大于90，显示优秀
	 --%>
	<%
	if (5 > 7) {

	}
	if (3 < 6) {

	}
	%>
	<c:if test="${5>7}">111</c:if>
	<c:if test="${3<6}">222</c:if>
	<c:choose>
		<c:when test="true">555</c:when>
		<c:when test="false">666</c:when>
	</c:choose>
	<c:choose>
		<c:when test="true">555</c:when>
		<c:when test="false">666</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	<br>
	<c:forEach begin="1" end="10" var="x" step="2">
		${x }
		<br>

	</c:forEach>


	<%
	int[] arr = { 1, 2, 3, 4 };
	request.setAttribute("arr1", arr);
	%>
	<%-- 通过jstl+el表达式将数组中表达式放到html中 --%>

	<c:forEach items=${arr } var="h">{#h}
	${h }
	</c:forEach>
</body>
</html>