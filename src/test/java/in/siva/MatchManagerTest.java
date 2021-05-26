package in.siva;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import in.siva.model.Match;

import in.siva.service.MatchManager;

public class MatchManagerTest {

	@Test
	public void test() {
		try {
			List<Match> Matches = MatchManager.getMatches();
			assertEquals(3, Matches.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
