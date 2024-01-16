<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="Header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function doDelete(keyid) {
		var flag = confirm("确认删除此条药品？");
		if (flag) {
			window.location.href = "${pageContext.request.contextPath}/delMedicine?keyid="
					+ keyid;
		}
	}
</script>
</head>
<body>

	<c:if test="${empty medicines}">
		<h1>
			无内容，请先<a href="addMedicine">添加药品</a>
		</h1>
	</c:if>
	<c:if test="${not empty medicines}">
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
			<c:forEach var="m" items="${medicines}" varStatus="v">
				<tr>
					<td><a id="m_id">${v.count }</a></td>
					<td><a id="m_name">${m.name }</a></td>
					<td><a id="m_otc">${m.otc_str }</a></td>
					<td><a id="m_outdate">${m.outdate_str }</a></td>
					<td><a id="m_company">${m.company }</a></td>
					<td><a id="m_barcode">${m.barcode }</a></td>
					<td><a id="m_love">${m.love }</a></td>
					<td><a id="m_show">${m.showflag }</a></td>
					<td><a id="m_action">
							<a href="editMedicine?keyid=${m.keyid}">编辑</a> 
							<a href="#" onclick="doDelete('${m.keyid}');return false;">删除</a>
						</a>
					</td>

				</tr>

			</c:forEach>
		</table>
	</c:if>
</body>
</html>

