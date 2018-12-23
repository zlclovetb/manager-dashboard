function toNextPage(formName){
	var form = document.getElementById(formName);
	var pageIndex = document.getElementById("pageIndex");
	pageIndex.value = new Number(pageIndex.value) + 1;
	form.submit();
}

function toPrePage(formName){
	var form = document.getElementById(formName);
	var pageIndex = document.getElementById("pageIndex");
	pageIndex.value = new Number(pageIndex.value) - 1;
	form.submit();
}

function toFirstPage(formName){
	var form = document.getElementById(formName);
	document.getElementById("pageIndex").value = "1";	
	form.submit();
}

function toLastPage(formName){
	var form = document.getElementById(formName);
	document.getElementById("pageIndex").value = "last";	
	form.submit();
}