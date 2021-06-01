package in.siva.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.siva.dto.BookingDTO;
import in.siva.service.BookingManager;


/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	int loggedInUserId = (int) session.getAttribute("LOGGED_IN_USER_ID");
    	String seatType=request.getParameter("type");
    	String matchDate=request.getParameter("matchDate");
    	try {
			int matchId=Integer.parseInt(request.getParameter("matchId"));
			int noOfSeats=Integer.parseInt(request.getParameter("noOfTickets"));
			int totalAmount=Integer.parseInt(request.getParameter("amount"));
			BookingDTO book=new BookingDTO();
			book.setUserId(loggedInUserId);
			book.setMatchId(matchId);
			book.setNoOfSeats(noOfSeats);
			book.setSeatType(seatType);
			book.setTotalAmount(totalAmount);
			book.setMatchDate(matchDate);
			BookingManager.bookSeat(book);
			String infoMessage = "Successfully booked";
			response.sendRedirect("booking.jsp?infoMessage=" + infoMessage);
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.sendRedirect("booking.jsp?errorMessage=" + errorMessage);
		}
		
		
	}

}
