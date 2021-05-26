package in.siva.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.siva.exception.DbException;
import in.siva.model.Booking;
import in.siva.model.Match;
import in.siva.model.Seat;
import in.siva.util.ConnectionUtil;

public class MatchDAO {

	public List<Seat> getAvailableSeats(String date) throws SQLException, DbException {
		final List<Seat> matchDetails = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			if (date != null) {
				Date date1 = Date.valueOf(date);
				connection = ConnectionUtil.getConnection();
				String sql = "select match_date,available_seats,booked_seats from seat_details";
				pst = connection.prepareStatement(sql);
				result = pst.executeQuery();
				while (result.next()) {
					Date matchDate1 = result.getDate(1);
					if (matchDate1.equals(date1)) {
						int availableSeats = result.getInt(2);
						int bookedSeats = result.getInt(3);
						Seat detail = new Seat(matchDate1, availableSeats, bookedSeats);
						matchDetails.add(detail);
						break;
					}
				}

			}
		} catch (SQLException e) {
			throw new DbException("Unable to display");
		} finally {
			ConnectionUtil.close(connection, pst, result);
		}
		return matchDetails;
	}

	public List<Match> getAllMatches() throws DbException {
		final List<Match> matches = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from matches";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				String team1 = result.getString(1);  
				String team2 = result.getString(2);
				Date matchDate = result.getDate(3);
				Match match = new Match(team1, team2, matchDate);
				matches.add(match);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, pst, result);
		}
		return matches;
	}

	public static int checkAvailability(String date) throws DbException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		int availableSeats = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select match_date,available_seats from seat_details";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			Date matchDate = Date.valueOf(date);
			while (result.next()) {
				if (result.getDate(1).equals(matchDate)) {
					availableSeats = result.getInt(2);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, pst, result);
		}
		return availableSeats;
	}

	public void bookSeats(Booking book) throws DbException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String insertQuery = "insert into booking_details (name,match_date,no_of_booked_seats) values (?,?,?)";
			pst = connection.prepareStatement(insertQuery);
			pst.setString(1, book.getName());
			pst.setDate(2, java.sql.Date.valueOf(book.getMatchDate()));
			pst.setInt(3, book.getNoOfSeats());
			pst.executeUpdate();
		} catch (Exception e) {
			throw new DbException("Unable to register");
		} finally {
			ConnectionUtil.close(connection, pst);
		}
	}

	public void update(Booking book) throws DbException, SQLException {
		
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String insertQuery = "update seat_details set available_seats=available_seats-?,booked_seats=booked_seats+? where match_date=?";
			pst = connection.prepareStatement(insertQuery);
			pst.setInt(1, book.getNoOfSeats());
			pst.setInt(2, book.getNoOfSeats());
			pst.setDate(3, java.sql.Date.valueOf(book.getMatchDate()));
			pst.executeUpdate();
		} catch (Exception e) {
			throw new DbException("Unable to register");
		} finally {
			ConnectionUtil.close(connection, pst);
		}
	}
	

}
