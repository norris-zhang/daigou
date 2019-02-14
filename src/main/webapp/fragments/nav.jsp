<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="${ctx}/">呆狗</a>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="${ctx}/">首页
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" id="dropdown01" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">所有商品</a>
					<div class="dropdown-menu" aria-labelledby="dropdown01">
						<a href="${ctx}/product/category/3" class="dropdown-item">营养保健</a>
						<a href="${ctx}/product/category/5" class="dropdown-item">护肤美体</a>
						<a href="${ctx}/product/category/2" class="dropdown-item">纯净蜂蜜</a>
						<a href="${ctx}/product/category/1" class="dropdown-item">奶粉直邮</a>
						<a href="${ctx}/product/category/4" class="dropdown-item">母婴呵护</a>
						<a href="${ctx}/product/category/6" class="dropdown-item">生活日用</a>
						<a href="${ctx}/product/category/7" class="dropdown-item">特色零食</a>
					</div>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">打折专区</a></li>
				<li class="nav-item"><a class="nav-link" href="#">新品上架</a></li>
				<li class="nav-item"><a class="nav-link" href="#">品牌专区</a></li>
				<li class="nav-item"><a class="nav-link" href="#">买家秀</a></li>
				<li class="nav-item"><a class="nav-link" href="#">关于我们</a></li>
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
