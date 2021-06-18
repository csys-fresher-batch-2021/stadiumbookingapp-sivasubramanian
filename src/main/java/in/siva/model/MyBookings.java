package in.siva.model;

import java.time.LocalDate;

public class MyBookings {

	private int bookingId;
	private int matchId;
	private String stadiumName;
	private LocalDate matchDate;
	private String teamOne;
	private String teamTwo;
	private String seatType;
	private int noOfTickets;
	private LocalDate bookingDate;
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

	public void setCancellable(LocalDate matchDate) {
		this.cancellable = matchDate.isAfter(LocalDate.now());
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

	public LocalDate getMatchDate() {
		return matchDate;
	}

	public String getTeamOne() {
		return teamOne;
	}

	public String getTeamTwo() {
		return teamTwo;
	}

	public String getSeatType() {
		return seatType;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public void setMatchDate(LocalDate matchDate) {
		this.matchDate = matchDate;
	}

	public void setTeamOne(String team1) {
		this.teamOne = team1;
	}

	public void setTeamTwo(String team2) {
		this.teamTwo = team2;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

}
