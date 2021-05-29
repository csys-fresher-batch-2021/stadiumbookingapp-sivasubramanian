package in.siva.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import in.siva.exception.DbException;
import in.siva.model.MatchDetail;
import in.siva.util.ConnectionUtil;

public class AdminDaoImpl implements AdminDao {

	public AdminDaoImpl() {
		super();

	}

	@Override
	public void save(MatchDetail dao) throws DbException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String insertQuery = "insert into match_details (stadium_name,match_date,team1,team2,total_seats,available_seats,upper_seat_price,lower_seat_price,image) values (?,?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(insertQuery);
			pst.setString(1, dao.getStadiumName());
			pst.setDate(2, java.sql.Date.valueOf(dao.getMatchDate()));
			pst.setString(3, dao.getTeam1());
			pst.setString(4, dao.getTeam2());
			pst.setInt(5, dao.getTotalSeats());
			pst.setInt(6, dao.getAvailableSeats());
			pst.setInt(7, dao.getUpperSeatPrice());
			pst.setInt(8, dao.getLowerSeatPrice());
			pst.setString(9, dao.getImage());

			pst.executeUpdate();
		} catch (Exception e) {
			throw new DbException("Unable to register");
		} finally {
			ConnectionUtil.close(connection, pst);
		}
	}

}
