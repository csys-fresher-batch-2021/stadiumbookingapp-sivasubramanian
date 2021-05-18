package in.siva;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import in.siva.model.Match;

import in.siva.service.MatchManager;

public class MatchManagerTest {

	@Test
	public void test() {
		Set<Match> Matches = MatchManager.getAvailableMatches();
		assertEquals(3, Matches.size());
	}

}
