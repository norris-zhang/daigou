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
	<jsp:include page="/admin/fragments/nav.jsp"></jsp:include>
	<main role="main" class="container">
		<div>
			<a href="#">首页</a>
			&gt;&gt;
			<a href="#">邀请码管理</a>
			&gt;&gt;
			<a href="#">生成邀请码</a>
		</div>
		<div>
			<form action="#" method="post">
				<div class="form-group">
					<label>邀请码</label>
					<input type="text" class="form-control" name="inviteCode" value="123456" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="realName">姓名</label>
					<input type="text" class="form-control" id="realName" name="realName" placeholder="姓名">
				</div>
				<div class="form-group">
					<label for="wxName">微信姓名</label>
					<input type="text" class="form-control" id="wxName" name="wxName" placeholder="微信名">
				</div>
				<div class="form-group">
					<label for="wxid">微信ID</label>
					<input type="text" class="form-control" id="wxid" name="wxid" placeholder="微信ID">
				</div>
				<button type="submit" class="btn btn-primary">创建</button>
				<button type="button" class="btn btn-secondary">取消</button>
			</form>
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
</body>
</html>
