<%@page import="org.json.JSONObject"%>
<html>
<head>
<title>IDBI ENACH Checkout DemoUAT</title>
<meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1"  />


<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script  src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="https://www.paynimo.com/paynimocheckout/client/lib/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="https://www.paynimo.com/paynimocheckout/server/lib/checkout.js"></script>


<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
<link rel="stylesheet" href="css/idbi_flex.css">


<style>

 .btn_format{
    
    border-radius:50px !important;
    margin-right:15px;
    width:120px;
   
    
    }
</style>
</head>

<body>


<nav class="navbar navbar-light bg-light" style="min-height:60px !important">
  <a class="navbar-brand">
    <img src="assets/images/Logo.png" class="d-inline-block align-top" alt="">
   
  </a>
</nav>

<div class="container demo">
				<h2>
					<strong>Mandate Registration</strong>
				</h2>



<%
String reqType = (String) request.getAttribute("consumerData"); 
JSONObject jsonObj = new JSONObject(reqType);
%>
<p></p>
<table class="table">
<tbody id="tbody">
	<tr>
      <th>Application Number</th>
      <td><%=jsonObj.get("txnId") %></td>
          </tr>
          <tr>

      <th>EMI Amount</th>
      <td><%=jsonObj.getJSONArray("items").getJSONObject(0).get("amount") %></td>
      
</tr>
    <tr>
      <th>Frequency</th>
      <td><%=jsonObj.get("frequency") %></td>
      
    </tr>
</tbody>
</table>


 <div class="login-row btnroo row no-margin">
   <input type="button" class='btn_format' style="background-color: #03a791 !important ;  border-color: #03a791 !important;  color:white !important;padding:7px;border:0px !important" id="btnSubmit" value="Submit" onclick="PopUpInginoSide()"  >
                               </div>
                         

</div>



<script type="text/javascript">
$(document).ready(function() {
    function handleResponse(res) {
        if (typeof res != 'undefined' && typeof res.paymentMethod != 'undefined' && typeof res.paymentMethod.paymentTransaction != 'undefined' && typeof res.paymentMethod.paymentTransaction.statusCode != 'undefined' && res.paymentMethod.paymentTransaction.statusCode == '0300') {
            // success block
        } else if (typeof res != 'undefined' && typeof res.paymentMethod != 'undefined' && typeof res.paymentMethod.paymentTransaction != 'undefined' && typeof res.paymentMethod.paymentTransaction.statusCode != 'undefined' && res.paymentMethod.paymentTransaction.statusCode == '0398') {
            // initiated block
        } else {
            // error block
        }
    };

  
      
    	
    //);
});

function PopUpInginoSide(){

    var configJson = {
        'tarCall': false,
        'features': {
        	 'showPGResponseMsg': true,
             'enableAbortResponse': true,
             'enableNewWindowFlow': true,    //for hybrid applications please disable this by passing false
             'enableExpressPay':true,
             'siDetailsAtMerchantEnd':true,
             'enableSI':true
        },
        'consumerData': <%= request.getAttribute("consumerData") %>
        
    };
    
    $.pnCheckout(configJson);
    if(configJson.features.enableNewWindowFlow){
        pnCheckoutShared.openNewWindow();
    }
};
//test();
</script>
</body>
</html>