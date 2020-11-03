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
    <div class="be-wrapper be-login be-signup">
      <div class="be-content">
        <div class="main-content container-fluid">
          <div class="splash-container sign-up">
            <div class="card card-border-color card-border-color-primary">
              <div class="card-header"><h1>LG书店</h1><span class="splash-description">Please enter your user information.</span></div>
              <div class="card-body">
                <form action="../SignServlet" method="post"><span class="splash-title pb-4">Sign Up</span>
                  <div class="form-group">
                    <input type="text" name="name" required="" placeholder="Readername" autocomplete="off" class="form-control">
                  </div>
                  <div class="form-group">
                    <input id="pass1" type="password" name="password" required="" placeholder="Password" autocomplete="off" class="form-control">
                  </div>
                    <div class="form-group">
                      <input  type="text" name="phone" required="" placeholder="Phone" class="form-control">
                    </div>
                    <div class="form-check form-check-inline">
                          <label class="custom-control custom-radio custom-radio-icon custom-control-inline">
                            <input id="radioIcon1" type="radio" name="sex" checked="" class="custom-control-input" value="female"><span class="custom-control-label"><i class="mdi mdi-female"></i></span>
                          </label>
                          <label class="custom-control custom-radio custom-radio-icon custom-control-inline">
                            <input id="radioIcon2" type="radio" name="sex" class="custom-control-input" value="male"><span class="custom-control-label"><i class="mdi mdi-male-alt"></i></span>
                          </label>
                        </div>
                  <div class="form-group pt-2">
                    <button type="submit" class="btn btn-block btn-primary btn-xl">Sign Up</button>
                  </div>
                </form>
              </div>
            </div>
            <div class="splash-footer">&copy; 2020 WHLG</div>
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