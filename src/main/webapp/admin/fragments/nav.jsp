<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="#">呆狗后台</a>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">首页
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="${ctx}/admin/inviteCode/generateCode.jsp">邀请码管理</a></li>
				<li class="nav-item"><a class="nav-link" href="#">商品管理</a></li>
				<li class="nav-item"><a class="nav-link" href="#">商品分类管理</a></li>
				<li class="nav-item"><a class="nav-link" href="#">过滤条件管理</a></li>
				<li class="nav-item"><a class="nav-link" href="#">会员管理</a></li>
				<li class="nav-item"><a class="nav-link" href="#">联系我们</a></li>
				<!-- <li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a> -->
				</li>
			</ul>
			<form class="form-inline mt-2 mt-md-0">
				<input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
		<div class="navbar-nav" style="padding-left: 10px;">
			<a class="navbar-link" href="${ctx}/user/login.jsp" style="color: #fff;">登录/注册</a>
		</div>
	</nav>
