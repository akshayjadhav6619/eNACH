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
 
 <div id="main" >
 <div  class="container  rounded bg-3 text-center">    
    <form  action="#">

  <h3 style="padding-top:20px;">Mandate Management Application</h3>
  <div><hr/></div>
  
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
  </div>
  <div class="row">
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

      <label class="form-label"> Utility code </label>
    </div>
    <div class="col-sm-3"> 

	<input id="text_field" type="text">

    </div>
    <div class="col-sm-3"> 
<label class="form-label"> Name of Utility/Biller/Bank/Company </label>
    </div>
    <div class="col-sm-3">
	<input id="text_field" type="text">
    </div>
  </div>
  <div class="row">
    <div class="col-sm-3">

      <label class="form-label"> Account number </label>
    </div>
    <div class="col-sm-3"> 

	<input id="text_field" type="text">
    </div>
    <div class="col-sm-3"> 
<label class="form-label"> Account type </label>
    </div>
    <div class="col-sm-3">
      <select id="select_field">
  <option selected value="1">Saving</option>
  <option value="2">Current</option>
</select>
    </div>
  </div>
  <div class="row">
    <div class="col-sm-3">

      <label class="form-label"> Destination IFSC/MICR code </label>
    </div>
    <div class="col-sm-3"> 

<input id="text_field" type="text">
    </div>
    <div class="col-sm-3"> 
<label class="form-label"> Name of destination bank </label>
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
  <div class="row">
    <div class="col-sm-3">

      <label class="form-label"> Amount in Rs. </label>
    </div>
    <div class="col-sm-3"> 

	<input id="text_field" type="text">

    </div>
    <div class="col-sm-3"> 
<label class="form-label"> Amount in words </label>
    </div>
    <div class="col-sm-3">
	<input id="text_field" type="text">
    </div>
  </div>
  <div class="row">
    <div class="col-sm-3">

      <label class="form-label"> Frequency </label>
    </div>
    <div class="col-sm-3"> 

      <select id="select_field">
  <option value="1">Monthly</option>
</select>
    </div>
    <div class="col-sm-3"> 
<label class="form-label"> Debit type </label>
    </div>
    <div class="col-sm-3">
<fieldset>
      <div id="debit_type">
        <input type="radio" class="radio" name="x" value="y" id="y" />
        <label id="r_label" for="y">Fixed amount</label>
        <input  type="radio" class="radio" name="x" value="z" id="z" />
        <label id="r_label" for="z">Max amount</label>
      </div>
    </fieldset>
    </div>
  </div>
  <div class="row">
    <div class="col-sm-3">

      <label class="form-label"> Start date (DDMMYYYY) </label>
    </div>
    <div class="col-sm-3"> 

	<input id="text_field" type="text">
    </div>
    <div class="col-sm-3"> 
<label class="form-label"> End date (DDMMYYYY)</label>
    </div>
    <div class="col-sm-3">
	<input id="text_field" type="text">
	
    <input type="checkbox" id="end_date" name="end_date" value="EndDate">
  	<label for="end_date"> Until cancelled</label>
    </div>
  </div>
  <div class="row">
    <div class="col-sm-3">

      <label class="form-label"> Customer additional information </label>
    </div>
    <div class="col-sm-3"> 

	<input id="text_field" type="text">

    </div>
    <div class="col-sm-3"> 
<label class="form-label"> Email ID </label>
    </div>
    <div class="col-sm-3">
	<input id="text_field" type="text">
    </div>
  </div>


  <div class="row">
    <div class="col-sm-3">
    <label class="form-label"> Telephone number (STD-Number)</label>
    </div>
    <div class="col-sm-3"> 
	<input id="text_field" type="text">
    </div>
    <div class="col-sm-3"> 
	<label class="form-label"> Mobile number </label>
    </div>
    <div class="col-sm-3">
	<input id="text_field" type="text">
    </div>
  </div>


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
	
	<input  type="button"  value="Submit" style="float:left;">
	</div>
	</div>
  </div>
  </form>
  </div>
</div><br>

 

</body>
</html>