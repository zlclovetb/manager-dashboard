<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<style type="text/css">
.circle-red {
	width: 20px;
	height: 20px;
	background-color: red;
	border-radius: 50%;
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
}
.circle-green {
	width: 20px;
	height: 20px;
	background-color: green;
	border-radius: 50%;
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
}
.circle-yellow {
	width: 20px;
	height: 20px;
	background-color: yellow;
	border-radius: 50%;
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
}
td {
	text-align: center;

}
.td-blue {
	color: blue;

}
.td-orange {
	color: orange;

}
table {
    padding: 0px;
    border: 0px;
    margin: 0px;
    font-family: "Microsoft YaHei";
    font-size: 20px;
}
</style>
<script type="text/javascript">
window.onload=function(){
	showtime();
}
function showtime() {
	var show_day = new Array('星期天', '星期一', '星期二', '星期三', '星期四', '星期五',
			'星期六');
	var time = new Date();
	var year = time.getFullYear();
	var month = time.getMonth() + 1;
	var date = time.getDate();
	var day = time.getDay();
	var hour = time.getHours();
	var minutes = time.getMinutes();
	var second = time.getSeconds();
	var now_time =  year + '年' + month + '月' + date + '日' + ' '
			+ show_day[day] + '' + hour + '时' + minutes + '分';
	document.getElementById('showtime').innerHTML = now_time;
}
</script>
</head>

<body>
	<div>
		<div style="color: red; text-align: center; margin-top: 50px; font-size: 50px;">管理看板</div>
		<div id="showtime" style="margin-left: 5px; font-family:Microsoft YaHei;font-size: 20px;"></div>
		<div>
			<table style="width: 100%;">
				<tr>
					<td width="100%">
						<table border="1px" style="width: 100%;">
							<tr>
								<th>序号</th>
								<th>今日订单计划</th>
								<th>品名/规格</th>
								<th>计划</th>
								<th>实际</th>
								<th>差异</th>
								<th>达成率</th>
							</tr>
							<tr>
								<td>1</td>
								<td class="td-blue">20110210-45878</td>
								<td>E1116CZ-意大利CARPIGIANI公司</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td>100%</td>
							</tr>
							<tr>
								<td>2</td>
								<td class="td-blue">20110210-45878</td>
								<td>W25EZ-黎巴嫩HCRROUT</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td>100%</td>
							</tr>
							<tr>
								<td>3</td>
								<td class="td-blue">20110210-45878</td>
								<td>LK76CVB-A(15位数字)</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td>100%</td>
							</tr>
							<tr>
								<td>4</td>
								<td class="td-blue">20110210-45878</td>
								<td>LU60CY(改进型)</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td>100%</td>
							</tr>
							<tr>
								<td>5</td>
								<td class="td-blue">20110210-45878</td>
								<td>QD100YU(俄罗斯VESTEL)</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td>100%</td>
							</tr>
							<tr>
								<td>汇总</td>
								<td colspan="2"></td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td>100%</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td width="100%">
						<table border="1px" style="width: 100%;">
							<tr>
								<th rowspan="2">序号</th>
								<th rowspan="2">节拍（秒）</th>
								<th rowspan="2">实时应完成产量</th>
								<th rowspan="2">实时差异</th>
								<th colspan="2">开工时间</th>
								<th colspan="2">完工时间</th>
								<th colspan="3">生产状态</th>
								<th colspan="2">人员配置（人）</th>
							</tr>
							<tr>
								<th>计划</th>
								<th>实际</th>
								<th>计划</th>
								<th>实际</th>
								<th><div class="circle-red"></div></th>
								<th><div class="circle-green"></div></th>
								<th><div class="circle-yellow"></div></th>
								<th>标准</th>
								<th>实际</th>
							</tr>
							<tr>
								<td>1</td>
								<td class="td-blue">123</td>
								<td class="td-blue">123456</td>
								<td class="td-orange">76543</td>
								<td>8:30</td>
								<td>8:30</td>
								<td>12:30</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td class="td-blue">123</td>
								<td class="td-blue">123</td>
							</tr>
							<tr>
								<td>2</td>
								<td class="td-blue">123</td>
								<td class="td-blue">123456</td>
								<td class="td-orange">76543</td>
								<td>8:30</td>
								<td>8:30</td>
								<td>12:30</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td class="td-blue">123</td>
								<td class="td-blue">123</td>
							</tr>
							<tr>
								<td>3</td>
								<td class="td-blue">123</td>
								<td class="td-blue">123456</td>
								<td class="td-orange">76543</td>
								<td>8:30</td>
								<td>8:30</td>
								<td>12:30</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td class="td-blue">123</td>
								<td class="td-blue">123</td>
							</tr>
							<tr>
								<td>4</td>
								<td class="td-blue">123</td>
								<td class="td-blue">123456</td>
								<td class="td-orange">76543</td>
								<td>8:30</td>
								<td>8:30</td>
								<td>12:30</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td class="td-blue">123</td>
								<td class="td-blue">123</td>
							</tr>
							<tr>
								<td>5</td>
								<td class="td-blue">123</td>
								<td class="td-blue">123456</td>
								<td class="td-orange">76543</td>
								<td>8:30</td>
								<td>8:30</td>
								<td>12:30</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td class="td-blue">123</td>
								<td class="td-blue">123</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div style="margin-left: 5px;margin-top:20px; font-family:Microsoft YaHei;font-size: 20px;font-weight: bold;">
			备注：红色代表生产速度滞后，绿色代表正常，黄色代表超速生产
		</div>
	</div>

</body>
</html>