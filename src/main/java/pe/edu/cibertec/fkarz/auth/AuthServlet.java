package pe.edu.cibertec.fkarz.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.edu.cibertec.fkarz.usuario.UsuarioEntity;

@WebServlet(urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {

	public static final String ACTION_LOGOUT = "logout";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String action = req.getParameter("action");
		if (action != null) {
			switch (action) {
			case ACTION_LOGOUT:
				req.getSession().invalidate();
				break;
			}
		}

		RequestDispatcher rd = req.getRequestDispatcher("/template/auth/login.jsp");
		rd.forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = null;

		if (req.getAttribute("error_status") != null && req.getAttribute("error_message") != null) {
			req.removeAttribute("error_status");
			req.removeAttribute("error_message");
		}

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		AuthService as = new AuthService();

		try {
			UsuarioEntity ue = as.login(username, password);

			HttpSession session = req.getSession();
			session.setAttribute("authenticated", true);
			session.setAttribute("usuario", ue);

			res.sendRedirect(req.getContextPath() + "/intranet");
		} catch (Exception e) {
			req.setAttribute("error_status", true);
			req.setAttribute("error_message", e.getMessage());

			rd = req.getRequestDispatcher("/template/auth/login.jsp");
			rd.forward(req, res);
		}
	}

}
