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
import model.BookHistory;
import dao.LibrarianDao;
import dao.UserDao;

/**
 * Servlet implementation class libhistory
 */
@WebServlet("/libhistory")
public class libhistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public libhistory() {
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
		HttpSession ssn=request.getSession();
		if(ssn.getAttribute("loggedIn")!=null)
		{
			String name=(String) ssn.getAttribute("uname");
			ArrayList <BookHistory> list = new ArrayList<BookHistory>();
			LibrarianDao ldao=new LibrarianDao();
			list=ldao.getHistory(name);
			ssn.setAttribute("lhistorylist",list);
			RequestDispatcher dispatch=request.getRequestDispatcher("libHistory.jsp");
			dispatch.forward(request, response);
		}
		else
			response.sendRedirect("index.jsp");
	}
}

