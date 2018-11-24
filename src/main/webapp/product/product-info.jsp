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
.hrdelimiter {
	margin-top: 8px;
	margin-bottom: 8px;
}
.stuffed {
	padding: 0;
	border: 0;
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
			&gt;Healtheries贺寿利 儿童牛奶咀嚼片 草莓味 50片
		</div>
		<div>
			<img alt="" src="${ctx}/prototype-images/milkbites1.jpg" class="center" style="width: 100%;"/>
			<h4>【双11特价】Healtheries贺寿利 儿童牛奶咀嚼片 草莓味 50片 Healtheries Milk Bites Strawberry Flavour 50 bites 保质期2020年1月</h4>
			<form action="#" method="post">
				<select class="form-control" style="background-color: #04cee6;">
					<option>60粒</option>
				</select>
			</form>
			<hr class="hrdelimiter"/>
			<div style="background-color: #D9534F; height: 30px; text-align: center; color: #fff;"><h5>￥45.00</h5></div>
			<hr class="hrdelimiter"/>
			<form action="#" method="post">
				<div class="row" style="background-color: #04cee6; margin-left: 0; margin-right: 0;">
					<div class="col-4 stuffed text-center" style="padding-top: 7px; color: #fff;"><label for="buyno">购买数量：</label></div>
					<div class="col-4 stuffed"><input class="form-control" type="number" name="buyno" value="1" id="buyno"/></div>
					<div class="col-4 stuffed"><button class="form-control" type="submit" style="background-color: #04cee6; color: #fff;">加入购物车</button></div>
				</div>
			</form>
			<hr class="hrdelimiter"/>
			<div>
				<p>【产品规格】 60粒
				<br/>【产品产地】 新西兰
				<br/>【产品包装】 瓶装
				<br/>【保质期限】 具体日期请以收到实物为准
				<br/>【适用人群】 成人
				<br/>【产品成分】 奶蓟草提取物
				<br/>【注意事项】 按照瓶身说明服用，如果正在服用其他药物，请咨询医生
				<br/>【使用说明】 1天1粒，可以随时服用，或遵医嘱</p>
			</div>
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
