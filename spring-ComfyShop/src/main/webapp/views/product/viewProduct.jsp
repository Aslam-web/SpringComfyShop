<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- FONT AWESOME -->
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<title>Product View Page</title>

<style>
/* Basic Styling */
html, body {
	height: 100%;
	width: 100%;
	margin: 0;
	font-family: 'Roboto', sans-serif;
}

.container {
	max-width: 1200px;
	margin: 0 auto;
	padding: 15px;
	display: flex;
}

/* Columns */
.left-column {
	width: 65%;
	position: relative;
}

.right-column {
	width: 35%;
	margin-top: 60px;
}

/* Left Column */
.left-column img {
	width: 100%;
	position: absolute;
	left: 0;
	top: 0;
	opacity: 0;
	transition: all 0.3s ease;
}

.left-column img.active {
	opacity: 1;
}

/* Right Column */

span.fa.fa-star, span.fa.fa-star-o {
      color: gold;
    }

/* Product Description */
.product-description {
	border-bottom: 1px solid #E1E8EE;
	margin-bottom: 20px;
}

.product-description span {
	font-size: 12px;
	color: #358ED7;
	letter-spacing: 1px;
	text-transform: uppercase;
	text-decoration: none;
}

.product-description h1 {
	font-weight: 300;
	font-size: 52px;
	color: #43484D;
	letter-spacing: -2px;
}

.product-description p {
	font-size: 16px;
	font-weight: 300;
	color: #86939E;
	line-height: 24px;
}

/* Product Configuration */
.product-color span, .cable-config span {
	font-size: 14px;
	font-weight: 400;
	color: #86939E;
	margin-bottom: 20px;
	display: inline-block;
}

/* Product Color */
.product-color {
	margin-bottom: 30px;
}

.color-choose div {
	display: inline-block;
}

.color-choose input[type="radio"] {
	display: none;
}

.color-choose input[type="radio"]+label span {
	display: inline-block;
	width: 40px;
	height: 40px;
	margin: -1px 4px 0 0;
	vertical-align: middle;
	cursor: pointer;
	border-radius: 50%;
}

.color-choose input[type="radio"]+label span {
	border: 2px solid #FFFFFF;
	box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.33);
}

.color-choose input[type="radio"]#red+label span {
	background-color: #C91524;
}

.color-choose input[type="radio"]#blue+label span {
	background-color: #314780;
}

.color-choose input[type="radio"]#black+label span {
	background-color: #323232;
}

.color-choose input[type="radio"]:checked+label span {
	background-image: url(images/check-icn.svg);
	background-repeat: no-repeat;
	background-position: center;
}

/* Cable Configuration */
.cable-choose {
	margin-bottom: 20px;
}

.cable-choose button {
	border: 2px solid #E1E8EE;
	border-radius: 6px;
	padding: 13px 20px;
	font-size: 14px;
	color: #5E6977;
	background-color: #fff;
	cursor: pointer;
	transition: all .5s;
}

.cable-choose button:hover, .cable-choose button:active, .cable-choose button:focus
	{
	border: 2px solid #86939E;
	outline: none;
}

.cable-config {
	border-bottom: 1px solid #E1E8EE;
	margin-bottom: 20px;
}

.cable-config a {
	color: #358ED7;
	text-decoration: none;
	font-size: 12px;
	position: relative;
	margin: 10px 0;
	display: inline-block;
}

.cable-config a:before {
	content: "?";
	height: 15px;
	width: 15px;
	border-radius: 50%;
	border: 2px solid rgba(53, 142, 215, 0.5);
	display: inline-block;
	text-align: center;
	line-height: 16px;
	opacity: 0.5;
	margin-right: 5px;
}

/* Product Price */
.product-price {
	display: flex;
	align-items: center;
}

.product-price span {
	font-size: 26px;
	font-weight: 300;
	color: #43474D;
	margin-right: 20px;
}

.cart-btn {
	display: inline-block;
	background-color: #7DC855;
	border-radius: 6px;
	font-size: 16px;
	color: #FFFFFF;
	text-decoration: none;
	padding: 12px 30px;
	transition: all .5s;
}

.cart-btn:hover {
	background-color: #64af3d;
}

/* Responsive */
@media ( max-width : 940px) {
	.container {
		flex-direction: column;
		margin-top: 60px;
	}
	.left-column, .right-column {
		width: 100%;
	}
	.left-column img {
		width: 300px;
		right: 0;
		top: -65px;
		left: initial;
	}
}

@media ( max-width : 535px) {
	.left-column img {
		width: 220px;
		top: -85px;
	}
}
</style>

</head>
<body>
	<%@ include file="../header.jsp"%>

	<main style="margin-top: 80px;" class="container">

		<c:set value="${product}" var="p" />
		<!-- <c:if test="${condition}"> -->
		
			<div class="left-column">
				<img class="active" src="${p.image}"
					alt="https://aptsoundtesting.co.uk/wp-content/uploads/2018/07/default_no_image-430x250.jpg">
			</div>
			<div class="right-column">
				<div class="product-description">
					<h1>${p.productName}</h1>
					<p>${p.productDesc}</p>
				</div>
				<div class="product-configuration">
					<div class="cable-config">
						<strong>Rating : </strong>
						<div>
							<span class="fa fa-star"></span>
							<span class="fa fa-star"></span>
							<span class="fa fa-star"></span>
							<span class="fa fa-star-o"></span>
							<span class="fa fa-star-o"></span>
						</div>
						<strong>In Stock : </strong>
						<div>
							<span>${p.stock}</span>
						</div>
					</div>
					<div class="cable-config">
						<div class="product-price">
							<span>Price : <strong>$ ${p.price}</strong></span>
						</div>
					</div>
				</div>
				<div style="text-align: center;">
					<a href="<c:url value="/cart/${p.productId}"/>"><button class="btn btn-success">Place Order</button></a>
				</div>
			</div>

		<!-- </c:if> -->

	</main>
</body>
</html>