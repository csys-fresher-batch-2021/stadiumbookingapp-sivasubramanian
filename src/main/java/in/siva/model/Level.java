package in.siva.model;

public class Level {
	
	String matchDate;
	public String getMatchDate() {
		return matchDate;
	}
	public float getAvailablePercentage() {
		return availablePercentage;
	}
	public float getBookedPercentage() {
		return bookedPercentage;
	}
	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}
	public void setAvailablePercentage(float availablePercentage) {
		this.availablePercentage = availablePercentage;
	}
	public void setBookedPercentage(float bookedPercentage) {
		this.bookedPercentage = bookedPercentage;
	}
	float availablePercentage;
	float bookedPercentage;
		
	

}
