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

@WebFilter(urlPatterns = { "/intranet/*" })
public class SessionFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		Boolean authenticated = (Boolean) req.getSession().getAttribute("authenticated");

		if (authenticated != null) {
			if (authenticated) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath() + "/auth");
			}
		} else {
			res.sendRedirect(req.getContextPath() + "/auth");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {		
	}

}
