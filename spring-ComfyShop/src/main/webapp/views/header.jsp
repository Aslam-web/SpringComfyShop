<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />

    <!-- BOOTSTRAP START -->
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />
    <!-- BOOTSTRAP END -->

    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <title>Header Element</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">ComfyShop</a>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <!-- <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a> -->
            <a class="nav-link" href="<c:url value='/login'/>">Login</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<c:url value='/register'/>">Register</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<c:url value='/product/list'/>"
              >Products</a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<c:url value='/product/manage'/>">Manage Products</a>
          </li>
        </ul>
        <div class="form-inline">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <a class="nav-link" href="<c:url value='/cart'/>">Cart</a>
            </li>
          </ul>
          <a class="btn btn-danger" href="<c:url value="/logout"/>">Logout</a>
        </div>
      </div>
    </nav>
  </body>
</html>