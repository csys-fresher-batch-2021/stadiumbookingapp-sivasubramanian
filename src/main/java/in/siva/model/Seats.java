package in.siva.model;

public class Seats {
	
	private int availableSeats;
	private int bookedSeats;
	public int getAvailableSeats() {
		return availableSeats;
	}
	public Seats(int availableSeats, int bookedSeats) {
		super();
		this.availableSeats = availableSeats;
		this.bookedSeats = bookedSeats;
	}
	public int getBookedSeats() {
		return bookedSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	

}
