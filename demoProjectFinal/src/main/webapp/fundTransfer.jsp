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

<form method="POST" action="transfer">
  <div class="container">
    <h1>Fund Transfer</h1>
    <hr><br>
    
    <label for="fromAC"><b>From Account : </b></label>
    <input type="number" name="fromAC" id="fromAC" value="${sessionScope.user.getAcno()}"required readonly>
    <br><br>
    <label for="toAC"><b>To Account : </b></label>
    <input type="number" placeholder="Account Number" name="toAC" id="toAC" required>
    <br><br>
    <label for="amt"><b>Amount : </b></label>
    <input type="number" placeholder="$$" name="amt" id="amt" required>
    <br><br>
    
    <input type="hidden" name="txnID" id="txnID" required>

    <button type="submit">Transfer Money</button>
  </div>

</form>

<script type="text/javascript">
        function transactionNumber() {
            return Math.floor((Math.random() * 1000000) + 1);
        }

document.getElementById('txnID').value = transactionNumber();
</script>

</body>
</html>