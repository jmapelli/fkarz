package pe.edu.cibertec.fkarz.auth;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/intranet/*", "/extranet/reservar/*" })
public class SessionFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		if (req.getSession().getAttribute("authenticated") != null) {
			chain.doFilter(request, response);
		} else {
			String redirect = req.getRequestURI();

			if (redirect != null) {
				redirect = redirect.substring(req.getContextPath().length());
				res.sendRedirect(req.getContextPath() + "/auth?redirect=" + redirect);
			} else {
				res.sendRedirect(req.getContextPath() + "/auth");
			}
		}
	}

	public void destroy() {
	}

}
