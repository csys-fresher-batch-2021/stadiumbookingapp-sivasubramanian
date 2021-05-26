package in.siva.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.siva.dto.UserDTO;
import in.siva.service.UserManager;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String mobileNo = request.getParameter("mobileNumber");
		try {
			UserDTO dto = new UserDTO(userName, password, mobileNo);
			boolean isRegistered = UserManager.register(dto);
			if (isRegistered) {
				String infoMessage = "Register successfull";
				response.sendRedirect("login.jsp?infoMessage=" + infoMessage);
			} else {
				String errorMessage = "Invalid credentials!";
				response.sendRedirect("register.jsp?errorMessage=" + errorMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.sendRedirect("register.jsp?errorMessage=" + errorMessage);
		}

	}

}
