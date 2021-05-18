package in.siva.service;

import in.siva.exception.ValidationException;
import in.siva.validator.UserManagerValidator;

public class UserManager {

	private UserManager() {
		// Default Constructor
	}

	/**
	 * This method is used for login.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password) {

		if (UserManagerValidator.isValidLogin(username, password)) {

			return true;
		} else {

			throw new ValidationException("Not Registered");
		}

	}

}
