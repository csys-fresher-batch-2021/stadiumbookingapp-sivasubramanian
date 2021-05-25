package in.siva.dto;

import java.util.Date;

public class MatchDTO {

	public MatchDTO() {
		super();
	}

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

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public void setAvailableSeate(int availableSeate) {
		this.availableSeats = availableSeate;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public MatchDTO(Date matchDate, int availableSeate, int bookedSeats) {
		super();
		this.matchDate = matchDate;
		this.availableSeats = availableSeate;
		this.bookedSeats = bookedSeats;
	}

}
