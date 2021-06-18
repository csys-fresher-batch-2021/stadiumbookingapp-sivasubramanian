package in.siva.dao;

import java.sql.SQLException;
import java.util.List;

import in.siva.exception.DbException;
import in.siva.model.Booking;
import in.siva.model.MatchDetail;
import in.siva.model.Seats;

public interface MatchDAO {

	/**
	 * This method is used for list matches which is sorted by date.
	 * 
	 * @return
	 * @throws DbException
	 */
	List<MatchDetail> findAllByOrderByDateAsc() throws DbException;

	/**
	 * This method is used for get available and booked seats
	 * 
	 * @param stadiumName
	 * @param matchDate
	 * @return
	 * @throws DbException
	 */
	List<Seats> findByMatchDate(String stadiumName, String matchDate) throws DbException;

	/**
	 * This method is used for list matches which is after current date.
	 * 
	 * @return
	 * @throws DbException
	 */
	List<MatchDetail> findByAfterCurrentDate() throws DbException;

	/**
	 * This method returns avilable seats.
	 * 
	 * @param matchDate
	 * @return
	 * @throws DbException
	 */
	int findAvailableSeats(String matchDate) throws DbException;

	/**
	 * This method is used for update available and booked seats while booking.
	 * 
	 * @param dao
	 * @throws DbException
	 * @throws SQLException
	 */
	void updateBook(Booking dao) throws DbException, SQLException;

	/**
	 * This method is used for update available and booked seats while cancelling.
	 * 
	 * @param matchId
	 * @param noOfTickets
	 * @throws DbException
	 * @throws SQLException
	 */
	void updateCancell(int matchId, int noOfTickets) throws DbException, SQLException;

}