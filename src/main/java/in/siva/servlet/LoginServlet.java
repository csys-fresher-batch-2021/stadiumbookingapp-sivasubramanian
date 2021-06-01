package in.siva.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.siva.exception.DbException;
import in.siva.exception.ValidationException;
import in.siva.service.UserManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			int userId = UserManager.login(userName, password);
			if (userId!=0) {
				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", userName);
				session.setAttribute("LOGGED_IN_USER_ID", userId);
				String infoMessage = "Login successfull";
				response.sendRedirect("matches.jsp?" + infoMessage);
			} else {
				String message = "Not registered";
				response.sendRedirect("login.jsp?errorMessage=" + message);
			}
		} catch (ValidationException | DbException e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.sendRedirect("login.jsp?errorMessage=" + errorMessage);

		}
	}

}
