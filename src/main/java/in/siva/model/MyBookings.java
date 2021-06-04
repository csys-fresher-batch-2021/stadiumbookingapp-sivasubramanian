package in.siva.model;

import java.time.LocalDate;

public class MyBookings {

	private int bookingId;
	private int matchId;
	private String stadiumName;
	private String matchDate;
	private String team1;
	private String team2;
	private String seatType;
	private int noOfTickets;
	private String bookingDate;
	private int totalAmount;
	private String status;
	private boolean cancellable; // derivable column

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public boolean isCancellable() {
		return cancellable;
	}

	public void setCancellable(String matchDate) {
		this.cancellable =  LocalDate.parse(matchDate).isAfter(LocalDate.now());
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStadiumName() {
		return stadiumName;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public String getTeam1() {
		return team1;
	}

	public String getTeam2() {
		return team2;
	}

	public String getSeatType() {
		return seatType;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

}
