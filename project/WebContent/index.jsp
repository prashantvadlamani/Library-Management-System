<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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
	h1{
		color: red;
	}
	a{
		color: #fcfade;
		text-decoration: none;
	}
	a:HOVER {
	color:#a3e587;
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
	<div class="bg">
	<header>
	   <marquee scrolldelay="0" scrollamount="25"><h1>Welcome to Login Page</h1></marquee>
  </header>
	<form method="POST" action="loginServlet">
		<table  align="center">
			<tr>
				<td style="text-align: center;color: white;">username</td>
				<td><input type="text" name="uname" placeholder="enter username"></td>
			</tr>
			<tr>
				<td style="text-align: center;color: white;">password</td>
				<td><input type="password" name="pass" placeholder="enter password"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input type="submit" value="login"></td>
			</tr>
		</table>
		
	</form>
	<br>
	<h3 align="center" style="color: white;">New User?<a href="register.jsp">Register</a></h3>
	</div>
	<footer>
		<h3>Optum Library <sup>&reg;</sup></h3>
	</footer>
</body>
</html>