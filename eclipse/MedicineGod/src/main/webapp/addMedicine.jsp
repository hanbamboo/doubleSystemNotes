<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form action="saveMedicine" method="POST">
		<h1 class="title">新增药品</h1>
		<a class="className">药品名</a> <input type="text" id="m_name"
			name="m_name" placeholder="请设置药品名" /> <br> <a class="className">描述
		</a>
		<textarea rows="3" cols="20" name="m_desp" placeholder="请输入药品描述"></textarea>
		<br> <a class="className">过期时间 </a> <input type="date"
			id="m_outdate" name="m_outdate" placeholder="请设置过期时间" /> <br> <a
			class="className">药品标识 </a> <input type="radio" id="m_otc"
			name="m_otc" value="OTC-R" />OTC非处方药(红) <input type="radio"
			id="m_otc" name="m_otc" value="OTC-G" />OTC非处方药(绿) <input
			type="radio" id="m_otc" name="m_otc" value="NONE" checked />无 <input
			type="radio" id="m_otc" name="m_otc" value="RX" />RX处方药 <br /> <a
			class="className">药品条码 </a> <input type="number" id="m_barcode"
			name="m_barcode" placeholder="请填写药品条码" /> <br> <a
			class="className">药品余量 </a> <input type="number" id="m_yu"
			name="m_yu" placeholder="请填写药品余量" /> <br> <a class="className">药品标签
		</a> <input type="text" id="m_elabel" name="m_elabel"
			placeholder="请填写药品标签，用空格分隔" /> <br> 
			
			
			
			
			<a class="className">药品用量</a> 
			<input type="number" id="m_u1" name="m_u1" placeholder="数量" /> 
			<input type="hidden" id="m_u1_1" name="m_u1_1" value="包"/>
			<input type="button" id="m_u1_btn" value="包" onclick="countAdd1()" /> 
			
			<input type="number" id="m_u2" name="m_u2" placeholder="次数" />
			<input type="hidden" id="m_u2_1" name="m_u2_1" value="次"/>
			 <input type="button" id="m_u1_btn" value="次" />
			 
			 
			 <input type="number" id="m_u3" name="m_u3" placeholder="天次" /> 
			 <input type="hidden" id="m_u3_1" name="m_u3_1" value="天"/>
			 <input type="button" id="m_u3_btn" value="天" onclick="countAdd2()"/> 
			 <input type="hidden" name="m_uid" value="${user.id }"/>
			 <br>
			 <input type="checkbox" id="m_showflag" name="m_showflag" value="show" />公开
			 <br> 
			 <a class="className">药品公司 </a> <input type="text" id="m_company"
			name="m_company" placeholder="请填写公司" /> <br> <input
			type="submit" id="m_addNew" value="新增一条" /> <br>
			<h1>${SaveMedicineErr}</h1>
	</form>
</body>
</html>