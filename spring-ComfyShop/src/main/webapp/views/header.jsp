<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	 <link
      href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
      rel="stylesheet"
      id="bootstrap-css"
    />
	<!-- <link
      href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
      rel="stylesheet"
      id="bootstrap-css"
    />
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->
<title>Insert title here</title>
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
              <a class="nav-link" href="<c:url value='/products'/>">Products</a>
            </li>
          </ul>
          <form:form action="logout" class="form-inline">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <a class="nav-link" href="<c:url value='/cart'/>">Cart</a>
            </li>
          </ul>
            <input type="submit" class="btn btn-danger" value="Logout"/>
          </form:form>
        </div>
      </nav>
      
</body>
</html>