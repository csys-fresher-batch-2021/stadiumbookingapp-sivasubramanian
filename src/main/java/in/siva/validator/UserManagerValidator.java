package in.siva.validator;

public class UserManagerValidator {

	private UserManagerValidator() {
		// Default constructor
	}

	public static boolean isValidLogin(String username, String password) {
		return UserValidator.isValidUserName(username) && UserValidator.isValidPassword(password);
	}
}
