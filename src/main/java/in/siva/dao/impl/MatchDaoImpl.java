package in.siva.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.siva.dao.MatchDAO;
import in.siva.exception.DbException;
import in.siva.model.Booking;
import in.siva.model.MatchDetail;
import in.siva.model.Seats;
import in.siva.util.ConnectionUtil;

public class MatchDaoImpl implements MatchDAO {

	public MatchDaoImpl() {
		super();
	}

	/**
	 * This method is used for list matches which is sorted by date.
	 * 
	 * @return
	 * @throws DbException
	 */
	@Override
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
				LocalDate matchDate = result.getDate(2).toLocalDate();
				String teamOne = result.getString(3);
				String teamTwo = result.getString(4);
				int totalSeats = result.getInt(5);
				int upperPrice = result.getInt(6);
				int lowerPrice = result.getInt(7);
				MatchDetail match = new MatchDetail();

				match.setStadiumName(stadiumName);
				match.setMatchDate(matchDate);
				match.setTeamOne(teamOne);
				match.setTeamTwo(teamTwo);
				match.setTotalSeats(totalSeats);
				match.setUpperSeatPrice(upperPrice);
				match.setLowerSeatPrice(lowerPrice);
				match.setBookable(matchDate);

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
	 * This method is used for get available and booked seats
	 * 
	 * @param stadiumName
	 * @param matchDate
	 * @return
	 * @throws DbException
	 */
	@Override
	public List<Seats> findByMatchDate(String stadiumName, String matchDate) throws DbException {
		final List<Seats> seats = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select available_seats,booked_seats,(available_seats*100/total_seats) from match_details where stadium_name=? and match_date=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, stadiumName);
			pst.setDate(2, java.sql.Date.valueOf(matchDate));
			result = pst.executeQuery();
			if (result.next()) {
				int availableSeats = result.getInt(1);
				int bookedSeats = result.getInt(2);
				float availablePercent=result.getFloat(3);
				Seats seat=new Seats();
				
				seat.setAvailableSeats(availableSeats);
				seat.setBookedSeats(bookedSeats);
				seat.setAvailablePercentage(availablePercent);
				seat.setBookedPercentage(availablePercent);
				seats.add(seat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to get matches");
		} finally {
			ConnectionUtil.close(connection, pst, result);
		}
		return seats;

	}

	/**
	 * This method is used for list matches which is after current date.
	 * 
	 * @return
	 * @throws DbException
	 */
	@Override
	public List<MatchDetail> findByAfterCurrentDate() throws DbException {
		final List<MatchDetail> matches = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select id,stadium_name,match_date,match_time,team1,team2,upper_seat_price,lower_seat_price,image from match_details where match_date >= CURRENT_DATE order by match_date asc";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				int matchId = result.getInt(1);
				String stadiumName = result.getString(2);
				LocalDate matchDate = result.getDate(3).toLocalDate();
				Time matchTime=result.getTime(4);
				String teamOne = result.getString(5);
				String teamTwo = result.getString(6);
				int upperPrice = result.getInt(7);
				int lowerPrice = result.getInt(8);
				String image = result.getString(9);
				MatchDetail match = new MatchDetail();

				match.setMatchId(matchId);
				match.setStadiumName(stadiumName);
				match.setMatchDate(matchDate);
				match.setTeamOne(teamOne);
				match.setTeamTwo(teamTwo);
				match.setUpperSeatPrice(upperPrice);
				match.setLowerSeatPrice(lowerPrice);
				match.setImage(image);
				match.setMatchTime(matchTime.toLocalTime());

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
	 * This method returns avilable seats.
	 * 
	 * @param matchDate
	 * @return
	 * @throws DbException
	 */
	@Override
	public int findAvailableSeats(String matchDate) throws DbException {

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		int availableSeats = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select available_seats from match_details where match_date=?";
			pst = connection.prepareStatement(sql);
			pst.setDate(1, java.sql.Date.valueOf(matchDate));
			result = pst.executeQuery();
			while (result.next()) {
				availableSeats = result.getInt(1);
			}
		} catch (SQLException e) {
			throw new DbException("Unable to find");
		} finally {
			ConnectionUtil.close(connection, pst, result);
		}
		return availableSeats;
	}

	/**
	 * This method is used for update available and booked seats while booking.
	 * 
	 * @param dao
	 * @throws DbException
	 * @throws SQLException
	 */
	@Override
	public void updateBook(Booking dao) throws DbException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String updateQuery = "update match_details set available_seats=available_seats-?,booked_seats=booked_seats+? where id=?";
			pst = connection.prepareStatement(updateQuery);
			pst.setInt(1, dao.getNoOfSeats());
			pst.setInt(2, dao.getNoOfSeats());
			pst.setInt(3, dao.getMatchId());
			pst.executeUpdate();
		} catch (Exception e) {
			throw new DbException("Unable to update");
		} finally {
			ConnectionUtil.close(connection, pst);
		}

	}

	/**
	 * This method is used for update available and booked seats while cancelling.
	 * 
	 * @param matchId
	 * @param noOfTickets
	 * @throws DbException
	 * @throws SQLException
	 */
	@Override
	public void updateCancell(int matchId, int noOfTickets) throws DbException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String updateQuery = "update match_details set available_seats=available_seats+?,booked_seats=booked_seats-? where id=?";
			pst = connection.prepareStatement(updateQuery);
			pst.setInt(1, noOfTickets);
			pst.setInt(2, noOfTickets);
			pst.setInt(3, matchId);
			pst.executeUpdate();
		} catch (Exception e) {
			throw new DbException("Unable to update seats");
		} finally {
			ConnectionUtil.close(connection, pst);
		}

	}

}
