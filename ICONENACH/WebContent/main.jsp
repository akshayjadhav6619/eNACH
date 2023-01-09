<%@page import="java.util.ArrayList"%>
<%@page import="com.intech.lem.service.ListService"%>
<%@page import="java.util.Map"%>
<%@page import="com.intech.lem.service.ApplicationDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link rel="stylesheet" 
  href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  
  <style>
  .btn_format{
    
    border-radius:50px !important;
    margin-right:15px;
    width:120px;
    background-color: #03a791 !important ;
    border-color: #03a791 !important;
    color:white !important";
    
    }
    
table {
  display:block;
  overflow:auto;
  max-height:25%
}
  
  
  </style>

<script>

  function disableSubmit() {
	  
	  alert(document.getElementById("terms").checked);
	  document.getElementById("terms").checked=false;
	  document.getElementById("submit").disabled = true;
	  alert(document.getElementById("terms").checked);
	
	 }
	 

	  function activateButton(element) {

	      if(element.checked) {
	        document.getElementById("submit").disabled = false;
	       }
	       else  {
	        document.getElementById("submit").disabled = true;
	      }

	  }
</script>

</head>


<body onload="disableSubmit()">
	<%
	ApplicationDetails appDetails = new ApplicationDetails();
 	Map<String,String> mapData = appDetails.getAppDetailsById((String)request.getAttribute("loan_ref"));
 	%>
<!-- Header and text -->
<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand">
    <img src="assets/images/Logo.png" class="d-inline-block align-top" alt="">
   
  </a>
</nav>
   <div class="container-fluid" >
        <div class="container">
<form action="getSave" method="post" class="form-signin" >
    
        <div class="container-fluid" style="height: 50%;overflow-y:auto"  >
        <div class="container">
            <div class="col-xl-10 col-lg-11 login-container">
			<br>			
			<h3 style='margin-bottom:0px !important'>Mandate Ragistration </h3><br>
			<div class="table-responsive">
                <table class="table" >

  <thead>
    <tr class="table-success">
      <th scope="col" colspan="4"><h5>Customer Details</h5></th>
    </tr>
  </thead>
  <tbody >
    <tr>
      <th scope="row">Application Ref ID:. </th>
      <td><span><%=mapData.get("APP_NO")!=null?mapData.get("APP_NO"):""%></span>
		<input id="text_field" type="text" name="ref_no" value="<%=session.getAttribute("REF")%>" style="display:none">
       </td>
      <td>Name:</td>
      <td><%
    	if(mapData.get("PERAPP_FNAME")!=null && !mapData.get("PERAPP_FNAME").equals(""))
    	{
    							%>
	        <span><%=mapData.get("PERAPP_FNAME")%></span>
												<%}else{ %>

												<input type="text" name="acc_holder_name" id="acc_holder_name"
													class="form-control" >
												<%} %> </td>
    </tr>
    <tr>
      <th scope="row">Mobile Number: </th>
      <td>	<%
    						if(mapData.get("PERAPP_MOBILE")!=null && !mapData.get("PERAPP_MOBILE").equals(""))
    						{
    							%>
												<span><%=mapData.get("PERAPP_MOBILE")%></span>
												<%}else{ %>

												<input type="text" name="mobile" id="mobile"
													class="form-control" >
												<%} %>
												<input id="text_field" type="text" name="tel_num" value="<%=mapData.get("PERAPP_PHONE")!=null?mapData.get("PERAPP_PHONE"):""%>" style="display:none;">
												<input id="text_field" type="text" name="cust_additional_details" value="<%=mapData.get("PERAPP_ADDRESS1")!=null?mapData.get("PERAPP_ADDRESS1"):""%>" style="display:none;">
												<input id="text_field" type="text" name="utility_code" style="display:none;"></td>
      <td>Email ID: </td>
      <td><%
    						if(mapData.get("PERAPP_EMAIL")!=null && !mapData.get("PERAPP_EMAIL").equals(""))
    						{
    							%>
												<span><%=mapData.get("PERAPP_EMAIL")%></span>
												<%}else{ %>

												<input type="text" name="email" id="email"
													class="form-control">
												<%} %></td>
    </tr>
    <tr>
      <th scope="row">Sanctioned Amount: </th>
      <td><%
    						if(mapData.get("LOAN_AMT")!=null && !mapData.get("LOAN_AMT").equals(""))
    						{
    							%>
												<span><%=mapData.get("LOAN_AMT")%></span>
												<%}else{ %>

												<input type="text" name="loan_amount" id="loan_amount"
													class="form-control" >
												<%} %></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr class="table-success collapsed">
      <th scope="col" colspan="4"><h5>Mandate Details</h5></th>
    </tr>
    <tr>
      <th scope="row">Start Date:</th>
      <td>	<%
    								if(mapData.get("START_DATE")!=null && !mapData.get("START_DATE").equals(""))
    									{%>										    							
										<span><%=mapData.get("START_DATE")%></span>
										<%}else{ %>
										<input type="text"  class="form-control" id="start_date" name="start_date">
										<%} %>
									
									
								<input type="text" id="mobileNumber" name="mobileNumber" value="<%= request.getAttribute("mobileNumber") %>" style="display:none;" >
  								<input type="text" id="loan_ref" name="loan_ref" value="<%= request.getAttribute("loan_ref") %>" style="display:none;" >
  								<input type="text" id="sessionPID" name="sessionPID" value="<%= request.getAttribute("sessionPID") %>" style="display:none;" >
									</td>
      <td>End Date:</td>
      <td>Valid Until Cancelled </td>
    </tr>
    <tr>
      <th scope="row">EMI Amount: </th>
      <td><%
    											if(mapData.get("LOAN_EMI")!=null && !mapData.get("LOAN_EMI").equals(""))
    											{
    											%>
												<span><%=mapData.get("LOAN_EMI")%></span>
												<%}else{ %>
												<input id="amount" type="text" name="amount" >
												<%} %>
		</td>
      <td>Maximum Mandate Amount: </td>
      <td><%
    											if(mapData.get("LOAN_EMI_NEAREST_1000")!=null && !mapData.get("LOAN_EMI_NEAREST_1000").equals(""))
    											{
    											%>
												<span><%=mapData.get("LOAN_EMI_NEAREST_1000")%></span>
<!-- 												<input id="Maximum_Mandate_amount" type="text" name="Maximum_Mandate_amount"  class="form-control"  style ='padding:0px !important;margin-bottom:0px !important' value="<%=mapData.get("LOAN_EMI_NEAREST_1000")%>" -->
												
												<%}else{ %>
												<input id="Maximum_Mandate_amount" type="text" name="Maximum_Mandate_amount"  class="form-control">
												<%} %>
												<input id="text_field" type="text" name="pan" value="-" style="display:none">
											    <input id="text_field" type="text" name="consumerID" value="11111" style="display:none">
									
