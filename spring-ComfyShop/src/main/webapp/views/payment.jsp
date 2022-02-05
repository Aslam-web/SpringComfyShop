<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8">

    <style>
      .padding {
        padding: 5rem !important;
        margin-left: 300px;
      }

      .card {
        margin-bottom: 1.5rem;
      }

      .card {
        position: relative;
        display: -ms-flexbox;
        display: flex;
        -ms-flex-direction: column;
        flex-direction: column;
        min-width: 0;
        word-wrap: break-word;
        background-color: #fff;
        background-clip: border-box;
        border: 1px solid #c8ced3;
        border-radius: 0.25rem;
      }

      .card-header:first-child {
        border-radius: calc(0.25rem - 1px) calc(0.25rem - 1px) 0 0;
      }

      .card-header {
        padding: 0.75rem 1.25rem;
        margin-bottom: 0;
        background-color: #f0f3f5;
        border-bottom: 1px solid #c8ced3;
      }

      .card-body {
        flex: 1 1 auto;
        padding: 1.25rem;
      }

      .form-control:focus {
        color: #5c6873;
        background-color: #fff;
        border-color: #c8ced3 !important;
        outline: 0;
        box-shadow: 0 0 0 #f44336;
      }
    </style>

    <link href="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/3.6.95/css/materialdesignicons.css"
      rel="stylesheet" id="bootstrap-css">
    <title>Payment Page</title>
  </head>

  <body>

    <%@ include file="header.jsp" %>

      <div class="container" style="margin-top: 80px;">
        <div class="row justify-content-center mb-5">
          <div class="col-sm-6">

            <form action="/order/pay">
              <div class="card">
                <div class="card-header">
                  <h2>Credit Card Details</h2>
                </div>
                <div class="card-body">
                  <div class="row">
                    <div class="col-sm-12">
                      <div class="form-group">
                        <label for="ccnumber">Credit Card Number</label>
                        <div class="input-group">
                          <div class="input-group-append">
                            <span class="input-group-text">
                              <i class="mdi mdi-credit-card"></i>
                            </span>
                          </div>
                          <input class="form-control" type="number" min="4000000000000000" max="4999999999999999"
                            placeholder="0000 0000 0000 0000" required="true">
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="form-group col-4">
                      <label for="ccmonth">Month</label>
                      <select class="form-control" id="ccmonth" required>
                        <option selected>01</option>
                        <option>02</option>
                        <option>03</option>
                        <option>04</option>
                        <option>05</option>
                        <option>06</option>
                        <option>07</option>
                        <option>08</option>
                        <option>09</option>
                        <option>10</option>
                        <option>11</option>
                        <option>12</option>
                      </select>
                    </div>
                    <div class="form-group col-4 h-100">
                      <label for="ccyear">Year</label>
                      <select class="form-control" id="ccyear" required="true">
                        <option selected>2022</option>
                        <option>2023</option>
                        <option>2024</option>
                        <option>2025</option>
                        <option>2026</option>
                        <option>2027</option>
                        <option>2028</option>
                        <option>2029</option>
                        <option>2030</option>
                        <option>2031</option>
                        <option>2032</option>
                        <option>2033</option>
                        <option>2034</option>
                        <option>2035</option>
                        <option>2036</option>
                      </select>
                    </div>
                    <div class="col-sm-4">
                      <div class="form-group">
                        <label for="cvv">CVV/CVC</label>
                        <input class="form-control" id="cvv" type="password" minlength="3" maxlength="3"
                          placeholder="***" required="true">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-12">
                      <div class="form-group">
                        <label for="ccnumber">Card Holder Name</label>
                        <div class="input-group">
                          <div class="input-group-append">
                            <span class="input-group-text">
                              <i class="mdi mdi-account"></i>
                            </span>
                          </div>
                          <input class="form-control" type="text" placeholder="Name in Card" required="true">
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="card-footer">
                  <div class="row d-flex justify-content-between align-items-baseline">
                    <button class="btn btn-danger" type="reset">Reset</button>
                    <h4 class="price">Total : $<strong>${totalAmount}</strong></h4>
                    <a href="<c:url value="/order/pay"/>"><button type="submit" class="btn btn-primary"> PAY </button></a>
                  </div>
                </div>
              </div>
            </form>

          </div>
        </div>
      </div>

  </body>

</html>