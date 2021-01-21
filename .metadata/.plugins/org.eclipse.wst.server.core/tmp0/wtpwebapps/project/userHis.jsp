<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User's Book history</title>
<style>
	tr:nth-child(odd) {background-color: #d2d2d2;}
	div{
		background-color: #b0dfe8;
		height:50px;
	}
	h3{
		color: red;
		text-align: center;
	}
	a{
		text-decoration: none;
	}
	a:hover { 
    color: white;
    font-size: 25px;
	}
	td{
	text-align: center;
	}
	body{
		font-family: Verdana;
	}
	table tr td a:hover { 
    color: red;
	}
	
	div a:hover{
		color:red;
	}
	table {
	margin-bottom: 50px;
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
	<div style="text-align:left" ><a href="user.jsp" style="font-size: 30px;text-decoration: none;">Back</a></div>
<%
		String s1=(String)session.getAttribute("loggedIn");
		
		if(s1!=null && s1.equals("yes"))
		{
				ArrayList<Book> b=(ArrayList<Book>)(session.getAttribute("historylist"));
					if(b != null) {
					%>
						<h1 style="text-align: center;color: red;">Details of books</h1>
						<table align="center" width="60%">
					<tr style="color: gray;background-color: #b0dfe8;height: 40px;">
						<th>Book ID</th>
						<th>Title</th>
						<th>Author</th>
						<th>Publisher</th>
					</tr>
					<%
						Iterator <Book> it=b.iterator();
						while(it.hasNext())
						{
							Book bo=it.next();
							int bid=bo.getBookid();
							String title=bo.getTitle();
							String author=bo.getAuthor();
							String pub=bo.getPublisher();
				%>
							<tr>
								<td><% out.print(bid); %></td>
								<td><% out.print(title); %></td>
								<td><% out.print(author); %></td>
								<td><% out.print(pub); %></td>
							</tr>
				<%
							out.print("<br>");
						}
					}
		}
					
		else
			response.sendRedirect("index.jsp");
		
				%>
	</table>
	<footer>
		<img src="images/footer_kids3.jpg"></img>
		<h3>Optum Library <sup>&reg;</sup></h3>
	</footer>
</body>
</html>