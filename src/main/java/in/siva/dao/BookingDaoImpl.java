package in.siva.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.siva.exception.DbException;
import in.siva.model.Booking;
import in.siva.model.MyBookings;
import in.siva.util.ConnectionUtil;

public class BookingDaoImpl {

	public BookingDaoImpl() {
		super();
	}

	/**
	 * This method is used for book seats
	 * 
	 * @param dao
	 * @throws DbException
	 * @throws SQLException
	 */
	public void save(Booking dao) throws DbException, SQLException {

		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String insertQuery = "insert into booking_details (user_id,match_id,seat_type,no_of_seats,total_amount) values (?,?,?,?,?)";
			pst = connection.prepareStatement(insertQuery);
			pst.setInt(1, dao.getUserId());
			pst.setInt(2, dao.getMatchId());
			pst.setString(3, dao.getSeatType());
			pst.setInt(4, dao.getNoOfSeats());
			pst.setInt(5, dao.getTotalAmount());

			pst.executeUpdate();

		} catch (Exception e) {
			throw new DbException("Unable to Book");
		} finally {
			ConnectionUtil.close(connection, pst);
		}
	}

	/**
	 * This method is used for get my bookings.
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 */
	public List<MyBookings> findMyBookings(int userId) throws DbException {
		final List<MyBookings> myBookingList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select m.stadium_name,m.match_date,m.team1,m.team2,"
					+ "b.seat_type, b.no_of_seats,b.booking_date,b.total_amount,"
					+ "b.status,b.id,b.match_id from match_details m,booking_details b where m.id=b.match_id and b.user_id=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userId);
			result = pst.executeQuery();
			while (result.next()) {
				String stadiumName = result.getString(1);
				String matchDate = result.getDate(2).toString();
				String team1 = result.getString(3);
				String team2 = result.getString(4);
				String seatType = result.getString(5);
				int noOfTickets = result.getInt(6);
				String bookingDate = result.getDate(7).toString();
				int totalAmount = result.getInt(8);
				String status = result.getString(9);
				int bookingId = result.getInt(10);
				int matchId = result.getInt(11);
				MyBookings myBooking = new MyBookings();

				myBooking.setStadiumName(stadiumName);
				myBooking.setMatchDate(matchDate);
				myBooking.setTeam1(team1);
				myBooking.setTeam2(team2);
				myBooking.setSeatType(seatType);
				myBooking.setNoOfTickets(noOfTickets);
				myBooking.setBookingDate(bookingDate);
				myBooking.setTotalAmount(totalAmount);
				myBooking.setStatus(status);
				myBooking.setBookingId(bookingId);
				myBooking.setMatchId(matchId);
				myBooking.setCancellable(matchDate);
				
				myBookingList.add(myBooking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, pst, result);
		}
		return myBookingList;
	}

	/**
	 * This method is used for update while cancelling seat.
	 * 
	 * @param bookingId
	 * @throws DbException
	 * @throws SQLException
	 */
	public void update(int bookingId) throws DbException, SQLException {

		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String updateQuery = "update booking_details set status='cancelled' where id=?";
			pst = connection.prepareStatement(updateQuery);
			pst.setInt(1, bookingId);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbException("Unable to cancell");
		} finally {
			ConnectionUtil.close(connection, pst);
		}

	}
}
