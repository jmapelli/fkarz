package pe.edu.cibertec.fkarz.util;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

public class Error {

	private static final Logger LOG = Logger.getLogger(Error.class.getName());

	public static final String ERROR_STATUS_OK = "ok";

	public static void handler(HttpServletRequest req, Exception e) {
		req.setAttribute("error_status", ERROR_STATUS_OK);
		req.setAttribute("error_message", e.getMessage());
	}

}
