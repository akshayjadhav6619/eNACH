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

</head>
<body onload="InsertResponseData(request.getParameter('msg'))">
<%=request.getParameter("msg")%>
<div class="container">
<%if(request.getParameter("msg").split("\\|")[0].equals("0300"))
 {
%>
  <div class="alert alert-success">
    <strong><%=request.getParameter("msg").split("\\|")[1]%>...!</strong> <%=request.getParameter("msg").split("\\|")[2]%>.
  </div>
  <%}
  
if(request.getParameter("msg").split("\\|")[0].equals("0398"))
 {
%>
  <div class="alert alert-info">
    <strong><%=request.getParameter("msg").split("\\|")[1]%>....!</strong> <%=request.getParameter("msg").split("\\|")[2]%>.
  </div>
  <%}
 
  if(request.getParameter("msg").split("\\|")[0].equals("0399"))
  {
%>
   <div class="alert alert-danger">
     <strong><%=request.getParameter("msg").split("\\|")[1]%>...!</strong> <%=request.getParameter("msg").split("\\|")[2]%>.
   </div>
   <%} 

  if(request.getParameter("msg").split("\\|")[0].equals("0392"))
 {
%>
  <div class="alert alert-danger">
    <strong><%=request.getParameter("msg").split("\\|")[1]%>....!</strong> <%=request.getParameter("msg").split("\\|")[2]%>.
  </div>
  <%}
  
if(request.getParameter("msg").split("\\|")[0].equals("0396"))
 {
%>
  <div class="alert alert-primary">
    <strong><%=request.getParameter("msg").split("\\|")[1]%>...!</strong> <%=request.getParameter("msg").split("\\|")[2]%>.
  </div>
 <%} %>

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