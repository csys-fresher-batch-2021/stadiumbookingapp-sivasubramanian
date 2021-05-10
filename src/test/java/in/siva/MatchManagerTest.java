package in.siva;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import in.siva.model.Matches;
import in.siva.service.MatchManager;

public class MatchManagerTest {

	/**
	 * Test for get available matches
	 */
	@Test
	public void test() {
		Set<Matches> Matches = MatchManager.getAvailableMatches();
		assertEquals(2, Matches.size());
	}

}
