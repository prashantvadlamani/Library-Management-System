package service;

import java.util.List;

import dao.UserDAO;
import model.User;

public class UserService {
	UserDAO userDao = new UserDAO();
	
	public List<User> getAllUsers()
	{
		List <User> userList = userDao.getAllUsers();
		return userList;
	}
	
	public User getUserForId(String id)
	{
		User user=userDao.getUserForId(id);
		return user;
	}
	
	public User createUser(User user)
	{
		User userResponse=userDao.createUser(user);
		return userResponse;
	}

	public User deleteUser(String id) {
		// TODO Auto-generated method stub
		User userResponse = userDao.deleteUser(id);
		return userResponse;
	}

	public User updateUser(User user) {
		// TODO Auto-generated method stub
		User userResponse = userDao.updateUser(user);
		return userResponse;
	}
}
