package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import dao.LibrarianDao;

/**
 * Servlet implementation class edit1
 */
@WebServlet("/edit1")
public class edit1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LibrarianDao ldao=new LibrarianDao();
		Book b=ldao.getById(request.getParameter("id"));
		HttpSession ssn=request.getSession();
		if(ssn.getAttribute("loggedIn")!=null)
		{
			ssn.setAttribute("id",b.getBookid());
			ssn.setAttribute("title",b.getTitle());
			ssn.setAttribute("author",b.getAuthor());
			ssn.setAttribute("publisher",b.getPublisher());
			ssn.setAttribute("copies",b.getCopies());
			response.sendRedirect("edit.jsp");
		}
		else
			response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
