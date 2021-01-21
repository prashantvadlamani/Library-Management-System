<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
<%@page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books Details</title>
<style>
	tr:nth-child(odd) {background-color: #d2d2d2;}
	h3{
		color: red;
		text-align: center;
	}
	div{
		background-color: #b0dfe8;
		height:30px;
	}
	a:hover { 
    color: white;
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
	footer{
		margin-bottom: 0px;
		position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    color: white;
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
    padding: 8px;
    
}
</style>
</head>
<body>

	<div>
	<ul>
  <li><a href="librarian.jsp">Home</a></li>
  <li><a href="libhistory">Get History</a></li>
  <li><a href="add">Add a book</a></li>
  <li><a href="logout">Logout</a></li>
</ul>
</div>
<%
		
		String s=(String)session.getAttribute("loggedIn");
		
		

		if(s!=null && s.equals("yes"))
		{
			ArrayList<Book> b=(ArrayList<Book>)(session.getAttribute("booklist"));
					if(b != null) {
						if(b.size()>0){
					%>
						<h1 style="text-align: center;color: red;">Details of all books</h1>
						<table align="center" width="60%">
					<tr style="color: gray;background-color: #b0dfe8;height: 40px;">
						<th>Book ID</th>
						<th>Title</th>
						<th>Author</th>
						<th>Publisher</th>
						<th>Copies</th>
						<th>Action</th>
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
							int cop=bo.getCopies();
				%>
							<tr height="20px;">
								<td><% out.print(bid); %></td>
								<td><% out.print(title); %></td>
								<td><% out.print(author); %></td>
								<td><% out.print(pub); %></td>
								<td><% out.print(cop); %></td>
								<td><a href="Delete?id=<%=bid%>"> del</a> | <a href="edit1?id=<%=bid%>">edit</a> </td>
							</tr>
				<%
							out.print("<br>");
						}
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