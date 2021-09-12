<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
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

</style>
</head>
<body>
<div class="navbar">
  <a href="index.jsp">Home</a>
  <a href="login.jsp">Login</a>
  <a href="register.jsp">Sign Up</a>
</div>

<% 	
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
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
		('Error while Registering - ${errMsg}');					
<%
		session.removeAttribute("errMsg");
	}	
%>


<form method="POST" action="register">
  <div class="container">
    <h1>Registration </h1>
    <hr>
    
    <label><b>User Details</b></label><br><br>
    
    <label for="name"><b>Name : </b></label>
    <input type="text" placeholder="Enter full Name" name="name" id="name" required>
    <br><br>
    <label for="custID"><b>Customer ID : </b></label>
    <input type="number" name="custID" id="custID" required readonly>
    <br><br>
    <label for="acno"><b>Account No : </b></label>
    <input type="number" name="acno" id="acno" required readonly>
    <br><br>
    <label for="pass"><b>Password : </b></label>
    <input type="password" placeholder="Password" name="pass" id="pass" required>
    <br><br>
    <label for="confpass"><b>Confirm Password : </b></label>
    <input type="password" placeholder="Confirm Password" name="confpass" id="confpass" required>
    <br><br>
    <hr>
    
    <label><b>Personal Details</b></label><br><br>
    <label for="dob"><b>Date Of Birth : </b></label>
    <input type="date" name="dob" id="dob" required>
    <br><br>
    <label for="mobile"><b>Mobile : </b></label>
    <input type="number" placeholder="Enter Number" name="mobile" id="mobile" required>
    <br><br>
    <label for="gender"><b>Gender : </b></label>
    <select name="gender" id="gender">
    	<option value="male">Male</option>
  		<option value="female">Female</option>
    </select>
    <br><br>

    <button type="submit">Register</button>
  </div>

  <div class="container signin">
    <p>Already have an account? <a href="loginPage">Sign in</a>.</p>
  </div>
</form>

<script type="text/javascript">
    function customerID() {
		return Math.floor((Math.random() * 1000000) + 1);
	}
	function accontNo() {
		return Math.floor((Math.random() * 1000000000000) + 1);
    }

document.getElementById('custID').value = customerID();
document.getElementById('acno').value = accontNo();
</script>

</body>
</html>