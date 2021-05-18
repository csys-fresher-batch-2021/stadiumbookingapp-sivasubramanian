package in.siva.dao;

import java.util.HashSet;

import java.util.Set;

import in.siva.model.User;

public class LoginDAO {

	private LoginDAO() {

	}

	private static final Set<User> userList = new HashSet<>();
	static {
		User user1 = new User("siva", "Siva@123456", "9790174736");
		userList.add(user1);
	}

	/**
	 * This method is used to check username and password are exists or not.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean isExistsUsernameAndPassword(String username, String password) {
		boolean loggedIn = false;
		for (User user : userList) {
			if (user.getUserName().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				loggedIn = true;
				break;
			}
		}
		return loggedIn;
	}
}
