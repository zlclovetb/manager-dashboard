<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
  String path = request.getContextPath();
%>
<head>
<link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/Chart.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/Chart.bundle.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/socket.io.js"></script>
<script type="text/javascript">
	var labels = new Array();
	var planDatas = new Array();
	var actualDatas = new Array();
	var achRateDatas = new Array();
</script>
<style type="text/css">
.div1 {
	margin-bottom: 10px;
	margin-top: 10px;
    background-color: #fff;
    /* border: 1px solid #ddd; */
    /* border-radius: 4px; */
}
</style>
</head>
<body style="background-color: #404040;">
	<div class="col-sm-12 col-lg-12 main" style="color: hsla(0,0%,100%,.8);font-size: 18px;">			
		<div class="row">
			<div class="col-lg-12">
				<div class="div1">
					<table id="tTable" class="table table-bordered" style="background-color: #404040;">
						<caption style="color: hsla(0,0%,100%,.8)">今日生产计划 （${today }）</caption>
						<thead>
							<tr>
								<th>序号</th>
								<th>订单计划</th>
								<th>品名/规格</th>
								<th>计划</th>
								<th>实际</th>
								<th>差异</th>
								<th>达成率</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tDataList }" var="order" varStatus="status">
								<tr>
									<td>${status.index+1}</td>
									<td>${order.orderName }</td>
									<td>${order.proName }</td>
									<td><c:if test="${not empty order.planCount }">${order.planCount }</c:if><c:if test="${empty order.planCount }">-</c:if></td>
									<td><span id="pro_${status.index+1}"><c:if test="${not empty order.actualCount }">${order.actualCount }</c:if><c:if test="${empty order.actualCount }">-</c:if></span></td>
									<td><c:if test="${not empty order.diffCount }">${order.diffCount }</c:if><c:if test="${empty order.diffCount }">-</c:if></td>
									<td><c:if test="${not empty order.achRate }">${order.achRate }%</c:if><c:if test="${empty order.achRate }">-</c:if></td>
								</tr>
								<script type="text/javascript">
									labels.push('${order.proName }');
									planDatas.push('${order.planCount }');
									actualDatas.push('${order.actualCount }');
									achRateDatas.push('${order.achRate }');
								</script>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<div>
					<table id="sTable" class="table table-bordered">
						<caption style="color: hsla(0,0%,100%,.8)">明日生产计划（${tomorrow }）</caption>
						<thead>
							<tr>
								<th>序号</th>
								<th>订单计划</th>
								<th>品名/规格</th>
								<th>计划</th>
								<th>实际</th>
								<th>差异</th>
								<th>达成率</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${sDataList }" var="order" varStatus="status">
								<tr>
									<td>${status.index+1}</td>
									<td>${order.orderName }</td>
									<td>${order.proName }</td>
									<td><c:if test="${not empty order.planCount }">${order.planCount }</c:if><c:if test="${empty order.planCount }">-</c:if></td>
									<td><c:if test="${not empty order.actualCount }">${order.actualCount }</c:if><c:if test="${empty order.actualCount }">-</c:if></td>
									<td><c:if test="${not empty order.diffCount }">${order.diffCount }</c:if><c:if test="${empty order.diffCount }">-</c:if></td>
									<td><c:if test="${not empty order.achRate }">${order.achRate }%</c:if><c:if test="${empty order.achRate }">-</c:if></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div><!--/.row-->		
		
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-default" style="background-color: #404040;">
					<!-- <div class="panel-heading">Bar Chart</div> -->
					<div class="panel-body">
						<div class="canvas-wrapper">
							<canvas class="chart" id="bar-chart" style="background-color: #404040;"></canvas>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default" style="background-color: #404040;">
					<!-- <div class="panel-heading">Doughnut Chart</div> -->
					<div class="panel-body">
						<div class="canvas-wrapper">
							<canvas class="chart" id="line-chart" style="background-color: #404040;"></canvas>
						</div>
					</div>
				</div>
			</div>
		</div><!--/.row-->
	</div>
	<script type="text/javascript">
		console.log('jQuery(document).height()' + jQuery(document).height());
		console.log('$("#sTable").offset().top' + $("#sTable").offset().top);
		console.log('$("#sTable").height()' + $("#sTable").height());
		console.log(jQuery(document).height() - $("#sTable").offset().top
				- $("#sTable").height() - 200);
		//document.getElementById("bar-chart").height = jQuery(document).height() - $("#sTable").offset().top - $("#sTable").height() -200 + 25;
		//document.getElementById("line-chart").height = jQuery(document).height() - $("#sTable").offset().top - $("#sTable").height() -200;
		window.chartColors = {
			red : 'rgb(255, 99, 132)',
			orange : 'rgb(255, 159, 64)',
			yellow : 'rgb(255, 205, 86)',
			green : 'rgb(75, 192, 192)',
			blue : 'rgb(54, 162, 235)',
			purple : 'rgb(153, 102, 255)',
			grey : 'rgb(201, 203, 207)',
			black : 'rgb(0, 0, 0)'
		};
		Chart.defaults.global.defaultFontColor = 'hsla(0,0%,100%,.8)';
		//Chart.defaults.global.scaleLineColor = 'rgba(0,0,0,.1)';
		//Chart.defaults.global.scaleGridLineColor = 'rgba(0,0,0,.05)';
		var ctx = document.getElementById("bar-chart").getContext('2d');
		var color = Chart.helpers.color;
		var barChart = new Chart(
				ctx,
				{
					type : 'bar',
					data : {
						labels : labels,
						datasets : [ {
							label : '计划数据',
							data : planDatas,
							backgroundColor : window.chartColors.red,
							borderColor : window.chartColors.red
						}, {
							label : '达成数据',
							data : actualDatas,
							backgroundColor : window.chartColors.blue,
							borderColor : window.chartColors.blue
						} ]
					},
					options : {
						scales : {
							xAxes : [ {
								display : true,
								scaleLabel : {
									display : true,
									labelString : '产品名称'
								}
							} ],
							yAxes : [ {
								display : true,
								scaleLabel : {
									display : true,
									labelString : '数量'
								},
								ticks : {
									beginAtZero : true
								}
							} ]
						},
						title : {
							display : false,
							text : '订单生产数量'
						},
						hover : {
							animationDuration : 0
						// 防止鼠标移上去，数字闪烁
						},
						animation : { // 这部分是数值显示的功能实现
							onComplete : function() {
								var chartInstance = this.chart, ctx = chartInstance.ctx;
								ctx.font = Chart.helpers
										.fontString(
												Chart.defaults.global.defaultFontSize,
												Chart.defaults.global.defaultFontStyle,
												Chart.defaults.global.defaultFontFamily);
								ctx.fillStyle = "hsla(0,0%,100%,.8)";
								ctx.textAlign = 'center';
								ctx.textBaseline = 'bottom';

								this.data.datasets
										.forEach(function(dataset, i) {
											var meta = chartInstance.controller
													.getDatasetMeta(i);
											meta.data.forEach(function(bar,
													index) {
												var data = dataset.data[index];
												ctx.fillText(data,
														bar._model.x,
														bar._model.y + 15);
											});
										});
							}
						}
					}
				});

		var ctx = document.getElementById("line-chart").getContext('2d');
		var lineChart = new Chart(
				ctx,
				{
					type : 'line',
					data : {
						labels : labels,
						datasets : [ {
							label : '达成率',
							data : achRateDatas,
							backgroundColor : window.chartColors.orange,
							borderColor : window.chartColors.orange,
							fill : false
						} ]
					},
					options : {
						scales : {
							xAxes : [ {
								display : true,
								scaleLabel : {
									display : true,
									labelString : '产品名称'
								}
							} ],
							yAxes : [ {
								display : true,
								scaleLabel : {
									display : true,
									labelString : '百分比'
								},
								ticks : {
									beginAtZero : true,
									callback : function(label, index, labels) {
										return Math.floor((label)) + '%';
									}
								}
							} ]
						},
						tooltips : {
							mode : 'index',
							intersect : false,
						},
						hover : {
							mode : 'nearest',
							intersect : true
						},
						hover : {
							animationDuration : 0
						// 防止鼠标移上去，数字闪烁
						},
						animation : { // 这部分是数值显示的功能实现
							onComplete : function() {
								var chartInstance = this.chart, ctx = chartInstance.ctx;
								ctx.font = Chart.helpers
										.fontString(
												Chart.defaults.global.defaultFontSize,
												Chart.defaults.global.defaultFontStyle,
												Chart.defaults.global.defaultFontFamily);
								ctx.fillStyle = "hsla(0,0%,100%,.8)";
								ctx.textAlign = 'center';
								ctx.textBaseline = 'bottom';

								this.data.datasets
										.forEach(function(dataset, i) {
											var meta = chartInstance.controller
													.getDatasetMeta(i);
											meta.data.forEach(function(bar,
													index) {
												var data = dataset.data[index];
												ctx.fillText(data,
														bar._model.x,
														bar._model.y + 20);
											});
										});
							}
						}
					}
				});
		/* barChart.data.datasets[1].data[0] = 50;
		setTimeout(() => {
			barChart.update();
		}, 2000); */
		console.log("barChart.height" + barChart.height);
	</script>
	<script type="text/javascript">
		var token = "a1b2c3d4";
		var socket = io.connect('http://localhost:8089');
		socket.on('connect', function() {
			console.log("client connect");
			socket.emit('token', {
				token : token,
				message : 'register'
			});
		});

		socket.on('newAlert', function(data) {
			console.log("receive alert...token:" + data.token +"|msg:" + data.message);
			if(token == data.token){
				var count = parseInt(data.message);
				//var oldVal = parseInt($("#pro_"+data.line).text());
				$("#pro_"+data.line).text(count);
			}
		});

		socket.on('disconnect', function() {
			console.log("user disconnect");
		});

		function sendDisconnect() {
			socket.disconnect();
		}
		function sendMessage() {
			console.log("send message token");
			socket.emit('token', {
				token : $('#token').val(),
				message : 'message token'
			});
		}
	</script>
</body>
</html>