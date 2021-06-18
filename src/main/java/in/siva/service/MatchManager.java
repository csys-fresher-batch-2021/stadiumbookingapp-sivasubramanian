package in.siva.service;

import java.util.List;

import in.siva.dao.MatchDAO;
import in.siva.dao.impl.MatchDaoImpl;
import in.siva.exception.ServiceException;
import in.siva.model.MatchDetail;
import in.siva.model.Seats;

public class MatchManager {

	private MatchManager() {
		// Default Constructor
	}

	/**
	 * This method is used for get matches
	 * 
	 * @param dto
	 * @return
	 */
	public static List<MatchDetail> getMatches() {

		try {
			MatchDAO matchDao = new MatchDaoImpl();
			return matchDao.findAllByOrderByDateAsc();
		} catch (Exception e) {
			throw new ServiceException("Unable to get matches");
		}

	}

	/**
	 * This method is used for get available seats
	 * 
	 * @param dto
	 * @return
	 */
	public static List<Seats> getAvailableseats(String stadiumName, String matchDate) {

		try {
			MatchDAO matchDao = new MatchDaoImpl();
			return matchDao.findByMatchDate(stadiumName, matchDate);
		} catch (Exception e) {
			throw new ServiceException("Unable to get availability");
		}

	}
	
	/**
	 * This method is used for get matches after current date
	 * 
	 * @param dto
	 * @return
	 */
	public static List<MatchDetail> getNextMatches() {

		try {
			MatchDAO matchDao = new MatchDaoImpl();
			return matchDao.findByAfterCurrentDate();
		} catch (Exception e) {
			throw new ServiceException("Unable to display");
		}

	}

}
