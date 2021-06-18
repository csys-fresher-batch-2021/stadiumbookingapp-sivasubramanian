package in.siva.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class AllBookings {
	
	private String username;
	private String seatType;
	private String stadiumName;
	private LocalDate matchDate;
	private String teamOne;
	private String teamTwo;
	private int noOfTickets;
	private String status ;
	private int matchId;
	private LocalTime matchTime;
	public LocalTime getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(LocalTime matchTime) {
		this.matchTime = matchTime;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public String getUsername() {
		return username;
	}
	public int getBookingId() {
		return bookingId;
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
	public int getNoOfTickets() {
		return noOfTickets;
	}
	public String getStatus() {
		return status;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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
	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private int bookingId;
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	

}
