package in.siva.model;

public class MatchDetail {

	public MatchDetail() {
		super();
	}
	
	
	private int matchId;
	private String stadiumName;
	private String matchDate;
	private String team1;
	private String team2;
	private int totalSeats;
	private int availableSeats;
	private int bookedSeats;
	private int upperSeatPrice;
	private int lowerSeatPrice;
	private String image;
	
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

	public String getMatchDate() {
		return matchDate;
	}

	public String getTeam1() {
		return team1;
	}

	public String getTeam2() {
		return team2;
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

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
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
}
