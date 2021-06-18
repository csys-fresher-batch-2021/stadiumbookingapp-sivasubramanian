package in.siva.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import in.siva.dao.AdminDAO;
import in.siva.exception.DbException;
import in.siva.model.AllBookings;
import in.siva.model.Level;
import in.siva.model.MatchDetail;
import in.siva.util.ConnectionUtil;

public class AdminDaoImpl implements AdminDAO {

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
	@Override
	public void save(MatchDetail dao) throws DbException, SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String insertQuery = "insert into match_details (stadium_name,match_date,match_time,team1,team2,total_seats,available_seats,upper_seat_price,lower_seat_price,image) values (?,?,?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(insertQuery);
			pst.setString(1, dao.getStadiumName());
			Date showDate = Date.valueOf(dao.getMatchDate());
			pst.setDate(2, showDate);
			Time matchTime=Time.valueOf(dao.getMatchTime());
			pst.setTime(3,matchTime);
			pst.setString(4, dao.getTeamOne());
			pst.setString(5, dao.getTeamTwo());
			pst.setInt(6, dao.getTotalSeats());
			pst.setInt(7, dao.getAvailableSeats());
			pst.setInt(8, dao.getUpperSeatPrice());
			pst.setInt(9, dao.getLowerSeatPrice());
			pst.setString(10, dao.getImage());

			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
	@Override
	public List<AllBookings> findAllBookings() throws DbException {
		final List<AllBookings> allBookingList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select u.user_name, m.id,m.stadium_name,m.match_date,m.match_time,m.team1,m.team2,"
					+ "b.seat_type, b.no_of_seats,"
					+ "b.status,b.id from users u,match_details m,booking_details b where m.id=b.match_id and u.id=b.user_id";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				String username = result.getString(1);
				int matchId = result.getInt(2);
				String stadiumName = result.getString(3);
				LocalDate matchDate = result.getDate(4).toLocalDate();
				LocalTime matchTime=result.getTime(5).toLocalTime();
				String team1 = result.getString(6);
				String team2 = result.getString(7);
				String seatType = result.getString(8);
				int noOfTickets = result.getInt(9);
				String status = result.getString(10);
				int bookingId = result.getInt(11);
				AllBookings allBooking = new AllBookings();

				allBooking.setBookingId(bookingId);
				allBooking.setStadiumName(stadiumName);
				allBooking.setMatchDate(matchDate);
				allBooking.setUsername(username);
				allBooking.setNoOfTickets(noOfTickets);
				allBooking.setSeatType(seatType);
				allBooking.setStatus(status);
				allBooking.setTeamOne(team1);
				allBooking.setTeamTwo(team2);
				allBooking.setMatchId(matchId);
				allBooking.setMatchTime(matchTime);

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
	@Override
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
