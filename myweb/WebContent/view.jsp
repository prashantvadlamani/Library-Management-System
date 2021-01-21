<%@page import="java.util.*"%>
<%@page import="models.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Viewer</title>
</head>
<body>
	<h1>Details of books</h1>
	<table border="1">
		<tr>
			<th>Book ID</th>
			<th>Title</th>
			<th>Publisher</th>
			<th>Copies</th>
			<th>Action</th>
		</tr>
	
	<%
		//String name=(String)request.getParameter("pass");
		//out.print(name);
		String s=(String)session.getAttribute("loggedIn");
		
		if(s!=null && s.equals("yes"))
		{
			ArrayList<Books> b=(ArrayList<Books>)(session.getAttribute("booklist"));
			if(b != null) {
				Iterator <Books> it=b.iterator();
				while(it.hasNext())
				{
					Books bo=it.next();
					int bid=bo.getBid();
					String title=bo.getTitle();
					String pub=bo.getPublisher();
					int cop=bo.getCopies();
					%>
					<tr>
						<td><% out.print(bid); %></td>
						<td><% out.print(title); %></td>
						<td><% out.print(pub); %></td>
						<td><% out.print(cop); %></td>
						<td><a href="Delete?id=<%=bid%>"> del</a> | <a href="edit.jsp?id=<%=bid%>">edit</a> </td>
					</tr>
					<%
					out.print("<br>");
				}
			}
		}
		else
			response.sendRedirect("login.jsp");
	%>
	</table>
	
	<a href="add">add a row</a>
</body>
</html>