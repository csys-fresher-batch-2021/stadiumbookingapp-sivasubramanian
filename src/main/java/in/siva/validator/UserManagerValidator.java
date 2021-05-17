package in.siva.validator;

import in.siva.dao.LoginDAO;

public class UserManagerValidator {

	private UserManagerValidator() {
		// Default constructor
	}

	public static boolean isValidLogin(String username, String password) {
		boolean exists = false;
		if (UserValidator.isValidUserName(username) && UserValidator.isValidPassword(password)) {
			exists = LoginDAO.isExistsUsernameAndPassword(username, password);
		}
		return exists;
	}

}
