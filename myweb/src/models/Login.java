package models;

public class Login {
	private static String uname="abc";
	private static String p="1234";
	
	public Login()
	{
		
	}
	public boolean validate(String username,String password)
	{
		if(uname.equals(username) && p.equals(password))
			return true;
		else
			return false;
	}
}
