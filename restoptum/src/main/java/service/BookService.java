package service;

import java.util.List;

import dao.BookDAO;
import model.Book;

public class BookService {
	BookDAO bookDao = new BookDAO();
	
	public List<Book> getAllBooks()
	{
		List <Book> bookList = bookDao.getAllBooks();
		return bookList;
	}
	
	public Book getBookForId(String id)
	{
		Book book=bookDao.getBookForId(id);
		return book;
	}
	
	/*public Book createBook(Book book)
	{
		Book bookResponse=bookDao.createBook(book);
		return bookResponse;
	}*/

	public Book deleteBook(String id) {
		// TODO Auto-generated method stub
		Book bookResponse = bookDao.deleteBook(id);
		return bookResponse;
	}

	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		Book bookResponse = bookDao.updateBook(book);
		return bookResponse;
	}

	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		Book bookResponse = bookDao.createBook(book);
		return bookResponse;
	}
}
