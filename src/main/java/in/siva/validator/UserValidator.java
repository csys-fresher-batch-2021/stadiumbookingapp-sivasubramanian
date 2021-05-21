package in.siva.validator;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

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
			valid = false;
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
		boolean valid = false;
		String check1 = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])(?=\\S+$).{8,20}$";
		Pattern p = Pattern.compile(check1);
		Matcher m = p.matcher(password);
		if (m.matches()) {
			valid = true;
		}
		return valid;
	}

	public static boolean isValidMobileNumber(String mobileNo) {
		boolean validMobileNo = false;
		if (mobileNo != null && mobileNo.trim().length() == 10) {
			String regex = "[6-9][0-9]{9}";
			validMobileNo = mobileNo.matches(regex);
		}
		return validMobileNo;
	}

}
