package in.siva.model;

public class Seats {

	private int availableSeats;
	private int bookedSeats;
	private float availablePercentage;
	public float getAvailablePercentage() {
		return availablePercentage;
	}

	public float getBookedPercentage() {
		return bookedPercentage;
	}

	public void setAvailablePercentage(float availablePercentage) {
		this.availablePercentage = availablePercentage;
	}

	public void setBookedPercentage(float availablePercentage) {
		this.bookedPercentage =100- availablePercentage;
	}

	private float bookedPercentage;

	public int getAvailableSeats() {
		return availableSeats;
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
