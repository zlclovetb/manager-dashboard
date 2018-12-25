<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
  String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生产管理</title>

<link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path %>/css/bootstrap-datetimepicker.css" rel="stylesheet">
<link href="<%=path %>/css/bootstrap-table.css" rel="stylesheet">
<link href="<%=path %>/css/toastr.min.css" rel="stylesheet">
<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/moment-with-locales.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="<%=path %>/js/bootstrap-table.js"></script>
<script type="text/javascript" src="<%=path %>/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/toastr.min.js"></script>
</head>
<body>
	<div>
		<div id="showtime" style="margin-left: 5px; font-family: Microsoft YaHei; font-size: 20px;"></div>
		<div style="text-align: center; margin-top: 20px; font-size: 40px;">生产管理</div>
		<div id="searchBar" class="col-sm-12 col-lg-12">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">生产计划查询 </a>
							</h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse">
							<div class="panel-body">
								<form role="form" id="searchForm" action="<%=path%>/orderPlan/toList" method="post">
									<table class="table">
										<tbody>
											<tr>
												<td><label for="name">订单名称</label></td>
												<td><input type="text" class="form-control" id="s_orderName" value="${orderName }" placeholder="请输入订单名称"></td>
												<td><label for="name">产品名称及规格</label></td>
												<td><input type="text" class="form-control" id="s_proName" value="${proName }" placeholder="请输入产品名称及规格"></td>
											</tr>
											<tr>
												<td><label for="name">生产日期</label></td>
												<td><input type="text" class="input-sm form-control datepicker" id="s_proDate" value="${proDate }" placeholder="请选择生产日期"></td>
												<!-- <td colspan="2"><button type="submit" class="btn btn-default">提交</button></td> -->
											</tr>
										</tbody>
									</table>
									<button type="button" id="searchBtm" class="btn btn-default">搜索</button>
									<button type="button" id="clearBtn" class="btn btn-default">清空</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-sm-12 col-lg-12 main">
			<div class="row">
				<div class="col-lg-12">
					<div>
						<table id="mytab" class="table table-hover">
							<%-- <caption>生产计划</caption> --%>
							<%-- <thead>
								<tr>
									<th>序号</th>
									<th>订单计划</th>
									<th>品名/规格</th>
									<th>生产日期</th>
									<th>计划</th>
									<th>实际</th>
									<th>差异</th>
									<th>达成率</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${dataList }" var="order" varStatus="status">
									<tr>
										<td>${status.index+1}</td>
										<td>${order.orderName }</td>
										<td>${order.proName }</td>
										<td><fmt:formatDate value="${order.proDate }" type="both" pattern="yyyy-MM-dd" /></td>
										<td>${order.planCount }</td>
										<td>${order.actualCount }</td>
										<td>${order.diffCount }</td>
										<td>${order.achRate }%</td>
									</tr>
								</c:forEach>
							</tbody> --%>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-12 col-lg-12 main" style="margin-top: 20px;">
			<div class="row">
				<div class="col-lg-12">
					<div>
						<button type="button" id="saveBtn" class="btn btn-default">新增生产计划</button>
						<button type="button" id="editBtn" class="btn btn-default">修改生产计划</button>
						<button type="button" id="delBtn" class="btn btn-default">删除生产计划</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">生产计划</h4>
				</div>
				<div class="modal-body">
					<form role="form" id="orderForm" action="<%=path %>/orderPlan/insert" method="post">
						<input type="hidden" id="id" name="id">
						<div class="form-group">
							<label for="name">订单名称</label> <input type="text" class="form-control" id="orderName" name="orderName" placeholder="请输入订单名称">
						</div>
						<div class="form-group">
							<label for="name">产品名称及规格</label> <input type="text" class="form-control" id="proName" name="proName" placeholder="请输入产品名称及规格">
						</div>
						<div class="form-group">
							<label for="name">生产日期</label> <input type="text" class="input-sm form-control datepicker" id="proDate" name="proDate" placeholder="请选择生产日期">
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div>
									<label for="name">计划生产数</label> <input type="number" id="planCount" name="planCount" class="form-control" placeholder="计划生产数">
								</div>
							</div>
							<div class="col-lg-6">
								<div>
									<label for="name">实际生产数</label> <input type="number" id="actualCount" name="actualCount" class="form-control" placeholder="实际生产数">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div>
									<label for="name">差异数</label> <input type="number" id="diffCount" name="diffCount" class="form-control" placeholder="计划生产数">
								</div>
							</div>
							<div class="col-lg-6">
								<div>
									<label for="name">达成率</label> <input type="text" name="achRate" id="achRate" class="form-control" placeholder="实际生产数">
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="opButton">提交</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<script type="text/javascript">
		$("#s_proDate").datetimepicker({
			format : "YYYY-MM-DD"
		});
		$("#proDate").datetimepicker({
			format : "YYYY-MM-DD"
		});
		$('#saveBtn').on('click', function(){
			$("#myModal").modal('show');
			$("#orderForm input").each(function(){
				$(this).val('');
			});
			$('#opButton').off('click');
			$('#opButton').on('click', function(){
				var param = $("#orderForm").serializeArray();
				$.ajax({
					url:"insert",
					method:"post",
					data:param,
					dataType:"json",
					success:function(data){
						if(data.state=="success"){
							toastr.success('新增成功');
							$("#myModal").modal('hide');
							$("#mytab").bootstrapTable('refresh');
						}
					},
					error:function(){
						toastr.error('新增失败');
					}
				});
			})
		})
		$('#searchBtm').on('click', function(){
			$("#mytab").bootstrapTable("refresh");
			if($('#s_orderName').val() !=null || $('#s_proName').val() !=null || $('#s_proDate').val() !=null ) {
				$('#collapseThree').collapse('show');
			}
		})
		$('#clearBtn').on('click', function(){
			$("#s_orderName").val('');
			$("#s_proName").val('');
			$("#s_proDate").val('');
			//$('#searchForm').submit();
			$('#collapseThree').collapse('hide');
			$("#mytab").bootstrapTable("refresh");
		})
		$('#delBtn').on('click', function(){
			var rows = $("#mytab").bootstrapTable("getSelections");
			if(rows.length == 0){
			    toastr.info("请至少选择一行数据");
			}else{
				var ids = [];
				var len = rows.length;
				
				for(var i=0;i<len;i++){
					ids.push(rows[i].id);
				}
				$.ajax({
					url:"delete",
					dataType:"json",
					traditional: true,
					method:"post",
					data:{
						"ids":ids
					},
					success:function(data){
						toastr.success('删除成功');
						$("#mytab").bootstrapTable("refresh");
					},
					error:function(){
						toastr.error('删除失败');
					}
				});
			}
		})
		$('#editBtn').on('click', function(){
			var rows = $("#mytab").bootstrapTable('getSelections');
			if (rows.length != 1) {
				toastr.info("请选择一行数据");
			} else {
				var row = rows[0];
				$('#id').val(row.id);
				$('#orderName').val(row.orderName);
				$('#proName').val(row.proName);
				$('#proDate').val(changeDateFormat(row.proDate));
				$('#planCount').val(row.planCount);
				$('#actualCount').val(row.actualCount);
				$('#diffCount').val(row.diffCount);
				$('#achRate').val(row.achRate);
				$("#myModal").modal('show');
				
				$('#opButton').off('click');
				$('#opButton').on('click', function(){
					var param = $("#orderForm").serializeArray();
					$.ajax({
						url:"update",
						method:"post",
						data:param,
						dataType:"json",
						success:function(data){
							if(data.state=="success"){
								toastr.success('修改成功');
								$("#myModal").modal('hide');
								$("#mytab").bootstrapTable('refresh');
							}
						},
						error:function(){
							toastr.error('修改失败');
						}
					});
				})
			}
		})

		$('#mytab').bootstrapTable({
			method : 'get',
			url : "getPageInfo",
			dataType : "json",
			dataField : "data",
			striped : true,
			pageNumber : 1,
			pagination : true,
			sidePagination : 'server',
			pageSize : 5,
			pageList : [ 5, 10, 20 ],
			showRefresh : false,
			queryParams : function(params) {
				var temp = {
					limit : params.limit,
					offset : params.offset,
					orderName : $('#s_orderName').val(),
					proName : $('#s_proName').val(),
					proDate : $('#s_proDate').val(),
				};
				return temp;
			},
			columns : [ {
				checkbox : true
			}, {
				title : '序号',
				field : '',
				formatter : function(value, row, index) {
					return index + 1;
				}
			}, {
				title : '订单计划',
				field : 'orderName',
				sortable : false
			}, {
				title : '品名/规格',
				field : 'proName',
			}, {
				title : '生产日期',
				field : 'proDate',
				formatter : function(value, row, index) {
					return changeDateFormat(value)
				}
			}, {
				title : '计划数目',
				field : 'planCount',
			}, {
				title : '实际数目',
				field : 'actualCount',
			}, {
				title : '差异',
				field : 'diffCount',
			}, {
				title : '达成率',
				field : 'achRate',
				formatter : function(value, row, index) {
					if(value){
						return value + '%';
					}else{
						return '-';
					}
				}
			} ]
		})

		function changeDateFormat(cellval) {
			var dateVal = cellval + "";
			if (cellval != null) {
				var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
				var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
				var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
				//var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
				//var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
				//var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
				return date.getFullYear() + "-" + month + "-" + currentDate; //+ " " + hours + ":" + minutes + ":" + seconds;
			}
		}
		toastr.options = {
		  "closeButton": true,
		  "debug": false,
		  "positionClass": "toast-top-right",
		  "onclick": null,
		  "showDuration": "300",
		  "hideDuration": "1000",
		  "timeOut": "3000",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
		}
	</script>
</body>
</html>