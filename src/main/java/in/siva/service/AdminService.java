package in.siva.service;

import in.siva.exception.ServiceException;
import in.siva.validator.AdminValidator;

public class AdminService {

	private AdminService() {
		
	}
	public static void checkAdminLogin(String username,String password) {
		
		try {
			AdminValidator.isValidAdmin(username, password);
		} catch (Exception e) {
			throw new ServiceException("Invalid Login Credentials");
		}
	}
}
