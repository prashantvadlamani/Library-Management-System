<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<style>
	input[type=text], input[type=password] {
    	width: 100%;
    	padding: 12px 20px;
    	margin: 8px 0;
    	display: inline-block;
    	border: 1px solid #ccc;
   		box-sizing: border-box;
	}
	body,html{
		height: 100%;
		margin: 0;
		font-family: Verdana;
		background-color: lightblue;
	}
	.bg{
		background-image:url("images/homepage.png");
		background-repeat: no-repeat;
		background-size: cover;
		background-position: center;
		height: inherit; 
	}
	form {
   	 	border: 3px;
   	 	margin-top: 9%;
	}
	h3{
		color: red;
		text-align: center;
	}
	a{
		color: red;
		font-size:20px;	
		text-decoration: none;
	}
	a:HOVER {
	color:white;
}
	footer{
		margin-bottom: 0px;
		position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    color: white;
    text-align: center;
	}
	
</style>
</head>
<body>
	<a href="index.jsp">Home</a>
	<header>
		<h3>Registration form</h3>
	</header>
	<form method="POST" action="registerServlet">
	<table align="center">
		<tr>
			<td>Enter username:</td><td> <input type="text" name="uname" placeholder="enter username"></td>
		</tr>
		<tr><td>Enter password:</td><td><input type="password" name="pass" placeholder="enter password"></td>
		</tr>
		<tr >
			<td>Enter usertype:</td>
	
			<td><input type="radio" name="utype" value="librarian">Librarian
		
		<input type="radio" name="utype" value="user">User</td>
		</tr>
		</table>
			<div style="margin-top: 30px;text-align: center;"><input type="submit" value="submit"></div>
	</form>
	<footer>
		<img src="images/footer_kids3.jpg"></img>
		<h3>Optum Library <sup>&reg;</sup></h3>
	</footer>
</body>
</html>