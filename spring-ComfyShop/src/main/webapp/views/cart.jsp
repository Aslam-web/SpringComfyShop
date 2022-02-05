<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}" /> --%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <!-- BUTTON DISABLE FOR EMPTY CART -->
	  <script>
		function checkCartEmpty() {
			console.log("cart empty method called");
			const empty = !(document.getElementsByClassName("cardlist").length > 0);
			if (empty) {
				document.getElementsByClassName("btn-cart")[0].hidden = true;
				document.getElementsByClassName("btn-cart")[1].disabled = true;
			}
		}
	</script>

	  <!-- CSS STYLE -->
    <style>
      
      .card{
        border-radius: 0;
      }
      .card .card-header{
        background-color: #fff;
        font-size: 18px;
        padding: 10px 16px;
      }
      .proviewcard .card-body{
        padding: 0;
      }
      .cardlist{
        border-bottom: 1px solid #f0f0f0;
      }
      .cardlist:last-child{
        border: 0;
      }
      .addcartimg{
        height: 100px;
      }
      .cartproname{
        font-size: 15px;
        color: #212529;
        line-height: 1;
        display: inline;
      }
      .cartproname:hover{
        color: #c16302;
        text-decoration: none;
      }
      .seller{
        font-size: 12px;
        color: #666;
        margin-bottom: 5px;
        line-height: 1;
      }
      .cartviewprice{
        margin-bottom: 8px;
        line-height: 1;
      }
      .cartviewprice span{
        display: inline-block;
        padding-right: 10px;
        margin-bottom: 5px;
      }
      .cartviewprice .amt{
        font-size: 18px;
        font-weight: 600;
      }
      .qty .input-group{
        width: 100%;
        height: 25px;
      }
      .btn-qty{
        height: 25px;
        color: #fff !important;
        background-color: #555 !important; 
        border-color: #555 !important;
        padding: 0px 3px !important;
      }
      .qty input{
        height: 25px;
      }
      .addcardrmv{
        font-size: 14px;
        line-height: 1.8;
        text-transform: uppercase;
        color: #212529;
      }
      .addcardrmv:hover{
        color: #c16302;
        text-decoration: none;
        font-weight: 600;
      }
      .prostatus .del-time {
        font-size: 12px;
        color: #757575;
        margin-right: 10px;
      }
      .prostatus .del-time > span {
        font-weight: 600;
        color: #555;
      }
      .proviewcard .card-footer{
        text-align: center;
        box-shadow: rgba(0, 0, 0, 0.1) 0px -2px 10px 0px;
        padding: 8px 15px;
      }
      .btn-add-con{
        background-color: #fff;
        color: #212121;
        box-shadow: rgba(0, 0, 0, 0.1) 0px 2px 2px 0px;
        font-size: 16px;
        font-weight: 500;
        padding: 8px 20px;
        border-radius: 2px;
        border-width: 1px;
        border-style: solid;
        border-color: #E0E0E0;
        border-image: initial;
        min-width: 185px;
      }
      .card .card-footer{
        background-color: #fff;
      }

      /*Card Footer Fixed*/
      @supports (box-shadow: 2px 2px 2px black){
        .cart-panel-foo-fix{
          position: sticky;
          bottom: 0;
          z-index: 9;
        }
      }

      .btn-cust {
        background-color: #e96125 !important;
        color: #fff !important;
        font-size: 16px;
        padding: 8px 8px;
        min-width: 128px;
      }
      .btn-cust:hover {
        background-color: #c74b14 !important;
        color: #fff !important;
      }
    </style>

    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <title>Cart Page</title>
  </head>
  <body onload="checkCartEmpty()">
  
	<%@ include file="header.jsp" %>
    
    <div class="container" style="margin-top: 80px">
      <div class="col-lg-12">
        <div class="row justify-content-center">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-header">My Cart</div>
              <div class="card-body">
              <c:choose>
              <c:when test="${empty cartItems}">
              	<h3>Oops ! No items in cart. Lets Go shopping :)</h3>
              </c:when>
              <c:otherwise>
                <!-- CARD 1 START-->
                <!-- for each form here :  -->
                <c:forEach items="${cartItems}" var="c">
                <div class="col-lg-12 p-3 cardlist">
                  <div class="col-lg-12">
                    <div class="row">
                      <div class="col-lg-7">
                        <div class="row">
                          <div class="col-4">
                            <div class="row">
                              <a href="/product/${c.productId}">
                                <img
                                  src="${c.image}"
                                  class="mx-auto d-block mb-1"
                                  style="height: 100px;"
                                />
                              </a>
                            </div>
                          </div>
                          <div class="col-6 m-auto">
                            <a href="/product/${c.productId}" class="cartproname"
                              >${c.productName}</a
                            >
                          </div>
                        </div>
                      </div>
                      <div class="col-lg-3 m-auto">
                        <strong>$ ${c.price}</strong>
                      </div>
                      <div class="col-lg-2 m-auto">
                        <div class="row">
                          <div class="prostatus">
                            <div class="col-lg-3 col-5">
                            <a href="<c:url value="/cart/remove-${c.cartItemId}"/>"><button class="btn btn-danger">Remove</button></a>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                </c:forEach>
                <!-- for each end here -->
                <!-- CARD 1 END -->
              </c:otherwise>
              </c:choose>
              </div>
              <div class="card-footer cart-panel-foo-fix text-right">
                <div class="row">
                <a href="<c:url value="/cart/remove-all"/>" class="col"> <button class="btn btn-danger btn-cart">Clear Cart</button></a>
                <p class="col"></p>
                <a href="<c:url value="/product/list"/>" class="btn btn-warning col">Continue Shopping</a>
                <p class="col"></p>
                <a href="<c:url value="/order/buy"/>" class="col"><button class="btn btn-success btn-cart">Place Order</button></a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>