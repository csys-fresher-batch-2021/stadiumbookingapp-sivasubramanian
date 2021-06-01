package in.siva.validator;

import in.siva.dao.MatchDaoImpl;
import in.siva.exception.DbException;
import in.siva.exception.ValidationException;
import in.siva.model.Booking;

public class BookingValidator {

	public BookingValidator() {

		// Default constructor
	}

	public static void isValidBooking(Booking book) {

		MatchDaoImpl matchDao = new MatchDaoImpl();
		int noOfSeats = book.getNoOfSeats();
		try {
			int availableSeats = matchDao.findAvailableSeats(book.getMatchDate());
			int totalAmount = book.getTotalAmount();
			if (!InputValidator.isValidNumber(noOfSeats) || !InputValidator.isValidNumber(totalAmount)
					|| noOfSeats > availableSeats) {
				throw new ValidationException("Invalid input");
			}
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

}
