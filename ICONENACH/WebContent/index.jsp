<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>IDBI-ENACH</title>
    <link rel="shortcut icon" href="assets/images/fav.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,400,600,700" rel="stylesheet">
    <link rel="shortcut icon" href="assets/images/fav.jpg">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/fontawsom-all.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css" />
	 <link rel="stylesheet" type="text/css" href="css/login.css" />
    <script src='https://www.google.com/recaptcha/api.js'></script>

</head>

<body>


    <div class="container-fluid">
        <div class="container">
            <div class="col-xl-10 col-lg-11 login-container">
                <div class="row">
                    <div class="col-lg-7 img-box">
                        <img src="assets/images/login-banner.png" alt="">
                    </div>
                    <div class="col-lg-5 no-padding">
                        <div class="login-box">
                        <form id="login-form" class="form" action="RefValidator" method="post">
                            <h5>Welcome to IDBI Bank's eNach Mandate Portal</h5>

                            <div class="login-row row no-margin">
                                <label for=""><i class="fa money-bag"></i> Loan/Application Numaber:</label>
                                <input type="text" name="loan_ref" id="loan_ref" class="form-control form-control-sm">
                            </div>

                             <div class="login-row row no-margin" >
                              <div class="g-recaptcha" data-sitekey="6LfKURIUAAAAAO50vlwWZkyK_G2ywqE52NU7YO0S" data-callback="verifyRecaptchaCallback" data-expired-callback="expiredRecaptchaCallback"></div>
                            <input form="test" name="check_box" class="form-control d-none" data-recaptcha="true" required data-error="Please complete the Captcha">
                            <div class="help-block with-errors"></div> 
                            </div>

                            

                             <div class="login-row btnroo row no-margin">
                               <button class="btn btn-primary btn-sm" name="submit" id="submit" onclick="submitform()">Submit </button>
                               
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script>
function submitform()
{
	 $( "#submit" ).submit();
	
	}

</script>

    <script src="assets/js/jquery-3.2.1.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="assets/js/script.js"></script>
</html>

