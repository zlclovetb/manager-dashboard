<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/Chart.min.js"></script>
<script type="text/javascript" src="./js/Chart.bundle.min.js"></script>
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
	<div class="col-sm-12 col-lg-12 main" style="color: hsla(0,0%,100%,.8);font-size: 20px;">			
		<div class="row">
			<div class="col-lg-12">
				<div class="div1">
					<table class="table table-bordered" style="background-color: #404040;">
						<caption style="color: hsla(0,0%,100%,.8)">今日生产计划</caption>
						<thead>
							<tr>
								<th>序号</th>
								<th>今日订单计划</th>
								<th>品名/规格</th>
								<th>计划</th>
								<th>实际</th>
								<th>差异</th>
								<th>达成率</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td class="td-blue">20110210-45878</td>
								<td>LU60CY(改进型)</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td>100%</td>
							</tr>
							<tr>
								<td>2</td>
								<td class="td-blue">20110210-45878</td>
								<td>QD100YU(俄罗斯VESTEL)</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td>100%</td>
							</tr>
							<tr>
								<td>3</td>
								<td class="td-blue">20110210-45878</td>
								<td>E1116CZ-意大利CARPIGIANI公司</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td class="td-blue">88888</td>
								<td>100%</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<div>
					<table class="table table-bordered">
						<caption style="color: hsla(0,0%,100%,.8)">明日生产计划</caption>
						<thead>
							<tr>
								<th>序号</th>
								<th>今日订单计划</th>
								<th>品名/规格</th>
								<th>计划</th>
								<th>实际</th>
								<th>差异</th>
								<th>达成率</th>
							</tr>
						</thead>
						<tbody>
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
							<canvas class="chart" id="bar-chart" style="background-color: #404040;" height="130px"></canvas>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default" style="background-color: #404040;">
					<!-- <div class="panel-heading">Doughnut Chart</div> -->
					<div class="panel-body">
						<div class="canvas-wrapper">
							<canvas class="chart" id="line-chart" style="background-color: #404040;" height="130px"></canvas>
						</div>
					</div>
				</div>
			</div>
		</div><!--/.row-->
	</div>
	<script type="text/javascript">
	window.chartColors = {
		red: 'rgb(255, 99, 132)',
		orange: 'rgb(255, 159, 64)',
		yellow: 'rgb(255, 205, 86)',
		green: 'rgb(75, 192, 192)',
		blue: 'rgb(54, 162, 235)',
		purple: 'rgb(153, 102, 255)',
		grey: 'rgb(201, 203, 207)',
		black: 'rgb(0, 0, 0)'
	};
	Chart.defaults.global.defaultFontColor = 'hsla(0,0%,100%,.8)';
	//Chart.defaults.global.scaleLineColor = 'rgba(0,0,0,.1)';
	//Chart.defaults.global.scaleGridLineColor = 'rgba(0,0,0,.05)';
	var ctx = document.getElementById("bar-chart").getContext('2d');
	var color = Chart.helpers.color;
	var myChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ["LU60CY(改进型)", "QD100YU(俄罗斯VESTEL)", "E1116CZ-意大利CARPIGIANI公司"],
	        datasets: [{
	            label: '计划数据',
	            data: [800, 1900, 300],
	            backgroundColor: window.chartColors.red,
				borderColor: window.chartColors.red
	        },
	        {
	            label: '达成数据',
	            data: [810, 1800, 300],
	            backgroundColor: window.chartColors.blue,
				borderColor: window.chartColors.blue
	        }
	        ]
	    },
	    options: {
	        scales: {
			    xAxes: [{
					display: true,
					scaleLabel: {
						display: true,
						labelString: '产品名称'
					}
				}],
				yAxes: [{
					display: true,
					scaleLabel: {
						display: true,
						labelString: '数量'
					},
					ticks: {
						beginAtZero: true
					}
				}]
	        },
	        title: {
				display: false,
				text: '订单生产数量'
			},
			hover: {
                animationDuration: 0  // 防止鼠标移上去，数字闪烁
            },
            animation: {           // 这部分是数值显示的功能实现
                onComplete: function () {
                    var chartInstance = this.chart,
                    ctx = chartInstance.ctx;
                    ctx.font = Chart.helpers.fontString(Chart.defaults.global.defaultFontSize, Chart.defaults.global.defaultFontStyle, Chart.defaults.global.defaultFontFamily);
                    ctx.fillStyle = "hsla(0,0%,100%,.8)";
                    ctx.textAlign = 'center';
                    ctx.textBaseline = 'bottom';
 
                    this.data.datasets.forEach(function (dataset, i) {
                        var meta = chartInstance.controller.getDatasetMeta(i);
                        meta.data.forEach(function (bar, index) {
                            var data = dataset.data[index];
                            ctx.fillText(data, bar._model.x, bar._model.y - 5);
                        });
                    });
                }
            }
	    }
	});
	
	var ctx = document.getElementById("line-chart").getContext('2d');
	var myChart = new Chart(ctx, {
	    type: 'line',
	    data: {
	    	labels: ["LU60CY(改进型)", "QD100YU(俄罗斯VESTEL)", "E1116CZ-意大利CARPIGIANI公司"],
	        datasets: [{
	            label: '达成率',
	            data: [90, 50, 110],
	            backgroundColor: window.chartColors.orange,
				borderColor: window.chartColors.orange,
				fill: false
	        }]
	    },
	    options: {
	    	scales: {
				xAxes: [{
					display: true,
					scaleLabel: {
						display: true,
						labelString: '产品名称'
					}
				}],
				yAxes: [{
					display: true,
					scaleLabel: {
						display: true,
						labelString: '百分比'
					},
					ticks: {
						beginAtZero: true,
						callback: function(label, index, labels){
							return Math.floor((label)) + '%';
						}
					}
				}]
			},
			tooltips: {
				mode: 'index',
				intersect: false,
			},
			hover: {
				mode: 'nearest',
				intersect: true
			},
			hover: {
                animationDuration: 0  // 防止鼠标移上去，数字闪烁
            },
			animation: {           // 这部分是数值显示的功能实现
                onComplete: function () {
                    var chartInstance = this.chart,
                    ctx = chartInstance.ctx;
                    ctx.font = Chart.helpers.fontString(Chart.defaults.global.defaultFontSize, Chart.defaults.global.defaultFontStyle, Chart.defaults.global.defaultFontFamily);
                    ctx.fillStyle = "hsla(0,0%,100%,.8)";
                    ctx.textAlign = 'center';
                    ctx.textBaseline = 'bottom';
 
                    this.data.datasets.forEach(function (dataset, i) {
                        var meta = chartInstance.controller.getDatasetMeta(i);
                        meta.data.forEach(function (bar, index) {
                            var data = dataset.data[index];
                            ctx.fillText(data, bar._model.x, bar._model.y - 5);
                        });
                    });
                }
            }
	    }
	});
	</script>
	</script>
</body>
</html>