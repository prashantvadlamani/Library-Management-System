package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Book;
import model.BookHistory;
import connection.MyConnection;

public class LibrarianDao {
	Connection con=null;
	public LibrarianDao()
	{
		MyConnection mycon = new MyConnection();
		con=mycon.getConnection();
	}
	
	public ArrayList<Book> getAll()
	{
		ArrayList<Book> list=new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from book");
			while(rs.next()) {
				int id1=rs.getInt(1);
				String title=rs.getString(2);
				String author=rs.getString(3);
				String publisher=rs.getString(4);
				int count=rs.getInt(5);
				Book b=new Book(id1, title, author,publisher,count);
				list.add(b);
				//System.out.println(rs.getString(2));
			}
		} catch(SQLException se) {
			System.out.println("failed to connect to db");
		}
		return list;
	}
	
	public Book getById(String bid)
	{
		Book b = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from book where bookid="+bid);
			while(rs.next()) {
				int id1=rs.getInt(1);
				String title=rs.getString(2);
				String author=rs.getString(3);
				String publisher=rs.getString(4);
				int count=rs.getInt(5);
				b=new Book(id1,title,author,publisher,count);
				//System.out.println(rs.getString(2));
			}
		} catch(SQLException se) {
			System.out.println("failed to connect to db");
		}
		return b;
	}
	
	public void add(String title,String author,String publisher,String copies)
	{
		try {
			int c=Integer.parseInt(copies);
			Statement st = con.createStatement();
			String sql="insert into book(title,author,publisher,copies) values(?,?,?,?)";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,title);
			pst.setString(2,author);
			pst.setString(3,publisher);
			pst.setInt(4,c);
			//System.out.println(pst);
			int rs=pst.executeUpdate();
			//System.out.println("row is added");
			
		} catch(SQLException se) {
			System.out.println("failed to connect to db");
		}
	}
	
	public void delete(String bid)
	{
		try {
			Statement st = con.createStatement();
			int rs = st.executeUpdate("DELETE FROM book WHERE bookid="+bid);
			System.out.println("row is deleted");
			
		} catch(SQLException se) {
			System.out.println("failed to connect to db");
		}
	}
	
	public void update(String bid,String title,String author,String publisher,String copies)
	{
		try {
			int b=Integer.parseInt(bid);
			int c=Integer.parseInt(copies);
			Statement st = con.createStatement();
			String sql="update book set title=?,author=?,publisher=?,copies=? where bookid=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,title);
			pst.setString(2,author);
			pst.setString(3,publisher);
			pst.setInt(4,c);
			pst.setInt(5,b);
			//System.out.println(pst);
			int rs=pst.executeUpdate();
			System.out.println("row is updated");
			
		} catch(SQLException se) {
			System.out.println("failed to connect to db");
		}
	}
	
	public void issue(String bid,String uname) throws SQLException
	{		
			int b=Integer.parseInt(bid);
			int co=0;
			LocalDate issue=LocalDate.now();
			LocalDate returnd=issue.plusDays(10);
			String sql="insert into bookissue values(?,?,'"+issue+"','"+returnd+"')";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,uname);
			pst.setInt(2,b);
			//System.out.println(pst);
			int r=pst.executeUpdate();
			System.out.println("row is added to bookissue");
			String count="select copies from book where bookid="+bid;
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(count);
			while(rs.next())
				co=rs.getInt(1);
			co--;
			System.out.println(co);
			String c="update book set copies="+co+" where bookid="+bid;
			PreparedStatement ps=con.prepareStatement(c);
			ps.executeUpdate();
	}
	
	public ArrayList<BookHistory> getHistory(String name)
	{
		ArrayList<BookHistory> list=new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from book  join bookissue using (bookid)");
			while(rs.next()) {
				int id1=rs.getInt(1);
				String title=rs.getString(2);
				String author=rs.getString(3);
				String publisher=rs.getString(4);
				int count=rs.getInt(5);
				String uname=rs.getString(6);
				String id=rs.getDate(7).toString();
				String rd=rs.getDate(8).toString();
				Book b=new Book(id1, title, author,publisher,count);
				BookHistory bh= new BookHistory(b,uname,id,rd);
				list.add(bh);
				//System.out.println(rs.getString(2));
			}
		} catch(SQLException se) {
			System.out.println("failed to connect to db");
		}
		return list;
	}
}
