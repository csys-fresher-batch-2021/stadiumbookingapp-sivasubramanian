package in.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.siva.exception.DbException;
import in.siva.model.MatchDetail;
import in.siva.model.Seats;
import in.siva.util.ConnectionUtil;

public class MatchDaoImpl {

	public MatchDaoImpl() {
		super();
	}
	/**
	 * This method is used for list matches by date order.
	 * 
	 * @return
	 * @throws DbException
	 */
	public List<MatchDetail> findAllByOrderByDateAsc() throws DbException {
		final List<MatchDetail> matches = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select stadium_name,match_date,team1,team2,total_seats,upper_seat_price,lower_seat_price from match_details order by match_date asc";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				String stadiumName = result.getString(1);
				String matchDate = result.getDate(2).toString();
				String team1 = result.getString(3);
				String team2 = result.getString(4);
				int totalSeats = result.getInt(5);
				int upperPrice = result.getInt(6);
				int lowerPrice = result.getInt(7);
				MatchDetail match = new MatchDetail();

				match.setStadiumName(stadiumName);
				match.setMatchDate(matchDate);
				match.setTeam1(team1);
				match.setTeam2(team2);
				match.setTotalSeats(totalSeats);
				match.setUpperSeatPrice(upperPrice);
				match.setLowerSeatPrice(lowerPrice);

				matches.add(match);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, pst, result);
		}
		return matches;

	}

	/**
	 * Thismethod is used for check available seats
	 * 
	 * @param stadiumName
	 * @param matchDate
	 * @return
	 * @throws DbException
	 */
	public List<Seats> findByMatchDate(String stadiumName, String matchDate) throws DbException {
		final List<Seats> seats = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select available_seats,booked_seats from match_details where stadium_name=? and match_date=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, stadiumName);
			pst.setDate(2, java.sql.Date.valueOf(matchDate));
			result = pst.executeQuery();
			if (result.next()) {
				int availableSeats = result.getInt(1);
				int bookedSeats = result.getInt(2);
				Seats seat = new Seats(availableSeats, bookedSeats);
				seats.add(seat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, pst, result);
		}
		return seats;

	}
	
	/**
	 * This method is used for list matches after current date.
	 * 
	 * @return
	 * @throws DbException
	 */
	public List<MatchDetail> findByAfterCurrentDate() throws DbException {
		final List<MatchDetail> matches = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select stadium_name,match_date,team1,team2,upper_seat_price,lower_seat_price,image from match_details where match_date >= CURRENT_DATE order by match_date asc";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				String stadiumName = result.getString(1);
				String matchDate = result.getDate(2).toString();
				String team1 = result.getString(3);
				String team2 = result.getString(4);
				int upperPrice=result.getInt(5);
				int lowerPrice=result.getInt(6);
				String image=result.getString(7);
				MatchDetail match = new MatchDetail();

				match.setStadiumName(stadiumName);
				match.setMatchDate(matchDate);
				match.setTeam1(team1);
				match.setTeam2(team2);
				match.setUpperSeatPrice(upperPrice);
				match.setLowerSeatPrice(lowerPrice);
				match.setImage(image);

				matches.add(match);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, pst, result);
		}
		return matches;

	}

}
