<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ include file="../css/allProducts.css" %>
<%@ include file="../js/allProducts.js" %> --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1" />
	
	<style>
		.view-group {
	  display: -ms-flexbox;
	  display: flex;
	  -ms-flex-direction: row;
	  flex-direction: row;
	  padding-left: 0;
	  margin-bottom: 0;
	}
	.thumbnail
	{
	  margin-bottom: 30px;
	  padding: 0px;
	  -webkit-border-radius: 0px;
	  -moz-border-radius: 0px;
	  border-radius: 0px;
	}
	
	.item.list-group-item
	{
	  float: none;
	  width: 100%;
	  background-color: #fff;
	  margin-bottom: 30px;
	  -ms-flex: 0 0 100%;
	  flex: 0 0 100%;
	  max-width: 100%;
	  padding: 0 1rem;
	  border: 0;
	}
	.item.list-group-item .img-event {
	  float: left;
	  width: 30%;
	}
	
	.item.list-group-item .list-group-image
	{
	  margin-right: 10px;
	}
	.item.list-group-item .thumbnail
	{
	  margin-bottom: 0px;
	  display: inline-block;
	}
	.item.list-group-item .caption
	{
	  float: left;
	  width: 70%;
	  margin: 0;
	}
	
	.item.list-group-item:before, .item.list-group-item:after
	{
	  display: table;
	  content: " ";
	}
	
	.item.list-group-item:after
	{
	  clear: both;
	}
	</style>
	
	<title>Products Page</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div style="margin-top: 80px" class="container">
		
		<div id="products" class="row view-group">

			<c:forEach items="${products}" var="p">
				
					<div class="item col-xs-4 col-lg-4">
						<div class="thumbnail card">
							<div class="img-event">
								<img class="group list-group-image img-fluid"
									src="${p.image}"
									alt="" />
							</div>
							<div class="caption card-body">
								<h4 class="group card-title inner list-group-item-heading">
									${p.productName}</h4>
								<p class="group inner list-group-item-text">${p.productDesc}</p>
								<div class="row">
									<div class="col-xs-12 col-md-6">
										<p class="lead">$ ${p.price}</p>
									</div>
									<div class="col-xs-12 col-md-6">
										<a class="btn btn-success" href="<c:url value="/product/${p.productId}"/>">View Product</a>
									</div>
								</div>
							</div>
						</div>
					</div>

			</c:forEach>

		</div>
	</div>

</body>
</html>