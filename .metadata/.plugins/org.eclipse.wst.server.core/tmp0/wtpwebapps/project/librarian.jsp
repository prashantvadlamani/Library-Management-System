<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Librarian</title>
<style>
	body{
		font-family: Verdana;
	}
	footer img{
	width: auto;
	height: auto;
}
	h1{
		text-align:center;
		color: green;
	}
	a:hover{
		color:olive;
	}
	a{
		color: red;
		padding: 15px;
	}
	body{
		background-color: #a3d6e0;
	}
	img{
		width:200px;
		height: 200px;
	}
	.center {
    display: block;
    margin-left: auto;
    margin-right: auto;
	}
	table{
		background-color: lightyellow;
		margin-top: 40px;
		text-align: center;
	}
	table tr{
		height:40px;
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
	h3{
		color: red;
		text-align: center;
	}
</style>
</head>
<body>
	<header style="background-color:#fdfdfd;">
	   <h1>Welcome</h1>
	   <span><img src="images/librarianlogo.jpg" class="center"></img></span>
  </header>
	<div style="text-align:right;background-color: lightyellow;height: 50px;font-size: 25px;"><a href="logout" >Logout</a></div>
	<br>
	<table align="center" width="100%">
		<tr>
			<td>Get <a href="libhistory">History</a></td>
		</tr>
		<tr>
			<td style="background-color: lightblue;">Get All <a href="librarianServlet">Books</a></td>
		</tr>
		<tr>
			<td>Add a <a href="add">Book</a><td>
	</tr>
	</table>
	<footer>
		<img src="images/footer_kids3.jpg"></img>
		<h3>Optum Library <sup>&reg;</sup></h3>
	</footer>
</body>
</html>