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


<link rel="stylesheet"  href="css/entryform.css"><link>
<link rel="stylesheet"  href="css/idbi_flex.css"><link>

<link rel="stylesheet"  href="css/otp.css"><link> 
<style>
.democlass
{
background-color: #165b46;
}
.demo2class{
margin-bottom: -1pt;
    padding: 10px;
   /*  background: #3977b7; */
    border-bottom: 1px solid #eee;
    background-image: linear-gradient(to right bottom,#ffffff25,#ffffff00,#8d8d8d25,#00000033,#00000050);
    border-radius: 6px 6px 0 0;
    border: 1px solid black;
    }
    .center {
  margin: auto;
   width: 95%;
   height:100%; 
  
/*  padding: 10px; */
}
.grad1 {
/*   height: 200px; */
  background-color: red; /* For browsers that do not support gradients */
  background-image: linear-gradient(to right,red ,yellow);
}
</style>
</head>

 <body>

<%String reqType = (String) request.getAttribute("state"); 

%> 

 <div id="idbi_flex" >
    <div id="top_div_part1" ><a href="#"><img src="images/logo/idbi-bank-top.gif" alt="Home" width="229" height="45" border="0"></a></div>
 </div>
 <div class="center">
    <div id="login" class="democlass demo2class">
 <!--        <h3 class="text-center text-white pt-5">Login form</h3> -->
        <div class="container">
        
        
            <div id="login-row" class=" row justify-content-center align-items-center" style='margin:auto !important'>
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="OTPValidator" method="post">
                            <h2 class="text-center text-info" style="font-size:25px;">e Mandate registration for SRA Loan Account</h2>

				<div class="form-group" id="generate-otp">						
						<label for="otp-div">OTP *</label>
						<div class="mb-6 text-center" id="otp-div">
						
						  <div id="otp" class="flex justify-left">
						    <input   name="otp_v1" class="m-2 text-center form-control form-control-solid rounded focus:border-blue-400 focus:shadow-outline" type="text" id="first" maxlength="1" />
						    <input   name="otp_v2"  class="m-2 text-center form-control form-control-solid rounded focus:border-blue-400 focus:shadow-outline" type="text" id="second" maxlength="1" />
						    <input   name="otp_v3" class="m-2 text-center form-control form-control-solid rounded focus:border-blue-400 focus:shadow-outline" type="text" id="third" maxlength="1" />
						    <input   name="otp_v4" class="m-2 text-center form-control form-control-solid rounded focus:border-blue-400 focus:shadow-outline" type="text" id="fourth" maxlength="1" />
						    <input   name="otp_v5" class="m-2 text-center form-control form-control-solid rounded focus:border-blue-400 focus:shadow-outline" type="text" id="fifth" maxlength="1" />
						    <input   name="otp_v6" class="m-2 text-center form-control form-control-solid rounded focus:border-blue-400 focus:shadow-outline" type="text" id="sixth" maxlength="1" />
						  	
						  	
						  
						  </div>
						  
						</div>
						<div>
						<span id="otpsent_status">An  OTP has been sent to the registered mobile number ending with 
						******<%=request.getAttribute("mobileNumberPart") %>. This OTP will be valid for 180 seconds.</span>
						<%if(reqType.equals("W")){ %>
						<br><span id="wmsg">Wrong OTP !! &nbsp;&nbsp;&nbsp;&nbsp;Try again.</span>
						<% }else{%>
						<span id="wmsg"></span>
						<%} %>
						</div>
						<br>
						
						  	<label>If not recieved  &nbsp;&nbsp;</label>
						  	<input type="button" class="btn btn-default"  id="resendOTP" value="Resend OTP"/>

						</div>

						
  								<input type="text" id="mobileNumber" name="mobileNumber" value="<%= request.getAttribute("mobileNumber") %>" style="display:none;" >
  								<input type="text" id="loan_ref" name="loan_ref" value="<%= request.getAttribute("loan_ref") %>" style="display:none;" >
  								<input type="text" id="sessionPID" name="sessionPID" value="<%= request.getAttribute("sessionPID") %>" style="display:none;" >

	    	
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <script>
	function OTPInput() {
		  const inputs = document.querySelectorAll('#otp > *[id]');
		  for (let i = 0; i < inputs.length; i++) {
		    inputs[i].addEventListener('keydown', function(event) {
		      if (event.key === "Backspace") {
		        inputs[i].value = '';
		        if (i !== 0)
		          inputs[i - 1].focus();
		      } else {
		        if (i === inputs.length - 1 && inputs[i].value !== '') {
		          return true;
		        } else if (event.keyCode > 47 && event.keyCode < 58) {
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
    $("#resendOTP").click(function(){
    	alert("test")
		console.log("test");
    	$("#otpsent_status").text("sending SMS......!") ;
    	var data = {
    			
    	    flag: "reSend",
    	    oldValue: ""
    	};

    	$.ajax({
    	    type: "POST",
    	    url: "ResedOTPGenerator",
    	    contentType: "application/json", // NOT dataType!
    	    data: JSON.stringify(data),
    	    success: function(response) {
    	        console.log(response);
    	    	$("#otpsent_status").text("An  OTP has been sent to the registered mobile number ending with ******"+response+". This OTP will be valid for 180 seconds.") ;
    	    	$("#wmsg").text("") ;

    	    }
    	});
    	});    
    </script>
</body>
</html>