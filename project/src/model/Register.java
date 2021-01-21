package model;

public class Register {
	int userid;
	String username;
	String password;
	String usertype;
	
	public Register(){}
	
	public Register(String username, String password,
			String usertype) {
		super();
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "Register [username=" + username
				+ ", password=" + password + ", usertype=" + usertype + "]";
	}
	
	
	
}