</td>
    </tr>
    <tr>
      <th scope="row">EMI Collection Frequency:</th>
      <td>Monthly</td>
      <td>Debit Type:</td>
      <td>Maximum Amount</td>
    </tr>
    <tr>
    <th scope="col" colspan="4">
    <div class="form-check">
	<input  class="form-check-input"   type="checkbox" name="terms" id="terms" onchange="activateButton(this)" id="terms"> 
	 <label  class="form-check-label" for="inputPassword3" >I Agree Terms & Coditions</label>
</div>			
	
	<div style="font-weight:normal">
				<p>
					This is to confirm that the declaration has been carefully read, understood & made by me/us.
				</p>
				<p>
					I am authorising the user entity / corporate to debit my account, based on the instruction as agreed and signed by me. 
				</p>
				<p>
					I have understood that I am authorized to cancel/ amend this mandate by appropriately communicating the cancellation/ amendment request to the User entity/ corporate or the bank where I have authorized the debit.
				</p>
				<p>
					I/We confirm that the information given overleaf is correct and complete to the best of my/our knowledge and I/We have read and understand the meaning and implication of the same. 
				</p>
				<p>
					If the transaction is delayed or not effected at all for the reasons of incorrect or incomplete information or non-availability of funds or closure of accounts etc., I/We shall not hold IDBI Bank/ participating banks responsible. 
				</p>
				<p>
			      I/We also agree to abide by the Bank's Terms and Conditions applicable to this payment mandate as displayed in Bank's website from time to time.  
				</p>
				<p>
				 I/We authorize the use of the above mentioned contact details for the purpose of this specific mandate processing.
				</p>
				
</div>
							
									</th>
    </tr>

    
  </tbody>
</table>

</div>
</div>
            </div>
        </div>
   		<div  style='padding-left: 40%'>

										<!-- <input type="submit" name="submit"
										class="btn btn-primary btn-sm" id="submit"
											style="padding: 0px; font-size: 1.5em; height: 40px; max-width: 30%; background-color: green;"
											value="Register"> -->
										
						  <div class="login-row btnroo row no-margin">
                               <button class='btn_format' name="submit" id="submit"  style=" background-color: #03a791 !important ;  border-color: #03a791 !important;  color:white !important;padding:7px;border:0px !important"  onclick="submitform()">Register </button>
                            </div>	
                          
                         

</div>
                         </form>          
											
									</div>


    </div>

   
</body>

<script>
function submitform()
{
	 $( "#submit" ).submit();
	
	}

$('input[type="radio"]').click(function(){
	console.log("event triggerd");
    var inputValue = $(this).attr("value");
    console.log("value:"+inputValue);
    var targetBox = $("." + inputValue);
    $(".box").not(targetBox).hide();
    $(targetBox).show();
});
</script>
    <script src="assets/js/jquery-3.2.1.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="assets/js/script.js"></script>
</html>
