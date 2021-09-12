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

.container{
	text-align: center;
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

<%
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


<form method="POST" action="passwordreset">
  <div class="container">
    <h1>Change PassWord</h1>
    <hr><br>
    
    <label for="currpass"><b>Current Password : </b></label>
    <input type="password" placeholder="Password" name="currpass" id="currpass" required>
    <br><br>
    <label for="newpass"><b>Password : </b></label>
    <input type="password" placeholder="Password" name="newpass" id="newpass" required>
    <br><br>
    <label for="confpass"><b>Confirm Password : </b></label>
    <input type="password" placeholder="Confirm Password" name="confpass" id="confpass" required>
    <br><br>
    
    <button type="submit">Change Password</button>
  </div>

</form>



</body>
</html>