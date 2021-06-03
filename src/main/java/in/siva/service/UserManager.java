package in.siva.service;

import java.sql.SQLException;

import in.siva.converter.UserConverter;
import in.siva.dao.UserDAO;
import in.siva.dto.UserDTO;
import in.siva.exception.DbException;
import in.siva.exception.ValidationException;
import in.siva.model.User;
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
	 * @throws DbException
	 */
	public static int login(String username, String password) throws DbException, ValidationException {

		try {
			if (UserManagerValidator.isValidLogin(username, password)) {

				return UserDAO.isExistsUsernameAndPassword(username, password);
			} else {

				throw new ValidationException("Invalid Login credentials");
			}
		} catch (Exception e) {
			throw new DbException("Unable to login");
		}

	}

	/**
	 * This method is used for register.
	 * 
	 * @param dto
	 * @return
	 * @throws DbException
	 * @throws SQLException
	 */
	public static boolean register(UserDTO dto) throws DbException, SQLException {
		boolean isRegistered = false;
		User user = UserConverter.toUser(dto);
		try {
			if (UserManagerValidator.isValidRegistration(user)) {
				UserDAO.save(user);
				isRegistered = true;
			}
		} catch (Exception e) {
			throw new DbException("Unable to register");
		}
		return isRegistered;
	}

}
