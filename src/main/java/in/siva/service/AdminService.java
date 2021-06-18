package in.siva.service;

import java.util.List;


import javax.sql.rowset.serial.SerialException;

import in.siva.convertor.MatchDetailConvertor;
import in.siva.dao.AdminDAO;
import in.siva.dao.impl.AdminDaoImpl;
import in.siva.dto.MatchDetailsDTO;
import in.siva.exception.ServiceException;
import in.siva.model.AllBookings;
import in.siva.model.Level;
import in.siva.model.MatchDetail;
import in.siva.validator.AdminValidator;
import in.siva.validator.MatchDetailValidator;

public class AdminService {

	private AdminService() {

	}

	/**
	 * This method is used for admin login
	 * 
	 * @param username
	 * @param password
	 */
	public static void checkAdminLogin(String username, String password) {

		try {
			AdminValidator.isValidAdmin(username, password);
		} catch (Exception e) {
			throw new ServiceException("Invalid Login Credentials");
		}
	}

	/**
	 * This method is used for match details by admin
	 * 
	 * @param dto
	 */
	public static void addMatchDetails(MatchDetailsDTO dto) {

		MatchDetail matchDetail = MatchDetailConvertor.toMatchDetail(dto);
		try {
			MatchDetailValidator.isValidMatchDetail(matchDetail);
			AdminDAO adminDao = new AdminDaoImpl();
			adminDao.save(matchDetail);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * This method is used to get all booked user details.
	 * 
	 * @return
	 * @throws SerialException
	 */
	public static List<AllBookings> getAllBookings() throws ServiceException {

		AdminDAO allBookings = new AdminDaoImpl();
		try {
			return allBookings.findAllBookings();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * This method is used for get available levels.
	 * 
	 * @param name
	 * @return
	 */
	public static List<Level> getPercentage(String name) {

		AdminDAO percentage = new AdminDaoImpl();
		try {
			return percentage.findPercentage(name);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
