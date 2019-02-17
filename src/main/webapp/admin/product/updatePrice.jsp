<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/fragments/includes.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="images/favicon.ico">

<title>新西兰呆狗 -- 新西兰特色商品购物网站</title>

<!-- Bootstrap core CSS -->
<link href="${bootstrap}/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${bootstrap}/dist/css/navbar.css?v=${cssv}" rel="stylesheet">
<link href="${bootstrap}/dist/css/navbar-top-fixed.css?v=${cssv}" rel="stylesheet">
<link href="${bootstrap}/dist/css/grid.css?v=${cssv}" rel="stylesheet">
<style type="text/css">
.center {
	display: block;
    margin-left: auto;
    margin-right: auto;
}
</style>
</head>

<body>
	<jsp:include page="/admin/fragments/nav.jsp"></jsp:include>
	<main role="main" class="container">
		<div>
			<a href="#">首页</a>
			&gt;&gt;
			<a href="#">商品管理</a>
			&gt;&gt;
			<a href="#">更新价格</a>
		</div>
		<h3>${prod.prod_title }</h3>
		<div>
			<form action="${ctx}/admin/product/price/update" method="post">
				<input type="hidden" name="prodId" value="${prod.prod_id}"/>
				<div class="form-group">
					<label for="selectGuige">选择规格</label>
					<select id="selectGuige" name="selectGuige" class="form-control">
						<option value="0">新规格</option>
						<c:forEach items="${guigeList}" var="guige">
						<option value="${guige.guge_id}">${guige.guge_display}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label for="guigeDisplay">规格显示</label>
					<input type="text" class="form-control" id="guigeDisplay" name="guigeDisplay" placeholder="规格显示">
				</div>
				<div class="form-group">
					<label for="guigeAmount">规格数量</label>
					<input type="number" step="0.01" class="form-control" id="guigeAmount" name="guigeAmount" placeholder="规格数量">
				</div>
				<div class="form-group">
					<label for="guigeUnit">规格单位</label>
					<input type="text" class="form-control" id="guigeUnit" name="guigeUnit" placeholder="规格单位">
				</div>
				<hr/>
				<div class="form-group">
					<label for="priceCount">价格数量</label>
					<input type="number" step="1" class="form-control" id="priceCount" name="priceCount" placeholder="价格数量">
				</div>
				<div class="form-group">
					<label for="grossWeight">打包重量</label>
					<input type="number" step="0.01" class="form-control" id="grossWeight" name="grossWeight" placeholder="打包重量">
				</div>
				<div class="form-group">
					<label for="priceAmount">价格</label>
					<input type="number" step="0.01" class="form-control" id="priceAmount" name="priceAmount" placeholder="价格">
				</div>
				<div class="form-group">
					<label for="costCny">人民币成本</label>
					<input type="number" step="0.01" class="form-control" id="costCny" name="costCny" placeholder="人民币成本">
				</div>
				<div class="form-group">
					<label for="costNzd">纽币成本</label>
					<input type="number" step="0.01" class="form-control" id="costNzd" name="costNzd" placeholder="纽币成本">
				</div>
				<button type="submit" class="btn btn-primary">修改</button>
			</form>
			<table border="1">
				<tr>
					<th>规格</th>
					<th>件数</th>
					<th>生效日期</th>
					<th>打包重量</th>
					<th>价格</th>
					<th>人民币成本</th>
					<th>纽币成本</th>
				</tr>
				<c:forEach items="${prod.prceList}" var="prce">
				<tr>
					<td>${prce.guge.guge_display}</td>
					<td>${prce.prce_count}</td>
					<td>${prce.prce_effective_date}</td>
					<td>${prce.prce_gross_weight}</td>
					<td>${prce.prce_amount}</td>
					<td>${prce.prce_cost_cny}</td>
					<td>${prce.prce_cost_nzd}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</main>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script>window.jQuery || document.write('<script src="${bootstrap}/site/docs/4.1/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
	<script src="${bootstrap}/site/docs/4.1/assets/js/vendor/popper.min.js"></script>
	<script src="${bootstrap}/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>
