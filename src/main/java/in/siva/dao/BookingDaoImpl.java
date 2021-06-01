package in.siva.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.siva.exception.DbException;
import in.siva.model.Booking;
import in.siva.util.ConnectionUtil;

public class BookingDaoImpl {

	public BookingDaoImpl() {
		super();
	}

	/**
	 * This method is used for book seats
	 * 
	 * @param dao
	 * @throws DbException
	 * @throws SQLException
	 */
	public void save(Booking dao) throws DbException, SQLException {

		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String insertQuery = "insert into booking_details (user_id,match_id,seat_type,no_of_seats,total_amount) values (?,?,?,?,?)";
			pst = connection.prepareStatement(insertQuery);
			pst.setInt(1, dao.getUserId());
			pst.setInt(2, dao.getMatchId());
			pst.setString(3, dao.getSeatType());
			pst.setInt(4, dao.getNoOfSeats());
			pst.setInt(5, dao.getTotalAmount());

			pst.executeUpdate();

		} catch (Exception e) {
			throw new DbException("Unable to register");
		} finally {
			ConnectionUtil.close(connection, pst);
		}
	}

}
