<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
	tr:nth-child(odd) {background-color: #d2d2d2;}
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
	div{
		background-color: #b0dfe8;
		height:50px;
	}
	h3{
		color: red;
		text-align: center;
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
<title>History page</title>
</head>
<body>
<div>
	<ul>
  <li><a href="librarian.jsp">Home</a></li>
  <li><a href="add">Add a book</a></li>
  <li><a href="librarianServlet">Get All Books</a></li>
  <li><a href="logout">Logout</a></li>
</ul>
</div>
<%
		String s1=(String)session.getAttribute("loggedIn");
		
		if(s1!=null && s1.equals("yes"))
		{
			ArrayList<BookHistory> b=(ArrayList<BookHistory>)(session.getAttribute("lhistorylist"));
					if(b != null) {
					%>
						<h1 style="text-align: center;color: red;">History details of books</h1>
						<table  align="center" width="60%">
					<tr style="color: gray;background-color: #b0dfe8;height: 40px;">
						<th>Book ID</th>
						<th>Title</th>
						<th>Author</th>
						<th>Publisher</th>
						<th>Username</th>
						<th>IssueDate</th>
						<th>ReturnDate</th>
					</tr>
					<%
						Iterator <BookHistory> it=b.iterator();
						while(it.hasNext())
						{
							BookHistory bh=it.next();
							Book bo=bh.getB();
							int bid=bo.getBookid();
							String title=bo.getTitle();
							String author=bo.getAuthor();
							String pub=bo.getPublisher();
							String uname=bh.getU();
							String id=bh.getI();
							String rd=bh.getR();
				%>
							<tr>
								<td><% out.print(bid); %></td>
								<td><% out.print(title); %></td>
								<td><% out.print(author); %></td>
								<td><% out.print(pub); %></td>
								<td><% out.print(uname); %></td>
								<td><% out.print(id); %></td>
								<td><% out.print(rd); %></td>
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