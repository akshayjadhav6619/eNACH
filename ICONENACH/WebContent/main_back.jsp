<%@page import="java.util.Map"%>
<%@page import="com.intech.lem.service.ApplicationDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LEM</title>


<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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


<link rel="stylesheet"  href="css/idbi_flex.css"><link>

<link rel="stylesheet"  href="css/main.css"><link>

</head>

 <body>
 
 <div id="idbi_flex">
    <div id="top_div_part1" ><a href="#"><img src="images/logo/idbi-bank-top.gif" alt="Home" width="229" height="45" border="0"></a></div>
 </div>
 
 <div id="idbi_flex_below">
    <div id="top_div_part_below" ></div>
 </div>
 <%ApplicationDetails appDetails = new ApplicationDetails();
 Map<String,String> mapData = appDetails.getAppDetailsById(session.getAttribute("REF").toString());
 
 %>
 <div id="main" >
 <div  class="container  rounded bg-3 text-center">    
    <form  action="getSave" method="post">

  <h3 style="padding-top:20px;">E-Mandate Registration Application</h3>
  <div><hr/></div>
  
  <div class="row">
    <div class="col-sm-3">

      <label class="form-label"> Start date (DD-MM-YYYY) </label>
    </div>
    <div class="col-sm-3"> 

	<input id="datepicker1" name="start_date" type="text" value="<%=mapData.get("LOAN_FILEDON")!=null?mapData.get("LOAN_FILEDON"):""%>">
	    <i class="fa fa-calendar form-control-feedback"></i>
	
    </div>
    <div class="col-sm-3"> 
<label class="form-label"> End date (DD-MM-YYYY)</label>
    </div>
    <div class="col-sm-3">
	<input id="datepicker2"  name="end_date" type="text" >
	    <i class="fa fa-calendar form-control-feedback"></i>
	
	
<!--     <input type="checkbox" id="end_date" name="end_date" value="EndDate">
  	<label for="end_date"> Until cancelled</label> -->
    </div>
  </div>

<div class="row">
    
    <div class="col-sm-3"> 
<label class="form-label"> Debit type </label>
    </div>
    <div class="col-sm-3">
<fieldset>
      <div id="debit_type">
        <input type="radio" class="radio" name="dt" value="M" id="y" />
        <label id="r_label" for="y">Fixed amount</label>
        <input  type="radio" class="radio" name="dt" value="F" id="z" />
        <label id="r_label" for="z">Max amount</label>
      </div>
    </fieldset>
    </div>
    <div class="col-sm-3">

      <label class="form-label"> Frequency </label>
    </div>
    <div class="col-sm-3"> 

      <select id="select_field" name="freq">
  <option value="DAIL">DAILY</option>
   <option value="WEEK">WEEKLY</option>
    <option value="MNTH">Monthly</option>
     <option value="QURT">QURT</option>
    <option value="MIAN">MIAN</option>
   <option value="YEAR">YEAR</option>
    <option value="BIMN">BIMN</option>
     <option value="ADHO">ADHO</option>
  
</select>
    </div>
  </div>

  <div class="row">

    <div class="col-sm-3"> 
<label class="form-label"> Name of destination bank </label>
    </div>
    <div class="col-sm-3">
	<input id="text_field"  name="dest_bank" type="text">
    </div>
    
    <div class="col-sm-3">

      <label class="form-label"> Destination IFSC/MICR code </label>
    </div>
    <div class="col-sm-3"> 

<input id="text_field" name="dest_ifsc" type="text">
    </div>

  </div>
  

  <div class="row">
    
<div class="col-sm-3">
      <label class="form-label"> Amount in Rs. </label>
    </div>
    <div class="col-sm-3"> 

	<input id="number" type="text" name="amount" value="<%=mapData.get("LOAN_EMI")!=null?mapData.get("LOAN_EMI"):""%>">

    </div>
	<span> Amount in words: &nbsp;</span>
	<span id="words" ></span>
  </div>


<div><hr/></div>

  <div class="row">
    <div class="col-sm-3">

      <label class="form-label"> Utility code </label>
    </div>
    <div class="col-sm-3"> 

	<input id="text_field" type="text" name="utility_code">

    </div>

    <div class="col-sm-3"> 
<label class="form-label"> Account type </label>
    </div>
    <div class="col-sm-3">
     
      <select id="select_field" name="acc_type">
  		<option selected value="Saving">Saving</option>
  		<option value="Current">Current</option>
</select>
    </div>    
  </div>
  
  

  <div class="row">
    <div class="col-sm-3">

      <label class="form-label"> Account number </label>
    </div>
    <div class="col-sm-3"> 

	<input id="text_field" type="text" name="acc_num" value="<%=mapData.get("PERAPP_BANKACCNO")!=null?mapData.get("PERAPP_BANKACCNO"):""%>">
    </div>

<div class="col-sm-3">

      <label class="form-label"> Account Holder Name </label>
    </div>
    <div class="col-sm-3"> 

	<input id="text_field" type="text" name="acc_holder_name" value="<%=mapData.get("PERAPP_FNAME")!=null?mapData.get("PERAPP_FNAME"):""%>">
    </div>
  </div>  
  
  
      <div class="row">
    <div class="col-sm-3">

      <label class="form-label"> Customer additional information </label>
    </div>
    <div class="col-sm-3"> 

	<input id="text_field" type="text" name="cust_additional_details" value="<%=mapData.get("PERAPP_ADDRESS1")!=null?mapData.get("PERAPP_ADDRESS1"):""%>">

    </div>
    <div class="col-sm-3"> 
