package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import dao.LibrarianDao;

/**
 * Servlet implementation class librarianServlet
 */
@WebServlet("/librarianServlet")
public class librarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public librarianServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LibrarianDao ldao = new LibrarianDao();
		ArrayList<Book> b=new ArrayList<>();
		b=ldao.getAll();
		HttpSession ssn=request.getSession();
		if(ssn.getAttribute("loggedIn")!=null)
		{
			ssn.setAttribute("booklist",b);
			RequestDispatcher dispatch=request.getRequestDispatcher("libgetAll.jsp");
			dispatch.forward(request, response);
		}
		else
			response.sendRedirect("index.jsp");
	}

}
