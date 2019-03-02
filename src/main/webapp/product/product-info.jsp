<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/fragments/includes.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<img alt="" src="${ctx}/images/logo.png?v=${cssv}" class="center" style="width: 100%;">
		</div>
		<div>
			<a href="${ctx}/">首页</a>
			&gt;<a href="${ctx}/">所有商品</a>
			&gt;<a href="${ctx}/product/category/${prod.prca.prca_id}">${prod.prca.prca_name }</a>
			&gt;${prod.prod_name }
		</div>
		<div>
			<img alt="" src="${ctx}/${prod.mainPicPath}" class="center" style="width: 80%;"/>
			<h4>${prod.prod_title }</h4>
			<hr class="hrdelimiter"/>
			<c:forEach items="${prod.effectivePrices }" var="price">
				<div style="background-color: #D9534F; height: 30px; text-align: center; color: #fff;"><h5>${price.key.guge.guge_display} &times; ${price.key.count} ￥<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${price.value.prce_amount }"/> +
				￥<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${price.value.prce_gross_weight * price.key.count * 40 }"/>(运费)</h5></div>
			</c:forEach>
			<hr class="hrdelimiter"/>
			<form action="#" method="post" onsubmit="return addToShoppingCart()">
				<div class="row" style="background-color: #04cee6; margin-left: 0; margin-right: 0;">
					<div class="col-4 stuffed text-center" style="padding-top: 7px; color: #fff;"><label for="buyno">购买数量：</label></div>
					<div class="col-4 stuffed"><input class="form-control" type="number" name="buyno" value="1" id="buyno"/></div>
					<div class="col-4 stuffed"><button class="form-control" type="submit" onclick="return constructing()" style="background-color: #04cee6; color: #fff;">加入购物车</button></div>
				</div>
			</form>
			<hr class="hrdelimiter"/>
			<div>${prod.prod_description }</div>
		</div>
		<%@ include file="/fragments/footer.jsp" %>
	</main>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript" src="${ctx}/js/jquery-3.3.1.min.js"></script>
	<script src="${bootstrap}/site/docs/4.1/assets/js/vendor/popper.min.js"></script>
	<script src="${bootstrap}/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function constructing() {
			
			alert("建设中，暂时不能使用在线购买功能，请联系店主");
			return false;
		}
		function addToShoppingCart() {
			
		}
	</script>
</body>
</html>
