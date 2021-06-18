package in.siva.validator;

import in.siva.dao.MatchDAO;
import in.siva.dao.impl.MatchDaoImpl;
import in.siva.exception.DbException;
import in.siva.exception.ValidationException;
import in.siva.model.Booking;

public class BookingValidator {

	private BookingValidator() {

		// Default constructor
	}

	public static void isValidBooking(Booking book) {

		MatchDAO matchDao = new MatchDaoImpl();
		int noOfSeats = book.getNoOfSeats();
		try {
			int availableSeats = matchDao.findAvailableSeats(book.getMatchDate());
			int totalAmount = book.getTotalAmount();
			String seatType=book.getSeatType();
			if(!InputValidator.isValidString(seatType)) {
				throw new ValidationException("Choose seat type");
			}
			if (!InputValidator.isValidNumber(noOfSeats) || !InputValidator.isValidNumber(totalAmount)) {
				throw new ValidationException("Invalid input");
			}
			if( noOfSeats > availableSeats) {
				throw new ValidationException("Only "+availableSeats+" seats are available");
			}
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	public static void isvalidcancelling(int matchId, int bookingId, int noOfTickets) {

		if (!InputValidator.isValidNumber(noOfTickets) && !InputValidator.isValidNumber(bookingId)
				&& InputValidator.isValidNumber(matchId)) {
			throw new ValidationException("Invalid input");
		}
	}

}
