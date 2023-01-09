<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//D cvTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>response</title>
<style>
	.bs-example{
    	margin: 20px;
    }
</style>

<style>

html,body {
    font-family: 'Raleway', sans-serif;  
}
.thankyou-page ._header {
    background: #fee028;
    padding: 100px 30px;
    text-align: center;
    background: #ADD8E6 url(https://codexcourier.com/images/main_page.jpg) center/cover no-repeat;
}
.thankyou-page ._header .logo {
    max-width: 600px;
    margin: 0 auto 50px;
}
.thankyou-page ._header .logo img {
    width: 100%;
}
.thankyou-page ._header h1 {
    font-size: 65px;
    font-weight: 800;
    color: Green;
    margin: 0;
}
.thankyou-page ._body {
    margin: -70px 0 30px;
}
.thankyou-page ._body ._box {
    margin: auto;
    max-width: 80%;
    padding: 50px;
    background: white;
    border-radius: 3px;
    box-shadow: 0 0 35px rgba(10, 10, 10,0.12);
    -moz-box-shadow: 0 0 35px rgba(10, 10, 10,0.12);
    -webkit-box-shadow: 0 0 35px rgba(10, 10, 10,0.12);
}

.thankyou-page ._body ._box h1 {
    font-size: 65px;
    font-weight: 800;
    color: Green;
    margin: 0;
}
.thankyou-page ._body ._box h2 {
    font-size: 32px;
    font-weight: 600;
    color: #4ab74a;
}
.thankyou-page ._footer {
    text-align: center;
    padding: 50px 30px;
}

.thankyou-page ._footer .btn {
    background: #4ab74a;
    color: white;
    border: 0;
    font-size: 14px;
    font-weight: 600;
    border-radius: 0;
    letter-spacing: 0.8px;
    padding: 20px 33px;
    text-transform: uppercase;
}
</style>





</head>
<%
//String ResponseData=request.getParameter("msg");
String ResponseData="0398|success|NA|EN0202202210|9460|1700025768|5.00|{itc:~mandateData{UMRNNumber:ICIC7010202220010762~IFSCCode:ICIC0007275~amount_type:M~frequency:MNTH~account_number:156901001305~expiry_date:10-12-2099~ifsc_code:~amount:100~identifier:~schedule_date:10-03-2022~debitDay:~debitFlag:N~aadharNo:~accountHolderName:Pawan Upadhyay~accountType:Saving~dateOfBirth:~mandatePurpose:~utilityNo:~helpdeskNo:~helpdeskEmail:~pan:~phoneNumber:~emailID:}}{mob:9979871199}|02-02-2022 15:33:11|NA|||573058dcab3a4f05a33807dbba749931|933895573|d2e2d508-387a-446f-951d-650cbb862b1d|a228a12069156a83e2d9bf3c4da2180d663ecdd357b65f507334f75fd8254008";
String ResponseDetails[]=ResponseData.split("\\|",-1);
String MandateDetails=ResponseDetails[7].split("mandateData")[1];
String MandateDetailsARR[]=MandateDetails.split("\\{")[1].split("\\~");
String MandateDetailsKeyValueArr[]=MandateDetailsARR[0].split("\\:");
String MandateDetailsKey=MandateDetailsKeyValueArr[0];
String MandateDetailsValue=MandateDetailsKeyValueArr.length>1?MandateDetailsKeyValueArr[1].replaceAll("}", ""):"";%>
<body>
<div class="container">

<div class="thankyou-page">
    <div class="_header">
        <div class="logo">
            <img src="assets/images/Logo.png" alt="">
        </div>
    </div>
<%if(ResponseData.split("\\|")[0].equals("0300"))
 {
%>
<div class="_body">
        <div class="_box">
                           <h1>Mandate Registered Succesfully!</h1>

            <h2>
                <strong>Mandate Registration Id:<%=ResponseData.split("\\|")[3]%>.</strong>
                <br>
                <strong>UMRN: <%=MandateDetailsValue%></strong>
            </h2>
            <p>
              Thanks for being you.
            </p>
        </div>
    </div>

  <%}
  
if(ResponseData.split("\\|")[0].equals("0398"))
 {
%>
 
  
  
  
  
  <div class="_body">
        <div class="_box">
                           <h1><%=ResponseData.split("\\|")[1]%></h1>

            <h2>
                <strong>Mandate Registration Id:<%=ResponseData.split("\\|")[3]%>.</strong>
                <br>
            </h2>
            <p>
              Thanks for being you.
            </p>
        </div>
    </div>
  
  
  
  
  <%}
 
  if(ResponseData.split("\\|")[0].equals("0399"))
  {
%>
   <div class="alert alert-danger">
     <strong><%=ResponseData.split("\\|")[1]%>...!</strong> <%=ResponseData.split("\\|")[2]%>.
   </div>
   <%} 

  if(ResponseData.split("\\|")[0].equals("0392"))
 {
%>
  <div class="alert alert-danger">
    <strong><%=ResponseData.split("\\|")[1]%>....!</strong> <%=ResponseData.split("\\|")[2]%>.
  </div>
  <%}
  
if(ResponseData.split("\\|")[0].equals("0396"))
 {
%>
  <div class="alert alert-primary">
    <strong><%=ResponseData.split("\\|")[1]%>...!</strong> <%=ResponseData.split("\\|")[2]%>.
  </div>
 <%} %>

</div>
</div>


<script>

function InsertResponseData(ResponseString){
	
	var ctrx='<%=request.getContextPath()%>';
	
$.ajax({
	
	 type: "GET",
	    url: ctrx+"/ResponseStoreController?responseString="+ResponseString,
	    contentType: "application/json", // NOT dataType!
	    async : false,
	    success: function(response) {
  
}
	
});
 }
</script>
</body>
</html>