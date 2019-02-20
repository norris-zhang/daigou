<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/fragments/includes.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%request.setAttribute("showCost", request.getParameter("sc")); %>
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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
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
			<img alt="" src="${ctx}/images/logo.png?v=${cssv}" class="center" style="width: 100%;">
		</div>
		<div>
			<a href="${ctx}/">首页</a>
			&gt;
			<span>感兴趣的商品</span>
		</div>
		<div class="list-group">
			<c:forEach items="${prodList}" var="prod">
			<div class="list-group-item">
				<table>
					<tr>
						<td rowspan="3">
							<a href="${ctx}/product/${prod.prod_id}"><img alt="" src="${ctx}/${prod.mainPicPath}" width="64" height="64" /></a>
						</td>
						<td><a href="${ctx}/product/${prod.prod_id}">${prod.prod_title }</a></td>
					</tr>
					<tr>
						<td>
							<c:forEach items="${prod.effectivePrices }" var="price">
								<div id="price-${prod.prod_id}" class="priceSelector" data-price='{"prodId":${prod.prod_id}, "amount":${price.value.prce_amount }, "ship":${price.value.prce_gross_weight * price.key.count * 40} }'>${price.key.guge.guge_display} &times; ${price.key.count} ￥<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${price.value.prce_amount }"/> +
								￥<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${price.value.prce_gross_weight * price.key.count * 40 }"/>(运费)</div>
								<c:if test="${'Y' eq loginUser.user.user_is_admin && '1' eq showCost}">
									<div>成本：$<c:out value="${price.value.prce_cost_nzd}"></c:out> ¥<c:out value="${price.value.prce_cost_cny}"></c:out></div>
								</c:if>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td>
							<button onclick="return reduceCount('count-${prod.prod_id}')"><i class="fas fa-minus"></i></button>
							<input type="number" id="count-${prod.prod_id}" step="1" value="${empty prodCountMap.get(prod.prod_id) ? 1 : prodCountMap.get(prod.prod_id)}" readonly="readonly" style="width: 60px;"/>
							<button onclick="return increaseCount('count-${prod.prod_id}')"><i class="fas fa-plus"></i></button>
						</td>
					</tr>
				</table>
			</div>
			</c:forEach>
		</div>
		<div>总计：<span id="totalAmount">¥100 + ¥40</span></div>
		<%@ include file="/fragments/footer.jsp" %>
	</main>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript" src="${ctx}/js/jquery-3.3.1.min.js"></script>
	<script src="${bootstrap}/site/docs/4.1/assets/js/vendor/popper.min.js"></script>
	<script src="${bootstrap}/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function reduceCount(inputId) {
			var currentValue = eval($("#" + inputId).val());
			if (currentValue <= 0) {
				$("#" + inputId).val('0');
			} else {
				$("#" + inputId).val(--currentValue);
			}
			calcTotal();
			return false;
			
		}
		function increaseCount(inputId) {
			var currentValue = eval($("#" + inputId).val());
			$("#" + inputId).val(++currentValue);
			calcTotal();
			return false;
		}
		$(document).ready(function(){
			calcTotal();
		});
		function calcTotal() {
			var price = 0;
			var ship = 0;
			$(".priceSelector").each(function(index){
				var count = $("#count-" + $(this).data('price').prodId).val();
				price += $(this).data('price').amount * count;
				ship += $(this).data('price').ship * count;
			});
			if (ship < 40) {
				ship = 40;
			}
			$("#totalAmount").text('¥' + price.toFixed(2) + ' + ¥' + ship.toFixed(2) + '(运费) = ¥' + (price + ship).toFixed(2));
		}
	</script>
</body>
</html>
