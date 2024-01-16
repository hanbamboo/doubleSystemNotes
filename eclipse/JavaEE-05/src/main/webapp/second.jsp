<%--jsp当中的指令
		指令是用来设置一些jsp相关行为
		比如编码、引入外部依赖
	语法：
		<%@ 指令名称 属性 = "值" 属性 = "值" %>
	常用的指令：
		1.page
			主要是用来设置jsp格式的
		2.include
			可以引入其他外部jsp文件，包含
		3.taglib
			主要是jstl中引入标签库用到的
 --%>
 <%--
 	language 说明jsp语言
 	contentType 设置响应内容格式，比如页面类型，编码
 	pageEncoding 设置jsp文件的编码
  --%>
  <%--
  		include指令
  			可以用来引入其他外部的jsp文件，html文件也可以
  			file属性的值是jsp文件路径名
   --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%--
	jso脚本使方式，jsp中使用java语法，
		1.<%=表达式%>
			可以将表达式的结果输出在html的功能中
		2.<%! 声明%>
		3.<% 程序代码%>
		以上三种方式了解认识即可，以后使用jsp几乎不会这样用
		jsp叫java server page java服务端页面
		它包含的东西应该只关注页面的数据显示
		不需要涉及过多的java逻辑，如果涉及了后端业务逻辑
		jdbc等，查询数据等，去servlet实现
--%>
<!-- 等价于在html中写了一个true -->
<body>

	<%=4 > 3%>
	<%!public int sum(int a, int b) {
		return a + b;
	}%>
	<%=sum(1, 2)%>
	<%
	for (int i = 1; i <= 10; i++) {
		i = i + 1;
	}
	%>
	
</body>
</html>