package in.siva.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import in.siva.model.MyBookings;
import in.siva.service.BookingManager;
import in.siva.util.LocalDateAdapter;

/**
 * Servlet implementation class DisplayMyBookingsServlet
 */
@WebServlet("/DisplayMyBookingsServlet")
public class DisplayMyBookingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayMyBookingsServlet() {
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

			Integer loggedInUserId = Integer.parseInt(request.getParameter("userId"));
			List<MyBookings> myBookings = BookingManager.getMyBookings(loggedInUserId);
			Gson gson=new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
			String json = gson.toJson(myBookings);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
