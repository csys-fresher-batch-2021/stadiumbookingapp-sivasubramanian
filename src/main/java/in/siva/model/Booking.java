package in.siva.model;

public class Booking {

	private int userId;
	private int matchId;
	private String seatType;
	private int noOfSeats;
	private int totalAmount;
	private String matchDate;

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public int getUserId() {
		return userId;
	}

	public int getMatchId() {
		return matchId;
	}

	public String getSeatType() {
		return seatType;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Booking() {
		super();
	}

}
