package in.siva.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class MatchDetail {

	public MatchDetail() {
		super();
	}

	private int matchId;
	private String stadiumName;
	private LocalDate matchDate;
	private String teamOne;
	private String teamTwo;
	private int totalSeats;
	private int availableSeats;
	private int bookedSeats;
	private int upperSeatPrice;
	private int lowerSeatPrice;
	private String image;
	private boolean bookable;
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

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public int getTotalSeats() {
		return totalSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public int getUpperSeatPrice() {
		return upperSeatPrice;
	}

	public int getLowerSeatPrice() {
		return lowerSeatPrice;
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

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public void setUpperSeatPrice(int upperseatPrice) {
		this.upperSeatPrice = upperseatPrice;
	}

	public void setLowerSeatPrice(int lowerSeatPrice) {
		this.lowerSeatPrice = lowerSeatPrice;
	}

	public boolean isBookable() {
		return bookable;
	}

	public void setBookable(LocalDate matchDate) {
		this.bookable = matchDate.isAfter(LocalDate.now());
	}
}
