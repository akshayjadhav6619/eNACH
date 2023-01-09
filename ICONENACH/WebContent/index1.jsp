<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IDBI-ENACH</title>


<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
    <script src='https://www.google.com/recaptcha/api.js'></script>
    

<script src="script/lib/jquery.validate.min.js"></script>
<link rel="stylesheet"  href="css/entryform.css"><link>
<link rel="stylesheet"  href="css/idbi_flex.css"><link>
<script src="script/login.js"></script>

</head>

 <body style='background-color:#4fa9a7'>
 <div id="idbi_flex_head">
    <div id="top_div_part0" style="height:30px;"><span >&nbsp;&nbsp;Welcome to IDBI Bank's e NACH Mandate Portal</span></div>
 </div>
 
 <div id="idbi_flex">
    <div id="top_div_part1" ><a href="#"><img src="images/logo/idbi-bank-top.gif" alt="Home" width="229" height="45" border="0"></a>
    <a href="#"><img
					src="images/logo/logo_enach.gif" alt="Home" width="180" height="30"
					border="0"></a>
					</div>
 </div>

    <div id="login">
 <!--        <h3 class="text-center text-white pt-5">Login form</h3> -->
        <div class="container">
        
        
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="RefValidator" method="post">
                            <h3 class="text-center text-info">Welcome to IDBI Bank's eNACH Mandate Portal</h3>
                            <hr>
                            <div class="form-group">
                                <label for="loan_ref" class="text-info">Loan/Application Number:</label><br>
                                <input type="text" name="loan_ref" id="loan_ref" class="form-control">
                            </div>
								<!--                             <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br> -->
                          <div class="form-group">
          					<!--                 <div class="g-recaptcha"
							data-sitekey="6LdMAgMTAAAAAGYY5PEQeW7b3L3tqACmUcU6alQf"></div> -->
                           <div class="g-recaptcha" data-sitekey="6LfKURIUAAAAAO50vlwWZkyK_G2ywqE52NU7YO0S" data-callback="verifyRecaptchaCallback" data-expired-callback="expiredRecaptchaCallback"></div>
                            <input form="test" name="check_box" class="form-control d-none" data-recaptcha="true" required data-error="Please complete the Captcha">
                            <div class="help-block with-errors"></div> 
                        </div>
  
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</body>
</html>