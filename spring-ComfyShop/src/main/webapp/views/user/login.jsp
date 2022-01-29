<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Login Page</title>
  </head>
  
  <body>
    
	<%@ include file="../header.jsp" %>

    <div class="container" style="margin-top:80px">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <div class="card">
            <div class="card-header">
              <strong> SIGN IN TO CONTINUE</strong>
            </div>
            <div class="card-body">
                <form:form action="login" method="post" modelAttribute="user">
                <fieldset>
                  <div class="row justify-content-center">
                    <div class="col-md-10">
                      <div class="form-group">
                        <div class="input-group">
                          <span class="input-group-addon">
                            <i class="glyphicon glyphicon-user"></i>
                          </span>
                          <form:input class="form-control" placeholder="example@gmail.com" type="email" path="email" required="true"/>
                        </div>
                        <p class="text-center text-danger"><form:errors path="email"></form:errors></p>
                      </div>
                      <div class="form-group">
                        <div class="input-group">
                          <span class="input-group-addon">
                            <i class="glyphicon glyphicon-lock"></i>
                          </span>
                          <form:input class="form-control" placeholder="********" type="password" path="password" required="true"/>
                        </div>
                        <p class="text-center text-danger"><form:errors path="password"></form:errors></p>
                      </div>
                      <div class="form-group">
                        <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in"/>
                      </div>
                    </div>
                  </div>
                </fieldset>
              </form:form>
            </div>
            <div class="card-footer ">
              Don't have an account? <a href="<c:url value='/register'/>">Sign Up here</a>
            </div>
           </div>
        </div>
      </div>
    </div>

  </body>
</html>