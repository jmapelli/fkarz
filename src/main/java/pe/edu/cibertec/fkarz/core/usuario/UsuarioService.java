package pe.edu.cibertec.fkarz.core.usuario;

public class UsuarioService {

	private UsuarioRepository ur = null;

	public UsuarioEntity findByUsername(String username) {
		ur = new UsuarioRepository();

		return ur.findByUsername(username);
	}

}