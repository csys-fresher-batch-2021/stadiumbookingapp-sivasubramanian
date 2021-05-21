package in.siva.validator;

import in.siva.model.User;

public class UserManagerValidator {

	private UserManagerValidator() {
		// Default constructor
	}

	public static boolean isValidLogin(String username, String password) {

		return UserValidator.isValidUserName(username) && UserValidator.isValidPassword(password);
	}

	public static boolean isValidRegistration(User user1) {
		String username = user1.getUserName();
		String password = user1.getPassword();
		String mobileNo = user1.getMobileNo();

		return UserValidator.isValidUserName(username) && UserValidator.isValidPassword(password)
				&& UserValidator.isValidMobileNumber(mobileNo);
	}
}
