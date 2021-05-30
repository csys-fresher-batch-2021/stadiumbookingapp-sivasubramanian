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

import in.siva.model.MatchDetail;
import in.siva.service.MatchManager;

/**
 * Servlet implementation class DisplayMatchServlet
 */
@WebServlet("/DisplayMatchServlet")
public class DisplayMatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayMatchServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<MatchDetail> matchList=MatchManager.getMatches();
			Gson gson = new Gson();
			String json = gson.toJson(matchList);
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
