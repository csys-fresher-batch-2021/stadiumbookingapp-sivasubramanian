package in.siva.dao;

import java.sql.SQLException;
import java.util.List;

import in.siva.exception.DbException;
import in.siva.model.AllBookings;
import in.siva.model.Level;
import in.siva.model.MatchDetail;

public interface AdminDAO {

	/**
	 * This method is used for store match details
	 * 
	 * @param dao
	 * @throws DbException
	 * @throws SQLException
	 */
	void save(MatchDetail dao) throws DbException, SQLException;

	/**
	 * This method is used for get all bookings.
	 * 
	 * @return
	 * @throws DbException
	 */
	List<AllBookings> findAllBookings() throws DbException;

	/**
	 * This method is used for get available levels in terms of percentage
	 * 
	 * @param name
	 * @return
	 * @throws DbException
	 */
	List<Level> findPercentage(String name) throws DbException;

}