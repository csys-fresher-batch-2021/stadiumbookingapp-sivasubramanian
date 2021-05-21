package in.siva.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {

	private ConnectionUtil() {

	}

	/**
	 * This method is used to connect database.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		Connection connection = null;
		String driverClass = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost/stadium_db";
		String username = "postgres";
		String password = "Siva@17104061";
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new SQLException(e);
		}
		return connection;
	}

	/**
	 * This method is used for close connection.
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 * @throws SQLException
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {

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
			throw new SQLException(e);
		}
	}

	/**
	 * This method is used for close connection.
	 * 
	 * @param conn
	 * @param stmt
	 * @throws SQLException
	 */
	public static void close(Connection conn, Statement stmt) throws SQLException {

		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new SQLException(e);
		}
	}

}
