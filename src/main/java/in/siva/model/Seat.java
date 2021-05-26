package in.siva.model;

import java.sql.Date;

public class Seat {

	private Date matchDate;
	private int availableSeats;
	private int bookedSeats;

	public Date getMatchDate() {
		return matchDate;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	public Seat(Date matchDate, int availableSeate, int bookedSeats) {
		super();
		this.matchDate = matchDate;
		this.availableSeats = availableSeate;
		this.bookedSeats = bookedSeats;
	}

}
