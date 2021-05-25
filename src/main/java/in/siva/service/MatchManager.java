package in.siva.service;

import java.sql.SQLException;

import java.util.List;

import in.siva.dao.MatchDAO;
import in.siva.exception.DbException;
import in.siva.model.Match;
import in.siva.model.Seat;

public class MatchManager {

	private MatchManager() {
		// Default Constructor
	}

	/**
	 * This method is used to return the available matches.
	 * 
	 * @return
	 * @throws DbException
	 */
	public static List<Seat> availability(String matchDate) throws DbException {

		try {
			MatchDAO matchDAO = new MatchDAO();
			return matchDAO.getAvailableSeats(matchDate);
		} catch (DbException | SQLException e) {
			throw new DbException("Unable to Get seat details");
		}
	}

	public static List<Match> getMatches() throws DbException {
		MatchDAO matchDAO = new MatchDAO();
		try {
			return matchDAO.getAllMatches();
		} catch (DbException e) {
			throw new DbException("Unable to Get matches");
		}
	}

}
