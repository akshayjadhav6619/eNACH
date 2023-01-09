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
<link rel="stylesheet"  href="css/otp.css"><link>
<style>
.btn_start_color{

    color: #fff;
    background-color: #007bff;
    border-color: #007bff;
    
    }
  .btn_secondary_color{
    
    color:white;
    background-color:#03a791;
    border-color:#03a791;
    
    }
  .btn_format{
    
    border-radius:50px !important;
    margin-right:15px;
    width:120px;
   background-color: yellow;
    
    }

   resendOTP:hover  {
  background-color: yellow;
}
</style>

</head>

<body>
<%String reqType = (String) request.getAttribute("state"); 

%> 

    <div class="container-fluid">
        <div class="container"> 
            <div class="col-xl-10 col-lg-11 login-container">
                <div class="row">
                    <div class="col-lg-7 img-box">
                        <img src="assets/images/login-banner.png" alt="">
                    </div>
                    <div class="col-lg-5 no-padding">
                        <div class="login-box">
                        <form id="login-form" class="form" action="OTPValidator" method="post">
                            <h5>eMandate registration for     SRA Loan Account
                            </h5>

                            <div class="login-row row no-margin">
                             <label for=""><i class="fa money-bag"></i> OTP*</label>
                            <div class="mb-6 text-center" id="otp-div">
						    <div id="otp" class="flex justify-left">
						    <input   name="otp_v1" class="m-2 text-center form-control form-control-solid rounded focus:border-blue-400 focus:shadow-outline" style="border-color:#b6b6b6 ;border:solid 1px" type="text" id="first" maxlength="1" />
						    <input   name="otp_v2"  class="m-2 text-center form-control form-control-solid rounded focus:border-blue-400 focus:shadow-outline"   style="border-color:#b6b6b6 ;border:solid 1px" type="text" id="second" maxlength="1" />
						    <input   name="otp_v3" class="m-2 text-center form-control form-control-solid rounded focus:border-blue-400 focus:shadow-outline"  style="border-color:#b6b6b6 ;border:solid 1px" type="text" id="third" maxlength="1" />
						    <input   name="otp_v4" class="m-2 text-center form-control form-control-solid rounded focus:border-blue-400 focus:shadow-outline"  style="border-color:#b6b6b6 ;border:solid 1px" type="text" id="fourth" maxlength="1" />
						    <input   name="otp_v5" class="m-2 text-center form-control form-control-solid rounded focus:border-blue-400 focus:shadow-outline"  style="border-color:#b6b6b6 ;border:solid 1px" type="text" id="fifth" maxlength="1" />
						    <input   name="otp_v6" class="m-2 text-center form-control form-control-solid rounded focus:border-blue-400 focus:shadow-outline"  style="border-color:#b6b6b6 ;border:solid 1px" type="text" id="sixth" maxlength="1" />
						  <input type="hidden" name="mobilepartid" id="mobilepartid">
						  </div>
						  
						</div>
                                <!-- <input type="text" class="form-control form-control-sm" name="otp_v1" id="otp_v1"> -->
                            </div>
                            <div class="login-row row no-margin" id="otpsent_status" style="margin-top:0px !important">
                            <%if(request.getAttribute("mobileNumberPart")!=null){ %>
                            An  OTP has been sent to the registered mobile number ending with 
						******<%=request.getAttribute("mobileNumberPart") %>. This OTP will be valid for 180 seconds.
						<% }%>
                            </div>
                            	<%if(reqType.equals("W")){ %>
						<br><div id="wmsg" style="font-color:red">Wrong OTP !! &nbsp;&nbsp;&nbsp;&nbsp;Try again.</div>
						<% }else{%>
						<div id="wmsg"></div>
						<%} %>
                            
							
							<div class="login-row btnroo row no-margin" >
                                if not recieved &nbsp;&nbsp;&nbsp; <input type="button" class='btn_format' style=" background-color: #03a791 !important ;  border-color: #03a791 !important;  color:white !important" id="resendOTP" value="Resend OTP" onclick="ResendOtp()"  >
                               
                            </div>
                         
                                <input type="text" id="mobileNumber" name="mobileNumber" value="<%= request.getAttribute("mobileNumber") %>" style="display:none;" >
  								<input type="text" id="loan_ref" name="loan_ref" value="<%= request.getAttribute("loan_ref") %>" style="display:none;" >
  								<input type="text" id="sessionPID" name="sessionPID" value="<%= request.getAttribute("sessionPID") %>" style="display:none;" >

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

	  
 function ResendOtp(){
	
	 
		var mobileNumber=$("#mobileNumber").val();
	    var loanRefNumber=$("#loan_ref").val();
	    var sessionPID= $("#sessionPID").val();
		var ctrx='<%=request.getContextPath()%>';
	    document.getElementById("otpsent_status").innerHTML = "An OTP has been sent to the registered ";
	    	
	    	var data = {
	    			
	    			
	    	    flag: "reSend",
	    	    oldValue: ""
	    	};

	    	$.ajax({
	    	    type: "GET",
	    	    url: ctrx+"/ResedOTPGenerator?mobileNumber="+mobileNumber+"&&loanRefNumber="+loanRefNumber+"&&sessionPID="+sessionPID,
	    	    contentType: "application/json", // NOT dataType!
	    	    async : true,
	    	    data: JSON.stringify(data),
	    	    success: function(response) {
	    	        document.getElementById("otpsent_status").innerHTML = "An OTP has been sent to the registered mobile number ending with ******"+response+". This OTP will be valid for 180 seconds." ;
	    	        document.getElementById("wmsg").innerHTML = "";
	    	    }
	    	});
	    

	 }
	 
	 

	    </script>
	    <script>
	function OTPInput() {
		  const inputs = document.querySelectorAll('#otp > *[id]');
		  //alert(inputs)
		  
		  for ( i = 0; i < inputs.length; i++) {
			  
			  
		    inputs[i].addEventListener('keydown', function(event) {
		      if (event.key === "Backspace") {
		        inputs[i].value = '';
		        if (i !== 0)
		          inputs[i - 1].focus();
		      } else {
		        if (i === inputs.length - 1 && inputs[i].value !== '') {
		          return true;
		        } else if (event.keyCode > 47 && event.keyCode < 58 ||(event.keyCode > 95 && event.keyCode < 106) ) {
		          inputs[i].value = event.key;
		          if (i !== inputs.length - 1)
		            inputs[i + 1].focus();
		          event.preventDefault();
		        } else if (event.keyCode > 64 && event.keyCode < 91) {
		          inputs[i].value = String.fromCharCode(event.keyCode);
		          if (i !== inputs.length - 1)
		            inputs[i + 1].focus();
		          event.preventDefault();
		        }
		      }
		    });
		  }
		}
		OTPInput();
    </script>
    

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
