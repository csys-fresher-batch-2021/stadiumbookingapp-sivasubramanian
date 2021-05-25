package in.siva.service;

import java.sql.SQLException;

import in.siva.converter.BookingConverter;
import in.siva.dao.MatchDAO;
import in.siva.dto.BookingDTO;
import in.siva.exception.DbException;
import in.siva.model.Booking;
import in.siva.validator.BookingValidator;

public class BookingManager {

	private BookingManager() {

	}

	public static boolean bookSeats(BookingDTO dto) throws SQLException, DbException {
		boolean booked=false;
		Booking book = BookingConverter.toBooking(dto);
		MatchDAO matchDao=new MatchDAO();
		try {
			if (BookingValidator.isValidBooking(book)) {
				matchDao.bookSeats(book);
				matchDao.update(book);
				booked=true;
			}
		} catch (DbException | SQLException e) {
			throw new DbException("Unable to book");
		}
		return booked;

	}

}
