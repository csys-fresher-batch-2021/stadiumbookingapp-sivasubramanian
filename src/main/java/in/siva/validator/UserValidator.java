package in.siva.validator;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import in.siva.exception.ValidationException;

public class UserValidator {

	private UserValidator() {
		// Default constructor
	}

	/**
	 * This method is used to validate the user name.
	 * 
	 * @param name
	 * @return
	 */
	public static boolean isValidUserName(String name) {

		boolean valid = true;
		if (name == null || name.trim().equals("") || name.trim().length() < 3) {
			throw new ValidationException("Invalid Login credentials");
		}
		return valid;
	}

	/**
	 * This method is used to validate the password.
	 * 
	 * @param password
	 * @return
	 */
	public static boolean isValidPassword(String password) {
		String check1 = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])(?=\\S+$).{8,20}$";
		Pattern p = Pattern.compile(check1);
		Matcher m = p.matcher(password);
		if (m.matches()) {
			return true;
		} else {
			throw new ValidationException("Invalid Login credentials");
		}
	}

}
