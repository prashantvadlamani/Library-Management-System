package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.MyConnection;

public class LoginDao {
Connection con=null;
	
	public LoginDao()
	{
		MyConnection mycon = new MyConnection();
		con=mycon.getConnection();
	}
	
	public boolean verify(String uname,String pass)
	{
		String u;
		String p = "";
		u=uname;
		try {
			String sql = "select password from users where username='"+uname+"'";
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				p=rs.getString(1);
			}
			System.out.println(p);
			if(p.equals(pass))
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return false;
	}
	
	public String getType(String uname)
	{
		String p=null;
		try{
			String sql = "select usertype from users where username='"+uname+"'";
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				p=rs.getString(1);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return p;
	}
}
