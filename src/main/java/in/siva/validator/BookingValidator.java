package in.siva.validator;

import in.siva.dao.MatchDAO;
import in.siva.exception.DbException;
import in.siva.model.Booking;

public class BookingValidator {

	private BookingValidator() {

	}

	public static boolean isValidBooking(Booking book) throws DbException {
		boolean valid = false;
		int noOfSeats = book.getNoOfSeats();
		int available = MatchDAO.CheckAvailability(book.getMatchDate());
		if (isValid(noOfSeats) && noOfSeats <= available) {
			valid = true;
		}
		return valid;
	}

	public static boolean isValid(int noOfSeats) {
		boolean valid = false;
		if (noOfSeats > 0) {
			valid = true;
		}
		return valid;
	}
}
