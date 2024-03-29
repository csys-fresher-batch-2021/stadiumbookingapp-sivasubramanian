package in.siva.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.siva.dao.UserDAO;
import in.siva.exception.DbException;
import in.siva.model.User;
import in.siva.util.ConnectionUtil;

public class UserDaoImpl implements UserDAO {

	public UserDaoImpl() {
		super();
	}

	/**
	 * This method is used to check username and password are exists or not.
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@Override
	public int isExistsUsernameAndPassword(String username, String password) throws DbException, SQLException {
		int userId = 0;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from users where user_name = ? and password =?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if (rs.next()) {

				userId = rs.getInt(1);

			}
		} catch (Exception e) {
			throw new DbException("Unable to login");
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return userId;

	}

	/**
	 * This method is used to register user details to database.
	 * 
	 * @param user1
	 * @throws DbException
	 * @throws SQLException
	 */
	@Override
	public void save(User user1) throws DbException, SQLException {

		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String insertQuery = "insert into users (user_name,password,mobile_number) values (?,?,?)";
			pst = connection.prepareStatement(insertQuery);
			pst.setString(1, user1.getUserName());
			pst.setString(2, user1.getPassword());
			pst.setLong(3, Long.parseLong(user1.getMobileNo()));
			pst.executeUpdate();
		} catch (Exception e) {
			throw new DbException("Unable to register");
		} finally {
			ConnectionUtil.close(connection, pst);
		}
	}

}
