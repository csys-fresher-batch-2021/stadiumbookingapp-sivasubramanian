package in.siva.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.siva.service.BookingManager;

/**
 * Servlet implementation class CancellBookingServlet
 */
@WebServlet("/CancellBookingServlet")
public class CancellBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CancellBookingServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int tickets = Integer.parseInt(request.getParameter("tickets"));
			int bookingId = Integer.parseInt(request.getParameter("bookingId"));
			int matchId = Integer.parseInt(request.getParameter("matchId"));
			BookingManager.cancellSeat(matchId, bookingId, tickets);
			String message = "Cancelled";
			response.sendRedirect("myBookings.jsp?Message=" + message);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

}
