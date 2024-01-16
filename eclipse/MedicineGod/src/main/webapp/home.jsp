<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
		<a>持有${countMedicine.count }</a>
	</div>
	<div>
		<a>正常${countMedicine.ok }</a>
	</div>
	<div>
		<a>过期${countMedicine.out }</a>
	</div>
	<div>
		<a>临期${countMedicine.near }</a>
	</div>
	<div>
		<a>OTC非处方药(红)${countMedicine.otcr }</a>
	</div>
	<div>
		<a>OTC非处方药(绿)${countMedicine.otcg }</a>
	</div>
	<div>
		<a>无标识${countMedicine.none }</a>
	</div>
	<div>
		<a>RX处方药${countMedicine.rx }</a>
	</div>
	
	<h1>- 用户分享药品 -</h1>
	<c:if test="${empty medicinesOpen}">
		<h1>
			暂无分享内容
		</h1>
	</c:if>
	<c:if test="${not empty medicinesOpen}">
		<table>
			<tr>
				<th class="m_id_1">序号</th>
				<th class="m_name_1">名称</th>
				<th class="m_otc_1">标识</th>
				<th class="m_outdate_1">过期时间</th>
				<th class="m_company_1">公司</th>
				<th class="m_barcode_1">条码</th>
				<th class="m_share_1">分享者</th>
				<th class="m_action_1">操作</th>
			</tr>
			<c:forEach var="m" items="${medicinesOpen}" varStatus="v">
				<tr>
					<td><a id="m_id">${v.count }</a></td>
					<td><a id="m_name">${m.name }</a></td>
					<td><a id="m_otc">${m.otc_str }</a></td>
					<td><a id="m_outdate">${m.outdate_str }</a></td>
					<td><a id="m_company">${m.company }</a></td>
					<td><a id="m_barcode">${m.barcode }</a></td>
					<th class="m_share">${m.uid }</th>
					<td><a id="m_action">
							<a href="loveMedicine?keyid=${m.keyid}">收藏</a> 
						</a>
					</td>

				</tr>

			</c:forEach>
		</table>
	</c:if>
</body>
</html>