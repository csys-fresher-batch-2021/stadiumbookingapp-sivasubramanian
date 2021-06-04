package in.siva.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.siva.exception.DbException;
import in.siva.model.AllBookings;
import in.siva.model.Level;
import in.siva.model.MatchDetail;
import in.siva.util.ConnectionUtil;

public class AdminDaoImpl {

	public AdminDaoImpl() {
		super();

	}

	/**
	 * This method is used for store match details
	 * 
	 * @param dao
	 * @throws DbException
	 * @throws SQLException
	 */
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

	/**
	 * This method is used for get all bookings.
	 * 
	 * @return
	 * @throws DbException
	 */
	public List<AllBookings> findAllBookings() throws DbException {
		final List<AllBookings> allBookingList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select u.user_name, m.id,m.stadium_name,m.match_date,m.team1,m.team2,"
					+ "b.seat_type, b.no_of_seats,"
					+ "b.status,b.id from users u,match_details m,booking_details b where m.id=b.match_id and u.id=b.user_id";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				String username = result.getString(1);
				int matchId = result.getInt(2);
				String stadiumName = result.getString(3);
				String matchDate = result.getDate(4).toString();
				String team1 = result.getString(5);
				String team2 = result.getString(6);
				String seatType = result.getString(7);
				int noOfTickets = result.getInt(8);
				String status = result.getString(9);
				int bookingId = result.getInt(10);
				AllBookings allBooking = new AllBookings();

				allBooking.setBookingId(bookingId);
				allBooking.setStadiumName(stadiumName);
				allBooking.setMatchDate(matchDate);
				allBooking.setUsername(username);
				allBooking.setNoOfTickets(noOfTickets);
				allBooking.setSeatType(seatType);
				allBooking.setStatus(status);
				allBooking.setTeam1(team1);
				allBooking.setTeam2(team2);
				allBooking.setMatchId(matchId);

				allBookingList.add(allBooking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to get all bookings");
		} finally {
			ConnectionUtil.close(connection, pst, result);
		}
		return allBookingList;

	}

	/**
	 * This method is used for get available levels in terms of percentage
	 * 
	 * @param name
	 * @return
	 * @throws DbException
	 */
	public List<Level> findPercentage(String name) throws DbException {
		final List<Level> percentage = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select match_date,(available_seats*100/total_seats) from match_details where stadium_name=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, name);
			result = pst.executeQuery();
			while (result.next()) {
				String matchDate = result.getDate(1).toString();
				float availabilityPercentage = result.getFloat(2);
				float bookedPercentage = 100 - availabilityPercentage;
				Level levels = new Level();

				levels.setMatchDate(matchDate);
				levels.setAvailablePercentage(availabilityPercentage);
				levels.setBookedPercentage(bookedPercentage);
				percentage.add(levels);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to find percentage");
		} finally {
			ConnectionUtil.close(connection, pst, result);
		}
		return percentage;

	}

}
