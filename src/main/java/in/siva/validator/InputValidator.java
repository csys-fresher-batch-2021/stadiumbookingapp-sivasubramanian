package in.siva.validator;

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
		if (input < 0) {
			valid = false;
		}
		return valid;
	}

}
