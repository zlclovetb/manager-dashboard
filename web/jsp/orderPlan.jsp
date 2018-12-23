<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增生产定单</title>

<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    function save(){
    	var form = document.getElementById("orderForm");
    	form.submit();
    	setInterval("closeW()", 1000);
    }
    function closeW(){
    	window.returnValue = 1;
    	window.close();    	
    }
</script>
</head>
<body>
	<div align="center">
		<form action="<%=path%>/orderPlan/toInsert" method="post" name="orderForm" target="formFrame">
			<input type="hidden" value="${order.id}" name="id">
			<table width="800px" style="border-collapse: collapse;border: 1px solid grey;margin-top: 10px;">
				<tr>
					<td>订单名称</td>
					<td><input type="text" class="input" name="orderName" value="${blackList.orderName}"></td>
					<td>产品名称及规格</td>
					<td><input type="text" class="input" name="proName" value="${blackList.proName}"></td>
				</tr>
				<tr>
					<td>计划生产数</td>
					<td><input type="text" class="input" name="planCount" value="${blackList.planCount}"></td>
					<td>实际生产数</td>
					<td><input type="text" class="input" name="actualCount" value="${blackList.actualCount}"></td>
				</tr>
				<tr>
					<td>差异数</td>
					<td><input type="text" class="input" name="diffCount" value="${blackList.diffCount}"></td>
					<td>达成率</td>
					<td><input type="text" class="input" name="achRate" value="${blackList.achRate}"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>