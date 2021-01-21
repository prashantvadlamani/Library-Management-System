package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.MyConnection;
import dao.LoginDao;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		MyConnection mycon = new MyConnection();
		Connection con=mycon.getConnection();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		System.out.println(uname+","+pass);
		PrintWriter out = response.getWriter();
		LoginDao ldao= new LoginDao();
		if(ldao.verify(uname,pass))
		{
			HttpSession ssn=request.getSession();
			ssn.setAttribute("loggedIn","yes");
			ssn.setAttribute("uname",uname);
			String type=ldao.getType(uname);
			if(type.equals("librarian"))
				response.sendRedirect("librarian.jsp");
			else
				response.sendRedirect("user.jsp");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('User or password incorrect');");
			   out.println("location='index.jsp';");
			   out.println("</script>");
		}
	}

}
