<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Management System</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}

.navbar {
  overflow: hidden;
  background-color: #4AE9E9;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.navbar .right{
	float : right;
	font-size: 16px;
  	color: white;
  	text-align: center;
  	padding: 14px 16px;
  	text-decoration: none;
}

</style>

</head>
<body>

<div class="navbar">
  <a href="home">Home</a>
  <a href="txn">Statement</a>
  <a href="fundTransfer.jsp">Fund Transfer</a>
  <a href="resetPass.jsp">Change Password</a>
  <a class="right" href="logout">Logout</a>
</div>

<% 	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	String msg = (String)session.getAttribute("valid");
	if(msg != null){
		//session.removeAttribute("valid");
	}
				
	if(msg == null){
%>
		alert("UnAuthorized");					
<%	
	String redirectURL = "index.jsp";
    response.sendRedirect(redirectURL);
	}		
	
	// getting success or error msg
	String succMsg = (String)session.getAttribute("succMsg");
	String errMsg = (String)session.getAttribute("errMsg");
	if(succMsg != null){
%>
		${succMsg}						
<% 
		session.removeAttribute("succMsg");
	}
				
	if(errMsg !=null){
%>
		('Error - ${errMsg}');					
<%
		session.removeAttribute("errMsg");
	}	
%>


<h1>Welcome ${sessionScope.user.getName()} </h1>

<h3> Customer ID : ${sessionScope.user.getCustID()} </h3>
<h3> Account No. : ${sessionScope.user.getAcno()} </h3>
<h3> Branch Name : ${sessionScope.user.getBranchName()} </h3>
<h3> Bank Name : ${sessionScope.user.getBankName()} </h3>
<h3> Balance : ${sessionScope.user.getBalance()} </h3>


</body>
</html>