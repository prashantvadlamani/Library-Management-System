package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.GenericEntity;

import model.Book;
import model.User;

public class BookDAO {
	Connection con=null;
	//static HashMap<int,Book> booksMap= new HashMap<int,Book>();
	public BookDAO()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodb","root","p@ssword");
			System.out.println("connected");
		} 
			catch(ClassNotFoundException cnfe) { System.out.println("Could not load driver"); 
			}
			catch(SQLException se) {
				System.out.println("connect failed");
			}
	}
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		List<Book> b=new ArrayList<Book>();

		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from book");
			while(rs.next()) {
				int id1=rs.getInt(1);
				String title=rs.getString(2);
				String author=rs.getString(3);
				int count=rs.getInt(4);
				Book bo=new Book(id1, title, author, count);
				b.add(bo);
				//booksMap.put(bo.getBid(),bo);
				//System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public Book getBookForId(String id) {
		// TODO Auto-generated method stub
		try {
			Statement st;
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from book where bid="+id);
			while(rs.next()) {
				int id1=rs.getInt(1);
				String title=rs.getString(2);
				String author=rs.getString(3);
				int count=rs.getInt(4);
				Book bo=new Book(id1, title, author, count);
				return bo;
				//booksMap.put(bo.getBid(),bo);
				//System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		
		
		
		PreparedStatement pst;
		try {
			Statement st = con.createStatement();
			String sql="update book set title=?,publisher=?,copies=? where bid=?";
			pst = con.prepareStatement(sql);
			pst.setString(1,book.getTitle());
			pst.setString(2,book.getPublisher());
			pst.setInt(3,book.getCopies());
			pst.setInt(4,book.getBid());
			int rs=pst.executeUpdate();
			String s=book.getBid()+"";
			return getBookForId(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Book deleteBook(String id) {
		// TODO Auto-generated method stub
		try {
			Statement st = con.createStatement();
			Book b=getBookForId(id);
			int rs = st.executeUpdate("DELETE FROM book WHERE bid="+id);
			//System.out.println("row is deleted");
			return b;
			
		} catch(SQLException se) {
			System.out.println("failed to connect to db");
		}
		return null;
	}
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		try {
			int b=book.getBid();
			int c=book.getCopies();
			Statement st = con.createStatement();
			String sql="insert into book values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,b);
			pst.setString(2,book.getTitle());
			pst.setString(3,book.getPublisher());
			pst.setInt(4,c);
			System.out.println(pst);
			int rs=pst.executeUpdate();
			return book;
		} catch(SQLException se) {
			System.out.println("failed to connect to db");
		}
		return null;
	}
	
	
}
