<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/fragments/includes.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setAttribute("showCost", request.getParameter("sc")); %>
<c:set var="needCloseRow" value="false"></c:set>
<c:forEach items="${prodList}" var="prod" varStatus="vs">
	<c:if test="${vs.index % 4 eq 0 }">
		<div class="row">
		<c:set var="needCloseRow" value="true"></c:set>
	</c:if>
	<div class="col-lg-3 col-6">
		<a href="${ctx}/product/${prod.prod_id}">
			<img alt="" src="${ctx}/${prod.mainPicPath}" class="center" style="width: 80%;"/>
			<div>
				<h5>${prod.prod_title }</h5>
			</div>
			<div>
				<c:forEach items="${prod.effectivePrices }" var="pricePair">
					<h6>${pricePair.key.guge.guge_display } * ${pricePair.key.count }: ￥${pricePair.value.prce_amount }
					<c:if test="${'Y' eq loginUser.user.user_is_admin && '1' eq showCost}">
						($<c:out value="${pricePair.value.prce_cost_nzd}"></c:out> ¥<c:out value="${pricePair.value.prce_cost_cny}"></c:out>)
					</c:if></h6>
				</c:forEach>
			</div>
		</a>
		<c:if test="${not empty loginUser && loginUser.user.user_is_admin eq 'Y'}">
			<a href="#">修改</a>
			<a href="${ctx}/admin/product/price/${prod.prod_id}">改价</a>
		</c:if>
	</div>
	<c:if test="${vs.index % 4 eq 3 }">
		</div>
		<c:set var="needCloseRow" value="false"></c:set>
	</c:if>
</c:forEach>
<c:if test="${needCloseRow eq 'true' }">
	</div>
</c:if>