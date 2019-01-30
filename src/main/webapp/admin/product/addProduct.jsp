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
			<a href="#">录入商品</a>
		</div>
		<div>
			<form id="uploadFileForm" action="${ctx}/admin/picupload" method="post" enctype="multipart/form-data" target="fileUploadResult">
				<div class="form-group">
					<label for="picUpload">上传图片</label>
					<input type="file" class="form-control" id="picUpload" name="picUpload" placeholder="选择图片">
				</div>
				<button type="submit" class="btn btn-primary">上传</button>
			</form>
			<div>
			<iframe id="fileUploadResult" name="fileUploadResult"></iframe>
			</div>
			<form action="${ctx}/admin/product/add" method="post">
				<div class="form-group">
					<label for="primaryPictId">主图ID</label>
					<input type="number" class="form-control" id="primaryPictId" name="primaryPictId" placeholder="主图ID">
				</div>
				<div class="form-group">
					<label for="productCategory">商品类别</label>
					<select id="productCategory" name="productCategory" class="form-control">
						<c:forEach items="${categoryList}" var="cate">
						<option value="${cate.prca_id}">${cate.prca_name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label for="productName">商品名称</label>
					<input type="text" class="form-control" id="productName" name="productName" placeholder="商品名称">
				</div>
				<div class="form-group">
					<label for="productNameEn">英文名</label>
					<input type="text" class="form-control" id="productNameEn" name="productNameEn" placeholder="英文名">
				</div>
				<div class="form-group">
					<label for="displayTitle">显示标题</label>
					<input type="text" class="form-control" id="displayTitle" name="displayTitle" placeholder="显示标题">
				</div>
				<div class="form-group">
					<label for="productDescription">产品描述</label>
					<textarea id="productDescription" name="productDescription" class="form-control" placeholder="产品描述"></textarea>
				</div>
				<div class="form-group">
					<label for="grossWeight">打包重量</label>
					<input type="number" step="0.01" class="form-control" id="grossWeight" name="grossWeight" placeholder="打包重量">
				</div>
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
	<script type="text/javascript">
		
	</script>
</body>
</html>
