<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />

    <style>
      .table > tbody > tr > .no-line {
        border-top: none;
      }

      .table > thead > tr > .no-line {
        border-bottom: none;
      }

      .table > tbody > tr > .thick-line {
        border-top: 2px solid;
      }

      .final-price {
        font-size: 26px;
        font-weight: 300;
      }
    </style>

    <title>Invoice Page</title>
  </head>
  <body>
    <%@ include file="header.jsp" %>

    <div style="margin-top: 80px" class="container">
      <div class="row">
        <div class="col-12">
          <div class="row">
            <h2 class="d-lg-inline-block col-3">Invoice</h2>
            <h2 class="d-lg-inline-block col"></h2>
            <h2 class="d-lg-inline-block col-3 text-right">
              Order # ${generatedInvoiceId}
            </h2>
          </div>
          <hr />
          <div class="row">
            <div class="col-6">
            <address>
              <strong>Billed To:</strong><br /> 
              ${user.name}<br />
              ${user.email}<br /> 
              ${user.address}<br />
            </address>
            </div>
            <div class="col-6 text-right">
              <address>
                <strong>Order Date:</strong><br />
                ${invoice.orderDate}<br /><br />
              </address>
            </div>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-md-12">
          <div class="card">
            <div class="card-header">
              <h3 class="card-title"><strong>Order summary</strong></h3>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-condensed">
                  <thead>
                    <tr>
                      <td><strong>Item</strong></td>
                      <td class="text-center"><strong>Price</strong></td>
                      <td class="text-center"><strong>Quantity</strong></td>
                      <td class="text-right"><strong>Totals</strong></td>
                    </tr>
                  </thead>
                  <tbody>
                    <!-- forEach ($order->lineItems as $line) or some such thing here -->
                    <c:forEach items="${cartItems}" var="c">
                    <tr>
                      <td>${c.productName}</td>
                      <td class="text-center">$${c.price}</td>
                      <td class="text-center">${c.quantity}</td>
                      <td class="text-right">$${c.price * c.quantity}</td>
                    </tr>
                    </c:forEach>
                    <!-- forEach end here -->
                  </tbody>
                </table>
              </div>
            </div>
            <div class="card-footer mb-4">
              <div class="table-responsive">
                <table class="table table-condensed">
                  <tr>
                    <td class="no-line"></td>
                    <td class="no-line"></td>
                    <td class="no-line text-center">
                      <strong>Sub-Total</strong>
                    </td>
                    <td class="no-line text-right">$ ${invoice.totalAmount}</td>
                  </tr>
                  <tr>
                    <td class="no-line"></td>
                    <td class="no-line"></td>
                    <td class="no-line text-center">
                      <strong>Shipping</strong>
                    </td>
                    <td class="text-right">$0</td>
                  </tr>
                  <tr>
                    <td class="no-line"></td>
                    <td class="no-line"></td>
                    <td class="no-line text-center">
                      <strong>Grand-Total</strong>
                    </td>
                    <td class="final-price text-right">
                      <strong>$ ${invoice.totalAmount}</strong>
                    </td>
                  </tr>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
