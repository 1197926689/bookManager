<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <%@page contentType="text/html;charset=utf-8" language="java" %>
	<meta http-equiv=”Content-Type” content=”text/html; charset=utf-8″>	
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="assets/img/logo-fav.png">
    <title>LG书店</title>
    <link rel="stylesheet" type="text/css" href="assets/lib/perfect-scrollbar/css/perfect-scrollbar.min.css"/>
    <link rel="stylesheet" type="text/css" href="assets/lib/material-design-icons/css/material-design-iconic-font.min.css"/><!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="assets/css/app.css" type="text/css"/>
  </head>
  <body class="be-splash-screen">
    <div class="be-wrapper be-login">
      <div class="be-content">
        <div class="main-content container-fluid">
          <div class="splash-container">
            <div class="card card-border-color card-border-color-primary">
              <div class="card-header"><h1>LG书店</h1><span class="splash-description">Please enter your user information.</span></div>
              <div class="card-body">
                <form action="LoginServlet" method="post">
                  <div class="form-group">
                    <input id="username" type="text" name="name" placeholder="Readername" autocomplete="off" class="form-control">
                  </div>
                  <div class="form-group">
                    <input id="password" type="password" name="password" placeholder="Password" class="form-control">
                  </div>
                  <div class="form-group row login-tools">
                    <div class="col-6 login-remember">
                      <label class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input"><span class="custom-control-label">Remember Me</span>
                      </label>
                    </div>
                    <!-- <div class="col-6 login-forgot-password"><a href="">Forgot Password?</a></div> -->
                  </div>
                  <div class="form-group login-submit">
                    <button data-dismiss="modal" type="submit" class="btn btn-primary btn-xl">Sign me in</button>
                  </div>
                </form>
              </div>
            </div>
            <div class="splash-footer"><span>Don't have an account? <a href="index/signup.jsp">Sign Up</a></span></div>
          </div>
        </div>
      </div>
    </div>
    <script src="assets/lib/jquery/jquery.min.js" type="text/javascript"></script>
    <script src="assets/lib/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
    <script src="assets/lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script src="assets/js/app.js" type="text/javascript"></script>
    <script type="text/javascript">
      $(document).ready(function(){
      	//initialize the javascript
      	App.init();
      });
      
    </script>
  </body>
</html>