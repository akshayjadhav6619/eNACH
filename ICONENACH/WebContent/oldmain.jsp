<%@page import="java.util.ArrayList"%>
<%@page import="com.intech.lem.service.ListService"%>
<%@page import="java.util.Map"%>
<%@page import="com.intech.lem.service.ApplicationDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IDBI-ENACH</title>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">


<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" 
  href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">


<script>
  $( function() {
    $( "#datepicker1" ).datepicker({
      //showOn: "button",
      dateFormat: 'dd-mm-yy',
      //buttonImage: "images/icons/calendar.gif",
      buttonImageOnly: true,
      //buttonText: "Select date"
    });
  } );

  $( function() {
	    $( "#datepicker2" ).datepicker({
	      //showOn: "button",
	      dateFormat: 'dd-mm-yy',
	      //buttonImage: "images/icons/calendar.gif",
	      buttonImageOnly: true,
	      //buttonText: "Select date"
	    });
	  } );
  
  


  </script>


<script src="script/sript.js"></script>


<link rel="stylesheet" href="css/idbi_flex.css">
<link>

<link rel="stylesheet" href="css/main.css">
<link>
<style>
/*******************************
* Does not work properly if "in" is added after "collapse".
* Get free snippets on bootpen.com
*******************************/
.panel-group .panel {
	border-radius: 0;
	box-shadow: none;
	border-color: #EEEEEE;
}

.panel-default>.panel-heading {
	padding: 0;
	border-radius: 0;
	color: #212121;
	background-color: #FAFAFA;
	border-color: #EEEEEE;
}

.panel-title {
	font-size: 20px;
	color: #ffffff;
	background-color: #125521;
}

.panel-title>a {
	display: block;
	padding: 30px;
	text-decoration: none;
}

.more-less {
	float: right;
	color: #212121;
}

.panel-default>.panel-heading+.panel-collapse>.panel-body {
	border-top-color: #EEEEEE;
}

/* ----- v CAN BE DELETED v ----- */
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 18px;
	line-height: 2.428571;
	background-color: #ffffff;
	color: #027464;
}

.demo {
	padding-top: 60px;
	padding-bottom: 60px;
}

#logreg-forms {
	width: 90%;
	margin: 10vh auto;
	background-color: #e0e0e0;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
	transition: all 0.3s cubic-bezier(.25, .8, .25, 1);
}

#logreg-forms form {
	width: 100%;
	padding: 20px;
	margin: auto;
}

.ui-autocomplete {
	z-index: 100;
}
.ui-autocomplete-loading { background:url('images/loading/ui-anim_basic_loading.gif') no-repeat right center }
</style>

<script>
function toggleIcon(e) {
    $(e.target)
        .prev('.panel-heading')
        .find(".more-less")
        .toggleClass('glyphicon-plus glyphicon-minus');
}
$('.panel-group').on('hidden.bs.collapse', toggleIcon);
$('.panel-group').on('shown.bs.collapse', toggleIcon);
</script>

<script>

	/* var targetBox = $("." + cp);
    console.log("test");
    $(targetBox).show();
 */
</script>

