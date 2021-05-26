package in.siva.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.siva.dto.BookingDTO;
import in.siva.exception.DbException;
import in.siva.service.BookingManager;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String date =request.getParameter("date");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("LOGGED_IN_USER");
	    final String page="booking.jsp?message=";
		try {
			int noOfSeats = Integer.parseInt(request.getParameter("seats"));
			BookingDTO bookingdto=new BookingDTO(username, date,noOfSeats );
			boolean isBooked=BookingManager.bookSeats(bookingdto);
			
			if(isBooked) {
				String message = "Booking successfull";
				response.sendRedirect(page+ message);
			}
			else {
				String message = "Invalid details";
				response.sendRedirect(page + message);
			}
		} catch (DbException |SQLException e) {
			String message=e.getMessage();
			response.sendRedirect(page+ message);
		}
		
	}

}
