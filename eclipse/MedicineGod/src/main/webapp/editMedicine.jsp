<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	function countAdd1() {
		var u1_1 = document.getElementById("m_u1_btn");
		var u1_1_text = document.getElementById("m_u1_1");
		if(u1_1.value == "包"){
			u1_1.value = "克";
			u1_1_text.value="克"
		}else if (u1_1.value == "克") {
			u1_1.value = "片";
			u1_1_text.value="片"
		}else if (u1_1.value == "片") {
			u1_1.value = "包";
			u1_1_text.value="包"
		}
		}
	function countAdd2() {
		var u2_1 = document.getElementById("m_u3_btn");
		var u2_1_text = document.getElementById("m_u3_1");
		if(u2_1.value == "天"){
			u2_1.value = "时";
			u2_1_text.value="时"
		}else if(u2_1.value == "时"){
			u2_1.value = "天";
			u2_1_text.value="天"
		}
	}
</script>
</head>
<body>
	<form action="changeMedicine" method="post">
		<h1 class="title">修改药品</h1>
			<a class="className">药品名</a> 
		<input type="text" id="m_name" name="m_name" placeholder="请输入药品名" value="${SingleMedicine.name}" /> 
				<br> 
			<a class="className">描述</a>
		<textarea rows="3" cols="20" name="m_desp" placeholder="请输入药品描述">${SingleMedicine.desp}</textarea>
				<br> 
			<a class="className">过期时间 </a>
		<input type="date" id="m_outdate" name="m_outdate" placeholder="请输入过期时间" value="${SingleMedicine.outdate}"/> 
				<br> 
			<a class="className">药品标识 </a> 
			<c:if test="${fn:contains(SingleMedicine.otc,'OTC-R')}">
				<input type="radio" id="m_otc" name="m_otc" value="OTC-R"  checked/>OTC非处方药(红) 
				<input type="radio" id="m_otc" name="m_otc" value="OTC-G" />OTC非处方药(绿) 
				<input type="radio" id="m_otc" name="m_otc" value="NONE" />无 
				<input type="radio" id="m_otc" name="m_otc" value="RX" />RX处方药 
			</c:if>
			<c:if test="${fn:contains(SingleMedicine.otc,'OTC-G')}">
				<input type="radio" id="m_otc" name="m_otc" value="OTC-R" />OTC非处方药(红) 
				<input type="radio" id="m_otc" name="m_otc" value="OTC-G" checked/>OTC非处方药(绿) 
				<input type="radio" id="m_otc" name="m_otc" value="NONE" />无 
				<input type="radio" id="m_otc" name="m_otc" value="RX" />RX处方药 
			</c:if>
			<c:if test="${fn:contains(SingleMedicine.otc,'NONE')}">
				<input type="radio" id="m_otc" name="m_otc" value="OTC-R" />OTC非处方药(红) 
				<input type="radio" id="m_otc" name="m_otc" value="OTC-G" />OTC非处方药(绿) 
				<input type="radio" id="m_otc" name="m_otc" value="NONE" checked/>无 
				<input type="radio" id="m_otc" name="m_otc" value="RX" />RX处方药 
			</c:if>
			<c:if test="${fn:contains(SingleMedicine.otc,'RX')}">
				<input type="radio" id="m_otc" name="m_otc" value="OTC-R" />OTC非处方药(红) 
				<input type="radio" id="m_otc" name="m_otc" value="OTC-G" />OTC非处方药(绿) 
				<input type="radio" id="m_otc" name="m_otc" value="NONE" />无 
				<input type="radio" id="m_otc" name="m_otc" value="RX" checked/>RX处方药 
			</c:if>
				<br/> 
			<a class="className">药品条码 </a> 
		<input type="number" id="m_barcode" name="m_barcode" placeholder="请输入药品条码" value="${SingleMedicine.barcode}"/> 
				<br> 
			<a class="className">药品余量 </a> 
		<input type="number" id="m_yu" name="m_yu" placeholder="请输入药品余量" value="${SingleMedicine.yu}"/> 
				<br> 
			<a class="className">药品标签</a> 
		<input type="text" id="m_elabel" name="m_elabel" placeholder="请输入药品标签，用空格分隔" value="${SingleMedicine.elabel}"/> 
				<br> 
			<a class="className">药品用量</a> 
			<c:set value="${fn:split(SingleMedicine.muse, '-') }" var="muse" /> 
		<input type="number" id="m_u1" name="m_u1" placeholder="数量" value="${muse[0]}" /> 
		<input type="hidden" id="m_u1_1" name="m_u1_1" value="${muse[1]}"/>
		<input type="button" id="m_u1_btn" value="${muse[1]}" onclick="countAdd1()" /> 
		<input type="number" id="m_u2" name="m_u2" placeholder="次数" value="${muse[2]}"/>
		<input type="hidden" id="m_u2_1" name="m_u2_1" value="${muse[3]}"/>
		<input type="button" id="m_u1_btn" value="次" value="${muse[3]}"/>
		<input type="number" id="m_u3" name="m_u3" placeholder="天次" value="${muse[4]}"/> 
		<input type="hidden" id="m_u3_1" name="m_u3_1" value="${muse[5]}"/>
		<input type="button" id="m_u3_btn" value="${muse[5]}" onclick="countAdd2()"/> 
		<input type="hidden" name="m_uid" value="${SingleMedicine.uid }"/>
		<input type="hidden" name="m_keyid" value="${SingleMedicine.keyid }"/>
				<br> 
			 <a class="className">药品公司 </a> 
		<input type="text" id="m_company" name="m_company" placeholder="请输入公司" value="${SingleMedicine.company }"/> 
				<br> 
		<c:if test="${SingleMedicine.showflag==1}">
				<input type="checkbox" id="m_showflag" name="m_showflag" value="show" checked/>公开
		</c:if>
		<c:if test="${SingleMedicine.showflag==0}">
				<input type="checkbox" id="m_showflag" name="m_showflag" value="show"/>公开
		</c:if>
				<br>
				
		<input type="submit" id="u_editM" value="修改" /> 
				<br>
		<h1>${EditMedicineErr}</h1>
		
	</form>
</body>
</html>