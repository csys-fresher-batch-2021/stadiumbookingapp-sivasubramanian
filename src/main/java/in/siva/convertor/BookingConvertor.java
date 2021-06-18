package in.siva.convertor;

import in.siva.dto.BookingDTO;
import in.siva.model.Booking;

public class BookingConvertor {
	private BookingConvertor() {

	}

	public static Booking toBooking(BookingDTO dto) {
		Booking book=new Booking();
		book.setUserId(dto.getUserId());
		book.setMatchId(dto.getMatchId());
		book.setNoOfSeats(dto.getNoOfSeats());
		book.setSeatType(dto.getSeatType());
		book.setTotalAmount(dto.getTotalAmount());
		book.setMatchDate(dto.getMatchDate());
		return book;
	}

}
