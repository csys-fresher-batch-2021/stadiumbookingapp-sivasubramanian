package in.siva.model;

public class MatchDetail {

	public MatchDetail() {
		super();
	}
	
	private String stadiumName;
	private String matchDate;
	private String team1;
	private String team2;
	private String image;
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	private int totalSeats;
	private int availableSeats;
	private int upperseatPrice;
	private int lowerSeatPrice;

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

	public int getUpperseatPrice() {
		return upperseatPrice;
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

	public void setUpperseatPrice(int upperseatPrice) {
		this.upperseatPrice = upperseatPrice;
	}

	public void setLowerSeatPrice(int lowerSeatPrice) {
		this.lowerSeatPrice = lowerSeatPrice;
	}
}
