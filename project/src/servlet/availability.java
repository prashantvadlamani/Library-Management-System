package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import dao.UserDao;

/**
 * Servlet implementation class availability
 */
@WebServlet("/availability")
public class availability extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public availability() {
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
		UserDao udao= new UserDao(); 
		PrintWriter out=response.getWriter();
		int b=udao.checkAvailability(request.getParameter("id"));
		HttpSession ssn=request.getSession();
		if(ssn.getAttribute("loggedIn")!=null)
		{
			
			if(b>0)
			{
				ssn.setAttribute("available","book is available for issue");
				ssn.setAttribute("bookid",request.getParameter("id"));
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('book is available for issue');");
				   out.println("location='userSearch.jsp';");
				   out.println("</script>");
			}
			else{
				String s=udao.getReturnDate(request.getParameter("id"));
				String s1="alert('book is available for issue from "+s+"');";
				//ssn.setAttribute("available","Book is available for issue from "+s);
				out.println("<script type=\"text/javascript\">");
				   out.println(s1);
				   out.println("location='userSearch.jsp';");
				   out.println("</script>");
			}
			//RequestDispatcher dispatch=request.getRequestDispatcher("userSearch.jsp");
			//dispatch.forward(request, response);
		}
		else
			response.sendRedirect("index.jsp");
	}

}