<script>
 function disableSubmit() {
  document.getElementById("submit").disabled = true;
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

	<div id="idbi_flex">
		<div id="top_div_part1">
			<a href="#"><img src="images/logo/idbi-bank-top.gif" alt="Home"
				width="229" height="45" border="0"></a>
				<a href="#"><img
					src="images/logo/logo_enach.gif" alt="Home" width="180" height="30"
					border="0"></a>
		</div>
	</div>

	<div id="idbi_flex_below">
		<div id="top_div_part_below"></div>
	</div>

	<%
	ApplicationDetails appDetails = new ApplicationDetails();
 	Map<String,String> mapData = appDetails.getAppDetailsById((String)request.getAttribute("loan_ref"));
 	%>

	<div class="container demo">


			<form action="getSave" method="post" class="form-signin">

		<div id="logreg-forms">

			<div style="text-align: center; padding-top: 3%;">
				<h2>
					<strong>Mandate Registration</strong>
				</h2>
			</div>

				<div class="panel-group" id="accordion" role="tablist"
					aria-multiselectable="true">

					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion"
									href="#collapseOne" aria-controls="collapseOne"> <i
									class="more-less glyphicon glyphicon-plus"></i> Customer
									Details
								</a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapsed"
							role="tabpanel" aria-labelledby="headingOne">

				<div class="panel-body">
								<div class="container-fluid">
									<div class="row">

										<div class="col-md-3">
											<div class="form-group">
												<label for="app_no">Application Ref. ID:</label>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group ">
												<span><%=mapData.get("APP_NO")!=null?mapData.get("APP_NO"):""%></span>
											<input id="text_field" type="text" name="ref_no" value="<%=session.getAttribute("REF")%>" style="display:none">

											</div>
										</div>
										
										<div class="col-md-3">
											<div class="form-group ">
												<label for="acc_holder_name">Name:</label>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group ">
												<%
    						if(mapData.get("PERAPP_FNAME")!=null && !mapData.get("PERAPP_FNAME").equals(""))
    						{
    							%>
												<span><%=mapData.get("PERAPP_FNAME")%></span>
												<%}else{ %>

												<input type="text" name="acc_holder_name" id="acc_holder_name"
													class="form-control" >
												<%} %>
											</div>
										</div>

										<div class="col-md-3">
											<div class="form-group ">
												<label for="mobileNumber"></label>
											</div>
										</div>
										<div class="col-md-3"></div>

									</div>
									<div class="row">

										

										<div class="col-md-3">
											<div class="form-group ">
												<label for="mobile">Mobile Number:</label>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group ">
												<%
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
												<input id="text_field" type="text" name="utility_code" style="display:none;">
											</div>
										</div>
										
										<div class="col-md-3">
											<div class="form-group ">
												<label for="email">Email ID:</label>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group ">

												<%
    						if(mapData.get("PERAPP_EMAIL")!=null && !mapData.get("PERAPP_EMAIL").equals(""))
    						{
    							%>
												<span><%=mapData.get("PERAPP_EMAIL")%></span>
												<%}else{ %>

												<input type="text" name="email" id="email"
													class="form-control">
												<%} %>

											</div>
									</div>
					</div>
									<div class="row">

										<div class="col-md-3">
											<div class="form-group ">
												<label for="loan_amount">Sanctioned Amount:</label>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group ">

												<%
    						if(mapData.get("LOAN_AMT")!=null && !mapData.get("LOAN_AMT").equals(""))
    						{
    							%>
												<span><%=mapData.get("LOAN_AMT")%></span>
												<%}else{ %>

												<input type="text" name="loan_amount" id="loan_amount"
													class="form-control" >
												<%} %>
											</div>
										</div>
										
										</div>
									
								</div>

							</div>
						</div>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#collapseTwo"
								aria-expanded="false" aria-controls="collapseTwo"> <i
								class="more-less glyphicon glyphicon-plus"></i> Mandate Details
							</a>
						</h4>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingTwo">
						<div class="panel-body">

							<div class="row">

								<div class="col-md-3">
									<div class="form-group ">
										<label for="start_date">Start Date:</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group ">
										<%
    								if(mapData.get("START_DATE")!=null && !mapData.get("START_DATE").equals(""))
    									{%>										    							
										<span><%=mapData.get("START_DATE")%></span>
										<%}else{ %>
										<input type="text"  class="form-control" id="start_date" name="start_date">
										<%} %>
									
									
								<input type="text" id="mobileNumber" name="mobileNumber" value="<%= request.getAttribute("mobileNumber") %>" style="display:none;" >
  								<input type="text" id="loan_ref" name="loan_ref" value="<%= request.getAttribute("loan_ref") %>" style="display:none;" >
  								<input type="text" id="sessionPID" name="sessionPID" value="<%= request.getAttribute("sessionPID") %>" style="display:none;" >
									
									
									</div>
								</div>

								<div class="col-md-3">
									<div class="form-group ">
										<label for="end_date">End Date:</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group ">
										<span>Valid Until Cancelled</span>
									</div>
								</div>
							</div>

							<div class="row">

										<div class="col-md-3">
											<div class="form-group ">
												<label for="name">EMI Amount:</label>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group ">
												<%
    											if(mapData.get("LOAN_EMI")!=null && !mapData.get("LOAN_EMI").equals(""))
    											{
    											%>
												<span><%=mapData.get("LOAN_EMI")%></span>
												<%}else{ %>
												<input id="amount" type="text" name="amount" >
												<%} %>
											</div>
										</div>
										
										
										
												<div class="col-md-3">
											<div class="form-group ">
												<label for="name">Maximum Mandate Amount:</label>
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group ">
												<%
    											if(mapData.get("LOAN_EMI_NEAREST_1000")!=null && !mapData.get("LOAN_EMI_NEAREST_1000").equals(""))
    											{
    											%>
												
												<input id="Maximum_Mandate_amount" type="text" name="Maximum_Mandate_amount" class="form-control"  value="<%=mapData.get("LOAN_EMI_NEAREST_1000")%>" >
												
												<%}else{ %>
												<input id="Maximum_Mandate_amount" type="text" name="Maximum_Mandate_amount"  class="form-control">
												<%} %>
											</div>
										</div>



							</div>
						
								<div class="row">
								<div class="col-md-3">
									<div class="form-group ">
										<label for="freq">EMI Collection Frequency:</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group ">
										<span>Monthly</span>
										      <!-- <select id="freq" name="freq">
											  <option value="DAIL">DAILY</option>
											   <option value="WEEK">WEEKLY</option>
											    <option value="MNTH">Monthly</option>
											     <option value="QURT">QURT</option>
											    <option value="MIAN">MIAN</option>
											   <option value="YEAR">YEAR</option>
											    <option value="BIMN">BIMN</option>
											     <option value="ADHO">As and when presented</option>
									</select> -->
											<input id="text_field" type="text" name="pan" value="-" style="display:none">
											<input id="text_field" type="text" name="consumerID" value="11111" style="display:none">
									
									</div>
								</div>

								<div class="col-md-3">
									<div class="form-group ">
										<label for="debit_type">Debit Type:</label>
									</div>
								</div>
								<div class="col-md-3">
									  	<div id="form-group">
									  	<span>Maximum Amount</span>
										<!-- <!-- <select class="form-control" name="dt" id="dt">
											<option value="M">Max amount</option>
											<option value="F">Fixed amount</option>
										</select> --> 
										</div>
								</div>

							</div>
							
							
									<!-- <fieldset> -->
							<!-- 		<div class="row">
									<div class="col-md-3">
											<div class="form-group ">
										
									<label class="form-group">Select Payment Option</label>
									</div>
									</div>
								<div class="col-md-3">

									  	<div >
									  	<label class="radio-inline" >
									    <input  type="radio" name="paymentType" id="txt" value="nb" checked style="margin-top: 15px">Net Banking</label>
									    </div>
									    
									  	<div >  
									  	<label class="radio-inline" >
									    <input  type="radio" name="paymentType" id="csv" value="cp" style="margin-top: 15px">Debit Card</label>
									    
										</div>
									</fieldset>									
								</div>
								
								</div> -->

						</div>
					</div>
				</div>

<!-- 				<div class="panel panel-default nb box" id="nb">
					<div class="panel-heading" role="tab" id="headingThree">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#collapseThree"
								aria-expanded="false" aria-controls="collapseThree"> <i
								class="more-less glyphicon glyphicon-plus"></i> Debit Account
								Details
							</a>
						</h4>
					</div>
					<div id="collapseThree" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingThree">
						<div class="panel-body">
							<div class="row">

								<div class="col-md-3">
									<div class="form-group">
										<label for="dest_ifsc">Select IFSC:</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
<div class="search-container">
        <div class="ui-widget">
			<input  type="text" id="search" name="search" class="form-control" onchange="GetBankDetails()">
		</div>
</div>
										<select class="form-control" name="dest_ifsc" id="dest_ifsc">
											<option value="ICIC0000004">ICIC0000004</option>
											<option value="ICIC0000001">ICIC0000001</option>
											<option value="SBIN0020852">SBIN0020852</option>
											<option value="UTIB0001698">UTIB0001698 </option>
										</select>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group "></div>
								</div>
								<div class="col-md-3">
									<div class="form-group "></div>
								</div>
							</div>

							<div class="row">

								<div class="col-md-3">
									<div class="form-group">
										<label for="bank_name">Bank Name:</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group ">
										<span id="bank_name">-</span>
									</div>
								</div>

								<div class="col-md-3">
									<div class="form-group ">
										<label for="branch_name">Branch Name:</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group ">
										<span id="branch_name">-</span>
									</div>

								</div>

							</div>
							<div class="row">

								<div class="col-md-3">
									<div class="form-group ">
										<label for="acc_num">Debit Account Number:</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group ">
										<input type="text" name="acc_num" id="acc_num" class="form-control" onchange="Check_Valid_AccountNumber(this.id)">
									</div>
								</div>

								<div class="col-md-3">
									<div class="form-group ">
										<label for="acc_num_confirm">*Confirm Account Number:</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group ">
										<input type="text" name="acc_num_confirm" class="form-control"
											onchange="Check_Valid_AccountNumber(this.id)" id="acc_num_confirm">
									</div>
								</div>
							</div>

							<div class="row">

								<div class="col-md-3">
									<div class="form-group ">
										<label for="acc_type">Select Account Type:</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group ">
										<select class="form-control" id="acc_type"
											name="acc_type">
											<option selected value="Saving">Savings Account</option>
											<option value="Current">Current Account</option>
											<option value="OD">OD Account</option>
										</select>
									</div>
								</div>

								<div class="col-md-3">
									<div class="form-group ">
										<label for="mobileNumber"></label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group "></div>
								</div>
							</div>

							<hr>
							<div class="row">
								<div class="col-md">
									
								</div>
							</div>

						</div>
					</div>
				</div> -->

				<!-- <div class="panel panel-default cp box" id="cp"  style="display: none;">
					<div class="panel-heading" role="tab" id="headingFour">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#collapseFour"
								aria-expanded="false" aria-controls="collapseFour"> <i
								class="more-less glyphicon glyphicon-plus"></i> Debit Card
								Details
							</a>
						</h4>
					</div>
					<div id="collapseFour" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingFour">
						<div class="panel-body">
							<div class="row">

								<div class="col-md-3">
									<div class="form-group">
										<label for="name">Select Bank:</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group ">
										
										<select class="form-control" id="dc_bank" name="dc_bank" >
											<option value="">--Select--</option>
											<% 
											ListService listObj = new ListService();
											ArrayList<String> bankList = listObj.getAllBanks();
											for(int i=0;i<=bankList.size()-1;i++){
												String bankString = bankList.get(i);
												String[] bankStr = bankString.split("_");
												%>
												<option value="<%=bankStr[0]%>"><%=bankStr[1]%></option>
											<%} %>	
											
										</select>
										
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group "></div>
								</div>
								<div class="col-md-3">
									<div class="form-group "></div>
								</div>
							</div>

							<div class="row">

								<div class="col-md-3">
									<div class="form-group">
										<label for="dc_number">Card Number:</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group ">


										<input type="text" name="dc_number" class="form-control"
											id="dc_number">
									</div>
								</div>

								<div class="col-md-3">
									<div class="form-group ">
										<label for="dc_ey">Select Expire Year</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group ">
										<select class="form-control" id="dc_ey" name="dc_ey">
											<option selected value="">--Select--</option>
											<option value="21">2021</option>
											<option value="22">2022</option>
											<option value="23">2023</option>
											<option value="24">2024</option>
											<option value="25">2025</option>
											<option value="26">2026</option>
											<option value="27">2027</option>
											<option value="28">2028</option>
											<option value="29">2029</option>
											<option value="30">2030</option>
										</select>


									</div>

								</div>

							</div>
							<div class="row">

								<div class="col-md-3">
									<div class="form-group ">
										<label for="dc_em">Select Expire Month:</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group ">
										<select class="form-control" id="dc_em" name="dc_em">
											<option selected value="">--Select Month--</option>
											<option value="01">Janaury</option>
											<option value="02">February</option>
											<option value='03'>March</option>
											<option value='04'>April</option>
											<option value='05'>May</option>
											<option value='06'>June</option>
											<option value='07'>July</option>
											<option value='08'>August</option>
											<option value='09'>September</option>
											<option value='10'>October</option>
											<option value='11'>November</option>
											<option value='12'>December</option>
										</select>
									</div>
								</div>

								<div class="col-md-3">
									<div class="form-group ">
										<label for="dc_cvv">CVV Code:</label>
									</div>
								</div>
								<div class="col-md-3">
									<input type="text" name="dc_cvv" class="form-control" id="dc_cvv">
								</div>
							</div>

							<div class="row">

								<div class="col-md-3">
									<div class="form-group "></div>
								</div>
								<div class="col-md-3">
									<div class="form-group "></div>
								</div>

								<div class="col-md-3">
									<div class="form-group ">
										<label for="mobileNumber"></label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group "></div>
								</div>
							</div>

							<hr>
							<div class="row">
								<div class="col-md">

								</div>
							</div>

						</div>
					</div>
				</div>-->
				
<div class="form-check">
	<input  class="form-check-input"   type="checkbox" name="terms" id="terms" onchange="activateButton(this)" id="terms"> 
	 <label  class="form-check-label" for="inputPassword3" >I Agree Terms & Coditions</label>
</div>			
	
				<p>
				-	This is to confirm that the declaration has been carefully read, understood & made by me/us.
				</p>
				<p>
				-	I am authorising the user entity / corporate to debit my account, based on the instruction as agreed and signed by me. 
				</p>
				<p>
				-	I have understood that I am authorized to cancel/ amend this mandate by appropriately communicating the cancellation/ amendment request to the User entity/ corporate or the bank where I have authorized the debit.
				</p>
				<p>
				-	I/We confirm that the information given overleaf is correct and complete to the best of my/our knowledge and I/We have read and understand the meaning and implication of the same. 
				</p>
				<p>
				-	If the transaction is delayed or not effected at all for the reasons of incorrect or incomplete information or non-availability of funds or closure of accounts etc., I/We shall not hold IDBI Bank/ participating banks responsible. 
				</p>
				<p>
				-	I/We also agree to abide by the Bank's Terms and Conditions applicable to this payment mandate as displayed in Bank's website from time to time.  
				</p>
				<p>
				I/We authorize the use of the above mentioned contact details for the purpose of this specific mandate processing.
				</p>
				

									<div class="form-group" style="padding-left: 40%">

										<input type="submit" name="submit"
											class="form-control btn-success" id="submit"
											style="padding: 0px; font-size: 1.5em; height: 40px; max-width: 30%; background-color: green;"
											value="Register">
									</div>
																
		</div>
		<!-- panel-group -->
		</form>

	</div>

	
	
<script>
/* $('#cp').hide();

$('#paymentType').on(
  'change',
  function() 
  {
    $('.nb, .cp').toggle()
  }
); */
$('input[type="radio"]').click(function(){
	console.log("event triggerd");
    var inputValue = $(this).attr("value");
    console.log("value:"+inputValue);
    var targetBox = $("." + inputValue);
    $(".box").not(targetBox).hide();
    $(targetBox).show();
});

</script>

<script>





/* $(document).on('keydown', '#search', function() {
	var id = this.id;
	console.log("id:"+id);
    $("#search").autocomplete({     
        source : function(request, response) {
          	console.log("test");
        	$.ajax({
               url : "searchifsc",
               type : "GET",
               data : {
                      term : request.term,request:1
               },
               dataType : "json",
               success : function(data) {
                     response(data);
               }
        });
     },
     select: function( event, ui ) {
         //alert( ui.item.value );
         //$(this).val(ui.item.label);// Your code
         
         $(this).val(ui.item.label); // display the selected text
         var ifsc = ui.item.value;
         alert(ifsc);
         
         $.ajax({
             url: 'searchifsc',
             type: 'GET',
             data: {term:ifsc,request:2},
             dataType: 'json',
             success:function(response){
         		console.log(response);
			
         	   //var splitdata = response.toString().split('_');
               var bankName = response[0];
               var branchName = response[1];
  
               // Set value to textboxes
               var spanName = document.getElementById('bank_name');// bankName;
               var spanBranch = document.getElementById('branch_name');//.value = branchName;
               spanName.textContent  = bankName;//"New Span content";
               spanBranch.textContent = branchName;//"New Span content";

         
             }
            });
         return false;
         
      }
 });
});
 */



function Check_Valid_AccountNumber(Id)
{
	  var Debit_Account_No=$("#acc_num").val();
	  var Confirm_Account_No=$("#acc_num_confirm").val()
	
	      if (Debit_Account_No!="" && Debit_Account_No!=null) 
	       {
					   $("#acc_num").css('border-color', '');
				      //return true;
					
		   }else{
					
					  alert("Please Enter Debit Account Number...!");
					  $("#acc_num").css('border-color', 'red');
				      $("#acc_num").focus(); 
					  return false;
			}
	  	 if(Debit_Account_No!="" && Debit_Account_No!=null && Confirm_Account_No!="" && Confirm_Account_No!=null)
		  {
	  		// alert(Debit_Account_No == Confirm_Account_No)
	 		 if(Debit_Account_No == Confirm_Account_No)
		  		{
		   
	 			  $("#"+Id).css('border-color', '');
			      //return true;
				
			  }else{
				  
		   		 alert("Debit Account Number and Confirm Account Number Is MisMatch...!");
				  $("#"+Id).css('border-color', 'red');
				  $("#"+Id).focus(); 
				  return false;
			 }
				
		  			
		   }
}
	  


function GetBankDetails()
{
	var IFSC_Code=$("#search").val().toUpperCase();
	var ctrx='<%=request.getContextPath()%>';
	
	$.ajax({
			 url: ctrx+"/IFSCBankDetailAutoComplete?Key=getBankDetails&&IFSC_Code="+IFSC_Code,
			 type: "GET",
			 contentType: "application/json; charset=utf-8",
			 dataType: "json",
			success: function(data)
			{
     			var json = data;
    			if(json[0]!="IFSC_Present")
    			{
    	 		  alert("IFSC Code Does Not Exist...!");
    	 		  $("#search").css('border-color', 'red');
			      $("#search").focus(); 
				  return false;
    			 
    	
    			}else{
    				
    				 $("#search").css('border-color', '');
   			       
    			}
   					 var spanName = document.getElementById('bank_name');// bankName;
   					 var spanBranch = document.getElementById('branch_name');//.value = branchName;
    				 spanName.textContent  = json[1];//"New Span content";
    				 spanBranch.textContent = json[2];
   					 $("#search").val(json[3]);//
    				
			},
				error: function(error){
    		 console.log("Error:");
    		 console.log(error);
			}
});		

}









</script>

	<!-- container -->
</body>
</html>