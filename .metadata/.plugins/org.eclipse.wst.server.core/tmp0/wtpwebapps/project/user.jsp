<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<style>
	img{
		width:200px;
		height: 200px;
	}
	.center {
    display: block;
    margin-left: auto;
    margin-right: auto;
	}
	h1{
		text-align:center;
		color: green;
	}
	body{
		background-color: #a3d6e0;
		font-family: Verdana;
	}
	a{
		text-decoration: none;
	}
	input[type=text] {
    	width: 100%;
    	padding: 12px 20px;
    	margin: 8px 0;
    	display: inline-block;
    	border: 1px solid #ccc;
   		box-sizing: border-box;
	}
	a:HOVER {
	color: olive;
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
footer img{
	width: auto;
	height: auto;
}
</style>
</head>
<body>
	<header style="background-color:#fdfdfd;">
	   <h1>Welcome</h1>
	   <span><img src="images/userlogo.jpg" class="center"></img></span>
  </header>
	<div style="text-align:right;background-color: lightyellow;height: 50px;font-size: 25px;"><a href="logout" >Logout</a></div>
	<table align="center">
		<tr>
		<form method="POST" action="userServlet">
			<td>Select searchtype:<input type="radio" name="stype" value="author">Author
			<input type="radio" name="stype" value="publisher">Publisher
			<input type="radio" name="stype" value="title">Title</td>
			<br>
		</tr>
		<tr>
			<td><input type="text" name="search" placeholder="enter the key"></td>
		</tr>
		<tr>
		<td style="text-align: center;">
			<input type="submit" value="submit">
		</td></tr>
			</form>
	</table>
	<br>
	<div style="text-align:center;">Get <a href="history" >history</a></div>	
	<footer>
		<img src="images/footer_kids3.jpg"></img>
		<h3>Optum Library <sup>&reg;</sup></h3>
	</footer>
</body>
</html>