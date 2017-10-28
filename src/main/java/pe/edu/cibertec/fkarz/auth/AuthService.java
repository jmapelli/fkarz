
package pe.edu.cibertec.fkarz.auth;

import pe.edu.cibertec.fkarz.usuario.UsuarioEntity;
import pe.edu.cibertec.fkarz.usuario.UsuarioService;

public class AuthService {

	public UsuarioEntity login(String username, String password) throws Exception {
		this.validateRequest(username, password);

		UsuarioService us = new UsuarioService();
		UsuarioEntity ue = us.findByUsername(username);

		this.validateUsername(ue);
		this.validatePassword(ue.getPassword(), password);

		return ue;
	}

	private void validateRequest(String username, String password) throws Exception {
		if (username == null && password == null) {
			throw new Exception("Los datos son invalidos");
		}
	}

	private void validateUsername(UsuarioEntity ue) throws Exception {
		if (ue == null) {
			throw new Exception("El usuario no existe");
		}
	}

	private void validatePassword(String saved_password, String requested_password) throws Exception {
		if (!saved_password.equals(requested_password)) {
			throw new Exception("La contraseña es incorrecta");
		}
	}

}
