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
	<jsp:include page="/fragments/nav.jsp"></jsp:include>
	<main role="main" class="container">
		<div>
			<img alt="" src="${ctx}/images/logo.png?v=${cssv}" class="center" style="width: 100%;">
		</div>
		<div>
			<a href="${ctx}/">首页</a>
		</div>
		<div>热销商品</div>
		<div>
			<c:set var="needCloseRow" value="false"></c:set>
			<c:forEach items="${prodList}" var="prod" varStatus="vs">
				<c:if test="${vs.index % 3 eq 0 }">
					<div class="row">
					<c:set var="needCloseRow" value="true"></c:set>
				</c:if>
				<div class="col-md-4">
					<a href="${ctx}/product/${prod.prod_id}">
						<img alt="" src="${ctx}/${prod.mainPicPath}" class="center" style="width: 80%;"/>
						<div>
							<h4>${prod.prod_title }</h4>
						</div>
						<div>
							<c:forEach items="${prod.effectivePrices }" var="pricePair">
								<h5>${pricePair.key.guge.guge_display } * ${pricePair.key.count }: ￥${pricePair.value.prce_amount }</h5>
							</c:forEach>
						</div>
					</a>
				</div>
				<c:if test="${vs.index % 3 eq 2 }">
					</div>
					<c:set var="needCloseRow" value="false"></c:set>
				</c:if>
			</c:forEach>
			<c:if test="${needCloseRow eq 'true' }">
				</div>
			</c:if>
		</div>
		<div id="loadingGif" style="display: none;" data-current-page="1">
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
	<script type="text/javascript">
		$(window).scroll(function() {
			var scrollTop = $(this).scrollTop(); // distance from top
			var scrollHeight = $(document).height(); // total height
			var windowHeight = $(this).height(); // visible height
			if (scrollTop + windowHeight == scrollHeight) {
				triggerLoadNextPage();
			}
		});
		function loadNextPage() {
			var currentPage = $("#loadingGif").data("current-page");
			if (!currentPage) {
				currentPage = 1;
			}
			$.getJSON("${ctx}${requestURI}",
				{
					p:currentPage + 1,
					v:new Date().getTime()
				},
				function(json) {
					
				}
			);
		}
		function triggerLoadNextPage() {
			var isHidden = $("#loadingGif").is(":hidden");
			if (!isHidden) {
				return; // If the loading gif is showing, do not request again.
			}
			$("#loadingGif").show();
			loadNextPage();
		}
	</script>
</body>
</html>
