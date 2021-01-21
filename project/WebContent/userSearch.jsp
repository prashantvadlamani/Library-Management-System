<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Searched details</title>
<style>
	tr:nth-child(odd) {background-color: #d2d2d2;}
	div{
		background-color: #b0dfe8;
		height:50px;
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
	h3{
		color: red;
		text-align: center;
	}
</style>
</head>
<body>
	<div style="text-align:left" ><a href="user.jsp" style="font-size: 30px;text-decoration: none;">Back</a></div>
<%
		String s=(String)session.getAttribute("loggedIn");
		
		if(s!=null && s.equals("yes"))
		{
				ArrayList<Book> b=(ArrayList<Book>)(session.getAttribute("booklist"));
					if(b != null) {
						if(b.size()>0){
					%>
						<h1 style="text-align: center;color: red;">Details of searched books</h1>
						<table align="center" width="60%">
					<tr style="color: gray;background-color: #b0dfe8;height: 40px;">
						<th>Book ID</th>
						<th>Title</th>
						<th>Author</th>
						<th>Publisher</th>
						<th>Action</th>
					</tr>
					<%
						Iterator <Book> it=b.iterator();
						while(it.hasNext())
						{
							Book bo=it.next();
							int bid=bo.getBookid();
							String title=bo.getTitle();
							String author = bo.getAuthor();
							String pub=bo.getPublisher();
				%>
							<tr>
								<td><% out.print(bid); %></td>
								<td><% out.print(title); %></td>
								<td><% out.print(author); %></td>
								<td><% out.print(pub); %></td>
								<td>Check<a href="availability?id=<%=bid%>"> Availability</a>
							</tr>
				<%
							out.print("<br>");
						}
						}
						else
							out.print("book not found");
					}
					
		}	
		else
			response.sendRedirect("login.jsp");
		
				%>
	</table>
	
	<%
	if(s!=null && s.equals("yes"))
	{
		String c=(String)session.getAttribute("available");
		if(c!= null)
		{
			if(c.equals("book is available for issue"))
			{
				//String c2=(String)session.getAttribute("uname");
				String c1=(String)session.getAttribute("bookid");
				//System.out.println(c1+","+c2);
				//out.print(c);*/
				%>
				<div style="text-align: center"><br><a href="request?id=<%=c1%>">Get Book</a></div>
				<%
			}
			else
			{
					//out.print(c);
			}
		}
		
	}%>
	<br>
	<footer>
		<img src="images/footer_kids3.jpg"></img>
		<h3>Optum Library <sup>&reg;</sup></h3>
	</footer>
</body>
</html>