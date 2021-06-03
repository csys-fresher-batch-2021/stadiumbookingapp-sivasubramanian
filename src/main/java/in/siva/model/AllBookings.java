package in.siva.model;

public class AllBookings {
	
	private String username;
	private String seatType;
	private String stadiumName;
	private String matchDate;
	private String team1;
	private String team2;
	private int noOfTickets;
	private String status ;
	private int matchId;
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
	public String getMatchDate() {
		return matchDate;
	}
	public String getTeam1() {
		return team1;
	}
	public String getTeam2() {
		return team2;
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
	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
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
