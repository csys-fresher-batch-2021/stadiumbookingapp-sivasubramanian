package in.siva.converter;

import in.siva.dto.BookingDTO;
import in.siva.model.Booking;

public class BookingConverter {

	public static Booking toBooking(BookingDTO dto) {
		String name=dto.getName();
		String matchDate=dto.getMatchDate();
		int noOfSeats=dto.getNoOfSeats();
		return new Booking(name,matchDate,noOfSeats);
	}
	
}
