package pe.edu.cibertec.fkarz.auth;

import pe.edu.cibertec.fkarz.core.usuario.UsuarioEntity;
import pe.edu.cibertec.fkarz.core.usuario.UsuarioService;
import pe.edu.cibertec.fkarz.util.Error;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {


    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private UsuarioService us = null;

    public static final String ACTION_LOGOUT = "logout";

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
        us = new UsuarioService();

        RequestDispatcher rd = null;

        if (req.getAttribute("error_status") != null && req.getAttribute("error_message") != null) {
            req.removeAttribute("error_status");
            req.removeAttribute("error_message");
        }

        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String redirect = req.getParameter("redirect");

            UsuarioEntity ue = us.login(username, password);

            HttpSession session = req.getSession();
            session.setAttribute("authenticated", true);
            session.setAttribute("usuario", ue);

            if (redirect != null && !redirect.isEmpty()) {
                res.sendRedirect(req.getContextPath() + redirect);
            } else {
            }

        } catch (Exception e) {
            Error.handler(req, e);

            rd = req.getRequestDispatcher("/template/auth/login.jsp");
            rd.forward(req, res);
        }
    }

}
