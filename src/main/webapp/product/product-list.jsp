<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/fragments/includes.jsp" %>
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
	<jsp:include page="/fragments/nav.jsp"></jsp:include>
	<main role="main" class="container">
		<div>
			<img alt="" src="${ctx}/images/logo.png" class="center" style="width: 100%;">
		</div>
		<div>
			<a href="${ctx}">首页</a>
			&gt;<a href="#">所有商品</a>
			&gt;<a href="${ctx}/product/product-list.jsp">营养保健</a>
		</div>
		<form action="#" method="post" id="filter-form">
			<div class="form-group">
				<button class="form-control" type="button" data-toggle="collapse" data-target="#suitable-for" aria-expanded="false" aria-controls="suitable-for">适用人群</button>
				<div id="suitable-for" class="collapse" style="background-color: #eee; padding: 5px;">
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="suitable-for-001"/>
						<label class="form-check-label" for="suitable-for-001">聪明宝宝</label>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="suitable-for-002"/>
						<label class="form-check-label" for="suitable-for-002">健康父母</label>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="suitable-for-003"/>
						<label class="form-check-label" for="suitable-for-003">美丽妈妈</label>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="suitable-for-004"/>
						<label class="form-check-label" for="suitable-for-004">美丽女性</label>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="suitable-for-005"/>
						<label class="form-check-label" for="suitable-for-005">强健老公</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<button class="form-control" type="button" data-toggle="collapse" data-target="#care-func" aria-expanded="false" aria-controls="care-func">保健功能</button>
				<div id="care-func" class="collapse" style="background-color: #eee; padding: 5px;">
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="care-func-001"/>
						<label class="form-check-label" for="care-func-001">安神助眠</label>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="care-func-002"/>
						<label class="form-check-label" for="care-func-002">补气养血</label>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="care-func-003" disabled="disabled"/>
						<label class="form-check-label" for="care-func-003">补肾壮阳</label>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="care-func-004"/>
						<label class="form-check-label" for="care-func-004">调节三高</label>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="care-func-005"/>
						<label class="form-check-label" for="care-func-005">调内分泌</label>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="care-func-006"/>
						<label class="form-check-label" for="care-func-006">关节修复</label>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="care-func-007"/>
						<label class="form-check-label" for="care-func-007">护眼明目</label>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="care-func-008"/>
						<label class="form-check-label" for="care-func-008">减肥瘦身</label>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="care-func-009"/>
						<label class="form-check-label" for="care-func-009">健脑益智</label>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="care-func-010"/>
						<label class="form-check-label" for="care-func-010">降脂减压</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<button class="form-control" type="button" data-toggle="collapse" data-target="#ingredient" aria-expanded="false" aria-controls="ingredient">营养成分</button>
				<div id="ingredient" class="collapse" style="background-color: #eee; padding: 5px;">
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="ingredient-001"/>
						<label class="form-check-label" for="ingredient-001">DHA</label>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="ingredient-002"/>
						<label class="form-check-label" for="ingredient-002">蛋白质</label>
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="ingredient-003" disabled="disabled"/>
						<label class="form-check-label" for="ingredient-003">蜂胶蜂王浆</label>
					</div>
				</div>
			</div>
		</form>
		<div>
			<div class="row">
				<div class="col-md-4">
					<a href="${ctx}/product/product-info.jsp">
						<img alt="" src="${ctx}/prototype-images/milkbites1.jpg" class="center" style="width: 80%;"/>
						<div>
							<h4>【双11特价】Healtheries贺寿利 儿童牛奶咀嚼片 草莓味 50片 Healtheries Milk Bites Strawberry Flavour 50 bites 保质期2020年1月</h4>
						</div>
						<div>
							<h5>￥45.00</h5>
						</div>
					</a>
				</div>
				<div class="col-md-4">
					<a href="${ctx}/product/product-info.jsp">
						<img alt="" src="${ctx}/prototype-images/milkbites1.jpg" class="center" style="width: 80%;"/>
						<div>
							<h4>【双11特价】Healtheries贺寿利 儿童牛奶咀嚼片 草莓味 50片 Healtheries Milk Bites Strawberry Flavour 50 bites 保质期2020年1月</h4>
						</div>
						<div>
							<h5>￥45.00</h5>
						</div>
					</a>
				</div>
				<div class="col-md-4">
					<a href="${ctx}/product/product-info.jsp">
						<img alt="" src="${ctx}/prototype-images/milkbites1.jpg" class="center" style="width: 80%;"/>
						<div>
							<h4>【双11特价】Healtheries贺寿利 儿童牛奶咀嚼片 草莓味 50片 Healtheries Milk Bites Strawberry Flavour 50 bites 保质期2020年1月</h4>
						</div>
						<div>
							<h5>￥45.00</h5>
						</div>
					</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<a href="${ctx}/product/product-info.jsp">
						<img alt="" src="${ctx}/prototype-images/milkbites1.jpg" class="center" style="width: 80%;"/>
						<div>
							<h4>【双11特价】Healtheries贺寿利 儿童牛奶咀嚼片 草莓味 50片 Healtheries Milk Bites Strawberry Flavour 50 bites 保质期2020年1月</h4>
						</div>
						<div>
							<h5>￥45.00</h5>
						</div>
					</a>
				</div>
				<div class="col-md-4">
					<a href="${ctx}/product/product-info.jsp">
						<img alt="" src="${ctx}/prototype-images/milkbites1.jpg" class="center" style="width: 80%;"/>
						<div>
							<h4>【双11特价】Healtheries贺寿利 儿童牛奶咀嚼片 草莓味 50片 Healtheries Milk Bites Strawberry Flavour 50 bites 保质期2020年1月</h4>
						</div>
						<div>
							<h5>￥45.00</h5>
						</div>
					</a>
				</div>
				<div class="col-md-4">
					<a href="${ctx}/product/product-info.jsp">
						<img alt="" src="${ctx}/prototype-images/milkbites1.jpg" class="center" style="width: 80%;"/>
						<div>
							<h4>【双11特价】Healtheries贺寿利 儿童牛奶咀嚼片 草莓味 50片 Healtheries Milk Bites Strawberry Flavour 50 bites 保质期2020年1月</h4>
						</div>
						<div>
							<h5>￥45.00</h5>
						</div>
					</a>
				</div>
			</div>
		</div>
		<div>
			<img alt="" src="${ctx}/images/loading-gif.svg" class="center" style="width: 40px; height: 40px;"/>
		</div>
		<%@ include file="/fragments/footer.jsp" %>
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
</body>
</html>
