package in.siva.service;

import java.sql.SQLException;

import in.siva.converter.BookingConverter;
import in.siva.dao.BookingDaoImpl;
import in.siva.dao.MatchDaoImpl;
import in.siva.dto.BookingDTO;
import in.siva.exception.DbException;
import in.siva.exception.ServiceException;
import in.siva.model.Booking;
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
		
		Booking bookSeat=BookingConverter.toBooking(dto);
		
			try {
				BookingValidator.isValidBooking(bookSeat);
				BookingDaoImpl bookingDao = new BookingDaoImpl();
				MatchDaoImpl matchdao=new MatchDaoImpl();
				bookingDao.save(bookSeat);
				matchdao.update(bookSeat);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServiceException("Invalid credentials");
			}
		
		
	}
}
