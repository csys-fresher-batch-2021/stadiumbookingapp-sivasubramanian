package in.siva.service;

import in.siva.converter.MatchDetailConverter;
import in.siva.dao.AdminDaoImpl;
import in.siva.dto.MatchDetailsDTO;
import in.siva.exception.ServiceException;
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

		MatchDetail matchDetail = MatchDetailConverter.toMatchDetail(dto);
		try {
			MatchDetailValidator.isValidMatchDetail(matchDetail);
			AdminDaoImpl adminDao = new AdminDaoImpl();
			adminDao.save(matchDetail);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Invalid Match details");
		}

	}
}
