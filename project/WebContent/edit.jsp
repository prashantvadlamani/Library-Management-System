<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Book</title>
<style>
	a:HOVER{
		color:olive;
	}
	form {
   	 	border: 3px;
   	 	margin-top: 1.5%;
	}
	
	input[type=text]{
    	width: 100%;
    	padding: 12px 20px;
    	margin: 8px 0;
    	display: inline-block;
    	border: 1px solid #ccc;
   		box-sizing: border-box;
	}
	
	body{
		font-family: Verdana;
		background-color: lightblue;
	}
	h1{
	color:red;
	text-align: center;
	}
	
	table{
		height: 40px;
		width: 40px;
	}
	footer{
		margin-bottom: 0px;
		position: relative;
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
	div ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    margin-bottom: 50px;
    width: 100%;
    height : 50px;
    text-align: center;
}
	li {
    float:left;
    text-align: center;
}
	h1{
		clear: both;
	}
a {
    display: block;
    padding: 8px;
    
}
</style>
</head>
<body>
 <div>
	<ul>
  <li><a href="librarian.jsp">Home</a></li>
  <li><a href="libhistory">Get History</a></li>
  <li><a href="librarianServlet">Get All Books</a></li>
  <li><a href="add">Add a book</a></li>
  <li><a href="logout">Logout</a></li>
</ul>
</div>
<header>
	  <h1>Enter the details of book to edit</h1>
  </header>
<div style="text-align:left" ><a href="librarian.jsp" style="font-size: 30px;text-decoration: none;">Back</a></div>

	<form  method="POST" action="edit">
		Enter id<input type="text" name="bid" readonly value="<%=session.getAttribute("id")%>" ><br>
		Enter title<input type="text" name="title" value="<%=session.getAttribute("title")%>"><br>
		Enter author<input type="text" name="author" value="<%=session.getAttribute("author")%>"><br>
		Enter publisher<input type="text" name="publisher" value="<%=session.getAttribute("publisher")%>"><br>
		Enter copies<input type="text" name="copies" value="<%=session.getAttribute("copies")%>"><br>
		<table align="center">
		<tr><td ><input type="submit" value="edit" ></td></tr>
		</table>
	</form>
	<footer>
		<img src="images/footer_kids3.jpg"></img>
		<h3>Optum Library <sup>&reg;</sup></h3>
	</footer>
</body>
</html>