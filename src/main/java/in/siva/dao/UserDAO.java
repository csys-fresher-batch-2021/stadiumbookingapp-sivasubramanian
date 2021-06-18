package in.siva.dao;

import java.sql.SQLException;

import in.siva.exception.DbException;
import in.siva.model.User;

public interface UserDAO {

	/**
	 * This method is used to check username and password are exists or not.
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	int isExistsUsernameAndPassword(String username, String password) throws DbException, SQLException;

	/**
	 * This method is used to register user details to database.
	 * 
	 * @param user1
	 * @throws DbException
	 * @throws SQLException
	 */
	void save(User user1) throws DbException, SQLException;

}