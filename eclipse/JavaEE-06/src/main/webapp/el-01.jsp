<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
	el:
		Expression Language表达式语言
		1.主要是让他来代替jsp中一些java脚本元素
			比如：
				<%! 声明 %>
				<%=表达式 %>
				<%java代码块%>
			有了el表达式之后的用法,比如在一些对象之中取值：
				原来脚本元素的写法：
					<%=request.getAttribute("name")%>
				el的写法:
					${name}
		2.结合jstl使用，让jsp看起来和html一样
			jstl:Java server pages standarded tag library，JSP标准标签库
			使用：${表达式}
			(1).运算
				算术运算：
					+ - * /(div) %(mod)
				逻辑运算
					||(or) &&(and) !(not)
				比较运算
					> < == >= <=
				空运算
					empty
					notempty
			(2).取值:
				主要是从jsp中的内置对象中取值
				内置对象：一些jsp或servlet请求当中已经创建好的对象
					这些对象可以直接拿来用，可以进行存值取值
					
					servlet域对象				jsp内置对象 			el对象
					------					pageContext			pageScope
					request					request				requestScope(最常用)
					session					session				sessionScope(最常用)
					applicationContext		application			applicationScope
				
				
				el在域对象中取值时(假设往域对象中存了一个值，比如：
					<%
						request.setAttribute("key", value);
					%>
					):
					
					(1)指定对象名key取值
						${域对象.key}
					(2)通过key取值
						取值时是有优先级的，先从最小的域对象取值，取到值不再找
							request -> session -> application
						${key}
					
			(3)
 --%>


	<%-- 输出5+3的结果在页面上 --%>
	${5+3}
	<%-- el表达式可以结合标签中使用 --%>
	${10 div 3 } ${10 mod 3} ${5 > 3}
	<h2>${5>3 and 4<2}</h2>
	${4<=2 }
	<%--
		在jsp内置对象request中存一个值，通过el表达式在对应域对象区中
	 --%>
	<%--
	 	通过脚本元素，使用jsp内置对象存值
	 --%>
	<%
	request.setAttribute("name", "张三");
	session.setAttribute("name", "李四");
	application.setAttribute("name", "王五");
	%>
	<%--通过el表达式获取request对象的值 --%>
	<%--以下这种方式，先从request找key值，找到就返回，找不到继续找session，找application
	 --%>
	${requestScope.name} 
	${sessionScope.name} 
	${applicationScope.name} 
	
	
	${name}
	<%
		int[] arr = {4,3,2,1};
		request.setAttribute("arr1", arr);
	%>
	
	${ arr1[1] }
</html>