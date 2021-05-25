package in.siva.model;

public class Booking {

	private String name;
	private String matchDate;
	private int noOfSeats;

	public String getName() {
		return name;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public Booking(String name, String matchDate, int noOfSeats) {
		super();
		this.name = name;
		this.matchDate = matchDate;
		this.noOfSeats = noOfSeats;
	}
}
