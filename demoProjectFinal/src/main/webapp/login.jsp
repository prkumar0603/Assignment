<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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

<form method="post" action="login">
	<div class="container">
		<h1>Login</h1>
    	<hr><br>
    
		<label for="custID"><b>Customer ID : </b></label>
	    <input type="number" placeholder="Enter Customer ID" name="custID" id="custID" required>
	    <br><br>
	    <label for="pass"><b>Password : </b></label>
	    <input type="password" placeholder="Password" name="pass" id="pass" required>
	    <br><br>
		<button type="submit">Login</button>
	</div>
</form>

</body>
</html>