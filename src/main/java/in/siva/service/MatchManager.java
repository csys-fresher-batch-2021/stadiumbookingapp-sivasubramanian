package in.siva.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import in.siva.model.Matches;

public class MatchManager {

	private static Set<Matches> matchList = new HashSet<Matches>();
	static {
		Matches day1 = new Matches();
		day1.team1 = "csk";
		day1.team2 = "rcb";
		day1.matchDate = LocalDate.parse("2021-05-10");
		matchList.add(day1);

		Matches day2 = new Matches();
		day2.team1 = "srh";
		day2.team2 = "kkr";
		day2.matchDate = LocalDate.parse("2021-05-11");
		matchList.add(day2);
	}

	/**
	 * This method is used to return the available matches.
	 * 
	 * @return
	 */
	public static Set<Matches> getAvailableMatches() {
		return matchList;
	}

}
