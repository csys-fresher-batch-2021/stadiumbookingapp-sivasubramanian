package in.siva.validator;

import in.siva.exception.ValidationException;
import in.siva.model.Admin;

public class AdminValidator {
	
	private AdminValidator() {
		
	}
	
	public static void isValidAdmin(String username,String password) {
		
		Admin admin = new Admin();
		String adminUserName=admin.getUsername();
		String adminPassword=admin.getPassword();
		if (username == null || username.trim().equals("")||username.trim().length()<2) {
			throw new ValidationException("User Name Cannot be Null");
		}
		if (password == null || password.trim().equals("")) {
			throw new ValidationException("Password Cannot be Null");
		}
		if (!username.equals(adminUserName)) {
			throw new ValidationException("Invalid UserName");
		}
		if (!password.equals(adminPassword)) {
			throw new ValidationException("Invalid Password");
		}
		
	}

}
