package in.siva.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import in.siva.model.Matches;

public class MatchManager {

	private MatchManager() {
		// Default Constructor
	}

	private static Set<Matches> matchList = new HashSet<>();
	static {
		Matches day1 = new Matches("csk", "rcb", LocalDate.parse("2021-05-11"));
		Matches day2 = new Matches("srh", "kkr", LocalDate.parse("2021-05-12"));
		Matches day3 = new Matches("dc", "mi", LocalDate.parse("2021-05-13"));

		matchList.add(day1);
		matchList.add(day2);
		matchList.add(day3);
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
