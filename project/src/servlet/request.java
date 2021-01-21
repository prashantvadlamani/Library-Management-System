package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import dao.LibrarianDao;
import dao.UserDao;

/**
 * Servlet implementation class request
 */
@WebServlet("/request")
public class request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public request() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao udao = new UserDao();
		PrintWriter out = response.getWriter();
		LibrarianDao ldao=new LibrarianDao();
		HttpSession ssn=request.getSession();
		if(ssn.getAttribute("loggedIn")!=null)
		{
			//udao.addRequest(request.getParameter("id"),(String)ssn.getAttribute("uname"));
			try{
			ldao.issue(request.getParameter("id"),(String)ssn.getAttribute("uname"));
			/*ssn.setAttribute("valid","book is issued");
			RequestDispatcher dispatch=request.getRequestDispatcher("user.jsp");
			dispatch.forward(request, response);*/
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('book is isuued to you');");
			   out.println("location='userSearch.jsp';");
			   out.println("</script>");
			}catch(SQLException se)
			{
				/*ssn.setAttribute("valid","book is already taken");
				RequestDispatcher dispatch=request.getRequestDispatcher("user.jsp");
				dispatch.forward(request, response);
				{String c1=(String)session.getAttribute("valid");
					if(c1!=null)
					{

					out.print("<br>"+c1);
				}}
				 */
				
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('book is already taken by you');");
				   out.println("location='userSearch.jsp';");
				   out.println("</script>");
			}
		}
		else
			response.sendRedirect("index.jsp");
	}

}
