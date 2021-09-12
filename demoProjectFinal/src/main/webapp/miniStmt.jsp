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
%>

<div class="navbar">
  <a href="home">Home</a>
  <a href="txn">Statement</a>
  <a href="fundTransfer.jsp">Fund Transfer</a>
  <a href="resetPass.jsp">Change Password</a>
  <a class="right" href="logout">Logout</a>
</div>

<h1>Transactions</h1>

<h3> Transaction Count : ${sessionScope.txnCount} </h3><br>
<h3> ${sessionScope.txn} </h3><br>

</body>
</html>