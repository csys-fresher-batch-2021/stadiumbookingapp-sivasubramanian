package in.siva.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.siva.dto.MatchDetailsDTO;
import in.siva.service.AdminService;

/**
 * Servlet implementation class AddMatchServlet
 */
@WebServlet("/AddMatchServlet")
public class AddMatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMatchServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stadiumName = request.getParameter("stadiumName");
		String matchDate = request.getParameter("dateTime");
		String team1 = request.getParameter("team1");
		String team2 = request.getParameter("team2");
		String image = request.getParameter("image");
		try {
			int totalSeats = Integer.parseInt(request.getParameter("totalSeats"));
			int availableSeats = Integer.parseInt(request.getParameter("availableSeats"));
			int upperSeatPrice = Integer.parseInt(request.getParameter("upperSeatPrice"));
			int lowerSeatPrice = Integer.parseInt(request.getParameter("lowerSeatPrice"));
			MatchDetailsDTO matchDetailDto = new MatchDetailsDTO();
			matchDetailDto.setStadiumName(stadiumName);
			matchDetailDto.setMatchDate(matchDate);
			matchDetailDto.setTeam1(team1);
			matchDetailDto.setTeam2(team2);
			matchDetailDto.setAvailableSeats(availableSeats);
			matchDetailDto.setTotalSeats(totalSeats);
			matchDetailDto.setUpperSeatPrice(upperSeatPrice);
			matchDetailDto.setLowerSeatPrice(lowerSeatPrice);
			matchDetailDto.setImage(image);
			AdminService.addMatchDetails(matchDetailDto);
			String infoMessage = "Successfully stored";
			response.sendRedirect("addMatch.jsp?infoMessage=" + infoMessage);
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.sendRedirect("addMatch.jsp?errorMessage=" + errorMessage);
		}
	}

}
