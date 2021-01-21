package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LibrarianDao;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("add.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ssn=request.getSession();
		PrintWriter out=response.getWriter();
		if(ssn.getAttribute("loggedIn")!=null)
		{
			LibrarianDao ldao = new LibrarianDao();
			String author=request.getParameter("author");
			String title=request.getParameter("title");
			String publisher=request.getParameter("publisher");
			String copies=request.getParameter("copies");
			System.out.println(author+","+title+","+publisher+","+copies);
			if(author=="" || copies=="" || publisher=="" || title=="")
			{
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('all fields are mandatory');");
				   out.println("location='add.jsp';");
				   out.println("</script>");
			}
			else{
			ldao.add(title,author,publisher, copies);
			response.sendRedirect("librarianServlet");
			}
		}
		else
			response.sendRedirect("index.jsp");
	}

}
