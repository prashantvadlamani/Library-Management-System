package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Book;
import connection.MyConnection;

public class UserDao {
	Connection con=null;
	public UserDao()
	{
		MyConnection mycon = new MyConnection();
		con=mycon.getConnection();
	}
	
	public ArrayList<Book> search(String type,String key)
	{
		ArrayList<Book> list=new ArrayList<>();
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from book where "+type+"='"+key+"'");
			
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
	
	public int checkAvailability(String bid)
	{
		int count=0;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select copies from book where bookid="+bid);
			while(rs.next()) {
				count=rs.getInt(1);
			}
		} catch(SQLException se) {
			System.out.println("failed to connect to db");
		}
	return count;
	}
	
	public void addRequest(String bid,String uname)
	{
		try {
			String sql="insert into request values(?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			int b=Integer.parseInt(bid);
			System.out.println(bid+","+uname);
			pst.setInt(1,b);
			pst.setString(2,uname);
			int rs=pst.executeUpdate();
			System.out.println("row is added");
		} catch(SQLException se) {
			System.out.println("failed to connect to db");
		}
	}
	
	public ArrayList<Book> getHistory(String name)
	{
		ArrayList<Book> list=new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from book  join bookissue using (bookid) where username='"+name+"'");
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
	
	public String getReturnDate(String bid)
	{
		String s="";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select returndate from bookissue where bookid="+bid+" order by returndate asc limit 1");
			while(rs.next()) {
				s=rs.getDate(1).toString();
				//System.out.println(rs.getString(2));
			}
		} catch(SQLException se) {
			System.out.println("failed to connect to db");
		}
		return s;
	}
}
