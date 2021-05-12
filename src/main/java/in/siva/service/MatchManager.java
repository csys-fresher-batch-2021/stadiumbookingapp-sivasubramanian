package in.siva.service;

import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

import in.siva.model.Match;

public class MatchManager {

	private MatchManager() {
		// Default Constructor
	}

	private static final Set<Match> matchList = new HashSet<>();
	static {
		Match day1 = new Match("csk", "rcb", LocalDate.parse("2021-05-11"));
		Match day2 = new Match("srh", "kkr", LocalDate.parse("2021-05-12"));
		Match day3 = new Match("dc", "mi", LocalDate.parse("2021-05-13"));

		matchList.add(day1);
		matchList.add(day2);
		matchList.add(day3);
	}

	/**
	 * This method is used to return the available matches.
	 * 
	 * @return
	 */
	public static Set<Match> getAvailableMatches() {
		return matchList;
	}

}
