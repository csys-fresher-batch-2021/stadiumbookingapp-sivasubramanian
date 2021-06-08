package in.siva.validator;

import in.siva.exception.ValidationException;

public class InputValidator {

	private InputValidator() {

	}

	public static boolean isValidString(String input) {
		boolean valid = true;
		if (input == null || input.trim().equals("")) {
			valid = false;
		}
		return valid;
	}

	public static boolean isValidNumber(int input) {
		boolean valid = true;
		if (input <= 0) {
			valid = false;
		}
		return valid;
	}

	public static void isValidNameAndDate(String name, String date) {

		if (!isValidString(name) || !isValidString(date)) {
			throw new ValidationException("Input cannot be null");
		}

	}

}
