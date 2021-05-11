package in.siva.model;

import java.time.LocalDate;

public class Matches {

	private String team1;
	private String team2;
	private LocalDate matchDate;
	public String getTeam1() {
		return team1;
	}
	public String getTeam2() {
		return team2;
	}
	public LocalDate getMatchDate() {
		return matchDate;
	}
	public  Matches (String team1, String team2,LocalDate matchDate) {
		super();
		this.team1=team1;
		this.team2=team2;
		this.matchDate=matchDate;
	}
}
