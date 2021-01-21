package resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import service.BookService;
import model.Book;

@XmlRootElement
@Path("/bookInfo")

public class BookResource {
	BookService bookService=new BookService();
	
	//CRUD -- CREATE operation
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Book createBook(Book book)
	{
		Book bookResponse=bookService.createBook(book);
		return bookResponse;
	}
	
	// CRUD -- READ operation
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks()
	{
		List<Book> bookList = bookService.getAllBooks();
		System.out.println(bookList);
		return bookList;
	}
	
	// CRUD -- READ operation with parameters
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookForId(@PathParam("id") String id)
	{
		Book book = bookService.getBookForId(id);
		return book;
	}
	
	// CRUD -- UPDATE operation
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Book updateBook(Book book)
	{
		Book bookResponse= bookService.updateBook(book);
		return bookResponse;
	}
	
	// CRUD -- DELETE operation
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Book deleteBook(@PathParam("id") String id)
	{
		Book bookResponse = bookService.deleteBook(id);
		return bookResponse;
	}
}
