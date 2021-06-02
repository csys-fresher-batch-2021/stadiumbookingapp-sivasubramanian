package in.siva.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.siva.exception.DbException;

public class ConnectionUtil {

	private ConnectionUtil() {

	}

	/**
	 * This method is used to connect database.
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws DbException {

		Connection connection = null;
		String driverClass = System.getenv("spring.datasource.driver-class-name");
		String url = System.getenv("spring.datasource.url");
		String username = System.getenv("spring.datasource.username");
		String password = System.getenv("spring.datasource.password");
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException("Unable to connect");
		}
		return connection;
	}

	/**
	 * This method is used for close connection.
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 * @throws DbException
	 * @throws SQLException
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) throws DbException {

		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new DbException("Unable to close");
		}
	}

	/**
	 * This method is used for close connection.
	 * 
	 * @param conn
	 * @param stmt
	 * @throws SQLException
	 * @throws DbException
	 */
	public static void close(Connection conn, Statement stmt) throws SQLException, DbException {

		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new DbException("Unable to close");
		}
	}

}
