package in.siva.service;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import in.siva.convertor.BookingConvertor;
import in.siva.dao.BookingDAO;
import in.siva.dao.MatchDAO;
import in.siva.dao.impl.BookingDaoImpl;
import in.siva.dao.impl.MatchDaoImpl;
import in.siva.dto.BookingDTO;
import in.siva.exception.DbException;
import in.siva.exception.ServiceException;
import in.siva.model.Booking;
import in.siva.model.MyBookings;
import in.siva.validator.BookingValidator;

public class BookingManager {

	private BookingManager() {

	}

	/**
	 * This method is used for book seats
	 * 
	 * @param dao
	 * @throws DbException
	 * @throws SQLException
	 */
	public static void bookSeat(BookingDTO dto) {

		Booking bookSeat = BookingConvertor.toBooking(dto);

		try {
			BookingValidator.isValidBooking(bookSeat);
			BookingDAO bookingDao = new BookingDaoImpl();
			MatchDAO matchdao = new MatchDaoImpl();
			bookingDao.save(bookSeat);
			matchdao.updateBook(bookSeat);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());		}
	}

	/**
	 * This method is used for get my bookings.
	 * 
	 * @param userId
	 * @return
	 */
	public static List<MyBookings> getMyBookings(int userId) {
		List<MyBookings> myBookingList = new ArrayList<>();
		BookingDAO bookingDao = new BookingDaoImpl();
		try {
			myBookingList = bookingDao.findMyBookings(userId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return myBookingList;
	}

	/**
	 * This method is used for cancell seat.
	 * 
	 * @param matchId
	 * @param bookingId
	 * @param noOfTickets
	 */
	public static void cancellSeat(int matchId, int bookingId, int noOfTickets) {

		BookingValidator.isvalidcancelling(matchId, bookingId, noOfTickets);
		BookingDAO bookingDao = new BookingDaoImpl();
		MatchDAO matchdao = new MatchDaoImpl();
		try {
			bookingDao.update(bookingId);
			matchdao.updateCancell(matchId, noOfTickets);

		} catch (DbException | SQLException e) {
			throw new ServiceException(e.getMessage());
		}

	}

}