<label class="form-label"> Email ID </label>
    </div>
    <div class="col-sm-3">
	<input id="text_field" type="text" name="email" value="<%=mapData.get("PERAPP_EMAIL")!=null?mapData.get("PERAPP_EMAIL"):""%>">
    </div>
  </div>


  <div class="row">
    <div class="col-sm-3">
    <label class="form-label"> Telephone number (STD-Number)</label>
    </div>
    <div class="col-sm-3"> 
	<input id="text_field" type="text" name="tel_num" value="<%=mapData.get("PERAPP_PHONE")!=null?mapData.get("PERAPP_PHONE"):""%>">
    </div>
    <div class="col-sm-3"> 
	<label class="form-label"> Mobile number </label>
    </div>
    <div class="col-sm-3">
	<input id="text_field" type="text" name="mobile" value="<%=mapData.get("PERAPP_MOBILE")!=null?mapData.get("PERAPP_MOBILE"):""%>">
    </div>
  </div>
  
  <div class="row">
    <div class="col-sm-3">
    <label class="form-label"> PAN Card Number</label>
    </div>
    <div class="col-sm-3"> 
	<input id="text_field" type="text" name="pan" value="<%=mapData.get("PERAPP_PANNO")!=null?mapData.get("PERAPP_PANNO"):""%>">
    </div>
    
    <div class="col-sm-3">
    <label class="form-label"> </label>
    </div>
    <div class="col-sm-3"> 
	<input id="text_field" type="text" name="consumerID" value="11111" style="display:none">
	<input id="text_field" type="text" name="ref_no" value="<%=session.getAttribute("REF")%>" style="display:none">
    </div>
    
  </div>
  
  
<!--   
  <div class="row">
    <div class="col-sm-3">

      <label class="form-label"> Action </label>
    </div>
    <div class="col-sm-3"> 

      <select id="select_field">
  
  <option value="1">Create</option>
  <option value="2">Amend</option>
  <option value="3">Cancel</option>
</select>
    </div>
    <div class="col-sm-3"> 
<label class="form-label"> Scheme/Plan reference number </label>
    </div>
    <div class="col-sm-3">
	<input id="text_field" type="text">
    </div>
  </div> -->
<!--   <div class="row">
    <div class="col-sm-3">

      <label class="form-label"> Date</label>
    </div>
    <div class="col-sm-3"> 

	<input id="text_field" type="text">

    </div>
    <div class="col-sm-3"> 
<label class="form-label"> Sponsor Bank code </label>
    </div>
    <div class="col-sm-3">
	<input id="text_field" type="text">
    </div>
  </div>



  <div class="row">
    <div class="col-sm-3">

      <label class="form-label"> Debit account number </label>
    </div>
    <div class="col-sm-3"> 

		<input id="text_field" type="text">
    </div>
    <div class="col-sm-3"> 
<label class="form-label"> Mandate category</label>
    </div>
    <div class="col-sm-3">
      <select id="select_field">
  <option value="1">B2B Corporate</option>
</select>
    </div>
  </div>
  
 -->

  <div class="row">
	<div class="col-sm-12"><hr/></div>
  
  </div>
  <div class="row">
	    <div class="col-sm-6"     >
	<div style="padding-right: 25%;">
	<input  type="button" value="Cancel" style="float:right;">
	</div>
	</div>
	    <div class="col-sm-6">
	<div      style="padding-right: 25%;">
	
	<input  type="submit"  value="Submit" style="float:left;">
	</div>
	</div>
  </div>
  </form>
  </div>
</div><br>

 
<script>
var a = ['','one ','two ','three ','four ', 'five ','six ','seven ','eight ','nine ','ten ','eleven ','twelve ','thirteen ','fourteen ','fifteen ','sixteen ','seventeen ','eighteen ','nineteen '];
var b = ['', '', 'twenty','thirty','forty','fifty', 'sixty','seventy','eighty','ninety'];

function inWords (num) {
    if ((num = num.toString()).length > 9) return 'overflow';
    n = ('000000000' + num).substr(-9).match(/^(\d{2})(\d{2})(\d{2})(\d{1})(\d{2})$/);
    if (!n) return; var str = '';
    str += (n[1] != 0) ? (a[Number(n[1])] || b[n[1][0]] + ' ' + a[n[1][1]]) + 'crore ' : '';
    str += (n[2] != 0) ? (a[Number(n[2])] || b[n[2][0]] + ' ' + a[n[2][1]]) + 'lakh ' : '';
    str += (n[3] != 0) ? (a[Number(n[3])] || b[n[3][0]] + ' ' + a[n[3][1]]) + 'thousand ' : '';
    str += (n[4] != 0) ? (a[Number(n[4])] || b[n[4][0]] + ' ' + a[n[4][1]]) + 'hundred ' : '';
    str += (n[5] != 0) ? ((str != '') ? 'and ' : '') + (a[Number(n[5])] || b[n[5][0]] + ' ' + a[n[5][1]]) + 'only ' : '';
    return str;
}

document.getElementById('number').onkeyup = function () {
    document.getElementById('words').innerHTML = inWords(document.getElementById('number').value);
};

</script>
</body>
</html>