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
<link href="${bootstrap}/dist/css/signin.css?v=${cssv}" rel="stylesheet">
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
			<a href="#">首页</a>
			&gt;<span>注册</span>
		</div>
		<form class="form-signin">
			<h1 class="h3 mb-3 font-weight-normal">新用户注册</h1>
			<label for="inputEmail" class="sr-only">登录邮箱</label>
			<input type="email" id="inputEmail" name="loginId" class="form-control" value="" placeholder="登录邮箱" required="required" autofocus="autofocus"/>
			<label for="inputPassword" class="sr-only">登录密码</label>
			<input type="password" id="inputPassword" name="password" class="form-control" placeholder="登录密码" required="required"/>
			<label for="confirmPwdId" class="sr-only">确认密码</label>
			<input type="password" id="confirmPwdId" name="confirmPwd" class="form-control" placeholder="确认密码" required="required"/>
			<label for="inviteCodeId" class="sr-only">VIP邀请码</label>
			<input type="text" id="inviteCodeId" name="inviteCode" class="form-control" value="" placeholder="VIP邀请码" required="required" autofocus="autofocus"/>
			<button class="btn btn-lg btn-primary btn-block" type="submit">注&nbsp;&nbsp;&nbsp;&nbsp;册</button>
			<div style="padding: 20px;">
				<a href="${ctx}/user/login.jsp">老用户登录</a>
			</div>
		</form>
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
