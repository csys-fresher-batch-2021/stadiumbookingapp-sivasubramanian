package in.siva.dao;

import java.sql.SQLException;
import java.util.List;

import in.siva.exception.DbException;
import in.siva.model.Booking;
import in.siva.model.MyBookings;

public interface BookingDAO {

	/**
	 * This method is used for book seats
	 * 
	 * @param dao
	 * @throws DbException
	 * @throws SQLException
	 */
	void save(Booking dao) throws DbException, SQLException;

	/**
	 * This method is used for get my bookings.
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 */
	List<MyBookings> findMyBookings(int userId) throws DbException;

	/**
	 * This method is used for update while cancelling seat.
	 * 
	 * @param bookingId
	 * @throws DbException
	 * @throws SQLException
	 */
	void update(int bookingId) throws DbException, SQLException;

}