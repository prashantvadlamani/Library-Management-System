package models;

import java.sql.*;
import java.util.ArrayList;

public class MyServletDao {
	
	Connection con = null;
	
	public MyServletDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
		} catch(ClassNotFoundException ce) {
			System.out.println("Could not load driver");
		}
		
	}
	
	public ArrayList<Books> getAll()
	{
		ArrayList<Books> list=new ArrayList<>();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodb", "root", "p@ssword");
			System.out.println("db connected");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from book");
			while(rs.next()) {
				int id1=rs.getInt(1);
				String title=rs.getString(2);
				String author=rs.getString(3);
				int count=rs.getInt(4);
				Books b=new Books(id1, title, author, count);
				list.add(b);
				//System.out.println(rs.getString(2));
			}
		} catch(SQLException se) {
			System.out.println("failed to connect to db");
		}
		return list;
	}
	
	public void delete(String bid)
	{
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodb", "root", "p@ssword");
			System.out.println("db connected");
			Statement st = con.createStatement();
			int rs = st.executeUpdate("DELETE FROM book WHERE bid="+bid);
			System.out.println("row is deleted");
			
		} catch(SQLException se) {
			System.out.println("failed to connect to db");
		}
	}
	
	public void update(String bid,String title,String publisher,String copies)
	{
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodb", "root", "p@ssword");
			int b=Integer.parseInt(bid);
			int c=Integer.parseInt(copies);
			System.out.println("db connected");
			Statement st = con.createStatement();
			//System.out.println(bid+","+title+","+publisher+","+copies);
			String sql="update book set title=?,publisher=?,copies=? where bid=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,title);
			pst.setString(2,publisher);
			pst.setInt(3,c);
			pst.setInt(4,b);
			System.out.println(pst);
			int rs=pst.executeUpdate();
			System.out.println("row is updated");
			
		} catch(SQLException se) {
			System.out.println("failed to connect to db");
		}
	}
	
	public void add(String bid,String title,String publisher,String copies)
	{
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodb", "root", "p@ssword");
			int b=Integer.parseInt(bid);
			int c=Integer.parseInt(copies);
			System.out.println("db connected");
			Statement st = con.createStatement();
			//System.out.println(bid+","+title+","+publisher+","+copies);
			String sql="insert into book values(?,?,?,?)";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,b);
			pst.setString(2,title);
			pst.setString(3,publisher);
			pst.setInt(4,c);
			System.out.println(pst);
			int rs=pst.executeUpdate();
			System.out.println("row is added");
			
		} catch(SQLException se) {
			System.out.println("failed to connect to db");
		}
	}
	
}
