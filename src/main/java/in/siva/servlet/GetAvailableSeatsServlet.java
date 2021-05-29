package in.siva.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import in.siva.model.Seats;
import in.siva.service.AdminService;

/**
 * Servlet implementation class GetAvailableSeatsServlet
 */
@WebServlet("/GetAvailableSeatsServlet")
public class GetAvailableSeatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAvailableSeatsServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String stadiumName = request.getParameter("stadiumName");
		String matchDate = request.getParameter("date");
    	try {
			List<Seats> seats=AdminService.getAvailableseats(stadiumName,matchDate);
			Gson gson = new Gson();
			String json = gson.toJson(seats);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
	}


}
