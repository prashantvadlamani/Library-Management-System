package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import connection.MyConnection;

public class RegisterDao {
	Connection con=null;
	
	public RegisterDao()
	{
		MyConnection mycon = new MyConnection();
		con=mycon.getConnection();
	}
	public void add(String uname,String pass,String utype)
	{
		try {
			
			String sql="insert into users values(?,?,?)";
			System.out.println("in add");
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,uname);
			pst.setString(2,pass);
			pst.setString(3,utype);
			//System.out.println(uname+","+pass);
			int rs=pst.executeUpdate();
			System.out.println("row is added");
			
		} catch(SQLException se) {
			System.out.println("failed to connect to db");
		}
	}
}
