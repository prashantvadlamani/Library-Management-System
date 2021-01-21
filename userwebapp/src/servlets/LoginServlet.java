package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns={"/login"} )
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String uname="abcd";
	String p="1234";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().print("can't be viewed");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		System.out.println("uname:"+ name + "pass: "+pass);
		//System.out.print(name+" "+pass);
		Login l=new Login();
		if(l.validate(name, pass))
		{
			HttpSession ssn=request.getSession();
			ssn.setAttribute("loggedIn","yes");
			response.sendRedirect("view.jsp");
		}
		else
			response.sendRedirect("error.jsp");
	}

}
