<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Registration Page</title>
  </head>
  
  <body>

<%@ include file="../header.jsp" %>

    <div class="container" style="margin-top: 80px">
      <div class="row justify-content-center">
        
        <div class="col-md-8 col-md-offset-2">
          <div class="card">
            <div class="card-header">
              <strong>REGISTRATION FORM</strong>
            </div>
            <div class="card-body">
              <form:form class="col-md-12" method="post" action="register" modelAttribute="user">
                <!-- EMAIL -->
                <div class="form-group">
                  <label for="email" class="control-label">Your Email</label>
                  <div class="cols-sm-10">
                    <div class="input-group">
                      <span class="input-group-addon"></span>
                      <input
                        type="email"
                        class="form-control"
                        name="email"
                        id="email"
                        placeholder="Enter your Email"
                        required="true"
                        autofocus="true"
                      />
                    </div>
                  </div>
                </div>
                <!-- PASSWORD -->
                <div class="form-group">
                  <label for="password" class="cols-sm-2 control-label"
                    >Password</label
                  >
                  <div class="cols-sm-10">
                    <div class="input-group">
                      <span class="input-group-addon"></span>
                      <input
                        type="password"
                        class="form-control"
                        name="password"
                        id="password"
                        placeholder="Enter your Password"
                        required="true"
                      />
                    </div>
                  </div>
                </div>
                <!-- NAME -->
                <div class="form-group">
                  <label for="name" class="cols-sm-2 control-label"
                    >Your Name</label
                  >
                  <div class="cols-sm-10">
                    <div class="input-group">
                      <span class="input-group-addon"></span>
                      <input
                        type="text"
                        class="form-control"
                        name="name"
                        id="name"
                        placeholder="Enter your Name"
                        required="true"
                      />
                    </div>
                  </div>
                </div>
                <!-- ROLE -->
                <div class="form-group">
                  <span class="input-group-addon"></span>
                  <div class="cols-sm-10">
                    <div class="input-group">
                      <span class="input-group-addon"
                        ><i class="fa fa-user fa" aria-hidden="true"></i
                      ></span>
                      <input
                        type="text"
                        class="form-control"
                        name="role"
                        id="role"
                        value="ROLE_USER"
                        disabled="disabled"
                      />
                    </div>
                  </div>
                </div>
                <!-- ADDRESS -->
                <div class="form-group">
                  <label for="confirm" class="cols-sm-2 control-label"
                    >Your Address</label
                  >
                  <div class="cols-sm-10">
                    <div class="input-group">
                      <span class="input-group-addon"></span>
                      <input
                        type="text"
                        class="form-control"
                        name="address"
                        id="address"
                        placeholder="XYZ street, LA, USA"
                        required="true"
                      />
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <button
                    type="submit"
                    class="btn btn-primary btn-lg btn-block login-button"
                  >
                    Register
                  </button>
                </div>
                <div class="login-register">
                  Already a member? <a href="<c:url value='/login'/>">Login here</a>
                </div>
              </form:form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
