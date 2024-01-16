<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty medicinesBeDel}">
		<h1>无内容</h1>
	</c:if>
	<c:if test="${not empty medicinesBeDel}">
		<table>
			<tr>
				<th class="m_id_1">序号</th>
				<th class="m_name_1">名称</th>
				<th class="m_otc_1">标识</th>
				<th class="m_outdate_1">过期时间</th>
				<th class="m_company_1">公司</th>
				<th class="m_barcode_1">条码</th>
				<th class="m_love_1">收藏</th>
				<th class="m_show_1">公开</th>
				<th class="m_action_1">操作</th>
			</tr>
			<c:forEach var="m" items="${medicinesBeDel}" varStatus="v">
				<tr>
					<td><a id="m_id">${v.count }</a></td>
					<td><a id="m_name">${m.name }</a></td>
					<td><a id="m_otc">${m.otc }</a></td>
					<td><a id="m_outdate">${m.outdate }</a></td>
					<td><a id="m_company">${m.company }</a></td>
					<td><a id="m_barcode">${m.barcode }</a></td>
					<td><a id="m_love">${m.love }</a></td>
					<td><a id="m_show">${m.showflag }</a></td>
					<td><a id="m_action"> <a href="cbackMedicine?keyid=${m.keyid}">还原</a>
					</a></td>
				</tr>

			</c:forEach>
		</table>

	</c:if>
</body>
</html>