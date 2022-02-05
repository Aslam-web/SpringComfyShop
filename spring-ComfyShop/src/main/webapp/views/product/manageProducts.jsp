<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="utf-8" />

    <!-- TOGGLE PRODUCT ADD -->
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
      $(document).on("click", "#btn-toggle", function (e) {
        var $button = $(this);
        if ($button.hasClass("card-body-visible")) {
          $button.parents(".card").find(".card-body").slideUp();
          $button.removeClass("card-body-visible");
          $button.parents(".card").find("i").removeClass("fa-chevron-up").addClass("fa-chevron-down");
        } else {
          $button.parents(".card").find(".card-body").slideDown();
          $button.addClass("card-body-visible");
          $button.parents(".card").find("i").removeClass("fa-chevron-down").addClass("fa-chevron-up");
        }
      });
    </script>

    <style>
      .row {
        margin-top: 40px;
        padding: 0 10px;
      }

      .clickable {
        cursor: pointer;
      }

      .panel-heading span {
        margin-top: -20px;
        font-size: 15px;
      }
    </style>

    <!-- FONT AWESOME CHEVRON (UP/DOWN) -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

    <title>Product Manage Page</title>
  </head>

  <body>
    <%@ include file="../header.jsp" %>

      <div class="container mb-50" style="margin-top: 80px">
        <!-- the toggle button -->
        <div class="row justify-content-center">
          <div class="col-8">
            <div class="row">
              <div class="col-12">
                <div class="card">
                  <div class="card-header d-flex justify-content-between">
                    <button class="btn btn-primary" id="btn-toggle" type="button" data-toggle="collapse show"
                      data-target="#collapseExample" aria-expanded="true" aria-controls="collapseExample">
                      Add Product
                    </button>
                    <i class="fa fa-chevron-up fa-2x"></i>
                  </div>
                  <div class="card-body collapse" id="collapseExample">
                    <!-- <div class="col-12"></div> -->
                    <form:form class="col-12" action="add" method="post" modelAttribute="product">
                      <!-- PRODUCT NAME -->
                      <div class="form-group">
                        <label for="productName" class="control-label">Product Name</label>
                        <div class="cols-sm-10">
                          <div class="input-group">
                            <span class="input-group-addon"></span>
                            <form:input type="text" class="form-control" path="productName" name="productName"
                              id="productName" placeholder="Enter product name" required="true" />
                          </div>
                        </div>
                      </div>
                      <!-- P.DESCRIPTION -->
                      <div class="form-group">
                        <label for="productDesc" class="cols-sm-2 control-label">Product Description</label>
                        <div class="cols-sm-10">
                          <div class="input-group">
                            <span class="input-group-addon"></span>
                            <form:input type="text" class="form-control" path="productDesc" name="productDesc"
                              id="productDesc" placeholder="Enter product description" required="true" />
                          </div>
                        </div>
                      </div>
                      <!-- P.PRICE -->
                      <div class="form-group">
                        <label for="price" class="cols-sm-2 control-label">Product Price</label>
                        <div class="cols-sm-10">
                          <div class="input-group">
                            <span class="input-group-addon"></span>
                            <form:input type="number" class="form-control" path="price" name="price" id="price"
                              placeholder="Enter product price" value="0" min="1" required="true" />
                          </div>
                        </div>
                      </div>
                      <!-- P.STOCK -->
                      <div class="form-group">
                        <label for="stock" class="cols-sm-2 control-label">Stock</label>
                        <div class="cols-sm-10">
                          <div class="input-group">
                            <span class="input-group-addon"></span>
                            <form:input type="number" class="form-control" path="stock" name="stock" id="stock"
                              placeholder="Enter the no.of stock remaining" value="1" min="1" required="true" />
                          </div>
                        </div>
                      </div>
                      <!-- P.IMAGE -->
                      <div class="form-group">
                        <label for="image" class="cols-sm-2 control-label">Image Link</label>
                        <div class="cols-sm-10">
                          <div class="input-group">
                            <span class="input-group-addon"></span>
                            <form:input type="text" class="form-control" path="image" name="image" id="image"
                              placeholder="https://www.shutterstock.com/image-photo/plaid-shirt-folded-plan-cuff-links-308281997"
                              required="true" />
                          </div>
                        </div>
                      </div>
                      <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-lg btn-block login-button">
                          CONFIRM
                        </button>
                      </div>
                    </form:form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="row mb-5">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title"><strong>All Products</strong></h3>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table table-condensed">
                    <thead>
                      <tr>
                        <td><strong>Product Id</strong></td>
                        <td class="text-center"><strong>Product Name</strong></td>
                        <td class="text-center"><strong>Product Price</strong></td>
                        <td class="text-center"><strong>In Stock</strong></td>
                        <td class="text-center"><strong>EDIT</strong></td>
                        <td class="text-center"><strong>DELETE</strong></td>
                      </tr>
                    </thead>
                    <tbody>
                      <!-- forEach start-->
                      <c:forEach items="${products}" var="p">
                        <tr class="justify-content-center">
                          <td>${p.productId}</td>
                          <td class="text-center">${p.productName}</td>
                          <td class="text-center">$${p.price}</td>
                          <td class="text-center">${p.stock}</td>
                          <td class="text-center">
                            <a class="btn btn-info" href=""
                              onclick="window.alert('Unable to edit. try some other time')">EDIT</a>
                          </td>
                          <td class="text-center">
                            <a class="btn btn-danger" href="<c:url value='/product/delete-${p.productId}'/>">DELETE</a>
                          </td>
                        </tr>
                      </c:forEach>
                      <!-- forEach end-->
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
  </body>

  </html>