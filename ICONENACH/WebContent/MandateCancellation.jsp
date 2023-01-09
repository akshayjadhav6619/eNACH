<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"  href="css/entryform.css"><link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
.headignclass{
font-family: ui-sans-serif;
    font-size: 35px;
    color: black;
    margin:1% 1% 2% 35%;
    font-weight:500 !important;
    
    }
    .iputclass{
    width:55% !important;
    margin:5px;
    }
    
        .labelClass{
    width:30% !important;
    font-size : 14px ! important;
    font-weight: 500 !important;
    color : #2AAA8A;
    margin :5px;
    }
</style>
</head>
<body>
<div class="headerBackClassS Headersclass centerclass">
<div><h2 class="headignclass">Mandate Cancellation</h2></div>
</div>


<form  action="SaveCancellationData" method="post" id="MandateCancellation" name="MandateCancellation" class="centerclass form-signin" style='border:1px solid black;height:350px'  > 
   <div class="form-group">
      <label class="control-label col-sm-2 labelClass" for="pwd">Account Name:</label>
      <div class="col-sm-10 iputclass" >          
        <input type="text" class="form-control iputclass" id="Account_Name" placeholder="Account Name" name="Account_Name">
      </div>
    </div>
    
  <div class="form-group">
      <label class="control-label col-sm-2 labelClass" for="pwd">Loan Account number </label>
      <div class="col-sm-10 iputclass">          
        <input type="text" class="form-control iputclass" id="LoanAccNumber" placeholder="Loan Account Number" name="LoanAccNumber">
      </div>
   </div>
   
     <div class="form-group">
      <label class="control-label col-sm-2 labelClass" for="pwd">UMRN Number </label>
      <div class="col-sm-10 iputclass">          
        <input type="text" class="form-control iputclass" id="UMRNumber"  name="UMRNumber" placeholder="UMRN Number" >
      </div>
   </div>
   
     <div class="form-group">
      <label class="control-label col-sm-2 labelClass" for="pwd">IFSC Code</label>
      <div class="col-sm-10 iputclass">          
        <input type="text" class="form-control iputclass" id="IFSC_code"  name="IFSC_code" placeholder="IFSC Code" >
      </div>
   </div>
   
     <div class="form-group">
      <label class="control-label col-sm-2 labelClass" for="name">Customer Name</label>
      <div class="col-sm-10 iputclass">          
        <input type="text" class="form-control iputclass" id="Customer_Name"  name="Customer_Name" placeholder="Customer_Name" >
      </div>
   </div>

<div class="form-group">
      <label class="control-label col-sm-2 labelClass" for="name">Cancellation Reason</label>
   <div class="col-md-3">
	<div class="form-group ">
	<select id="CancellationReason" name="CancellationReason" class="form-control iputclass" style="width:265px !important; margin-left:5px">
	<option value="AccountClose">Account Closed</option>
    <option value="ChangeOfMandate">Change of Mandate</option>
    <option value="ChangeOfBankDetails">Change of Bank Details</option>
	</select> 
	</div>
	</div>
   </div>
   <input type="hidden" name="hddmanadte" id="hddmandate">
</form>
 <div  class="headerBackClassS Headersclass centerclass" style='border-radius:0px 0px 6px 6px !important'>
  <button name="submitBtn" id="submitBtn"  style="float:right" onClick="ValidationForm()"> SUBMIT</button>
   </div>


<script>
function ValidationForm()
{
	document.getElementById('MandateCancellation').submit();
	
}

</script>
</body>
</html>