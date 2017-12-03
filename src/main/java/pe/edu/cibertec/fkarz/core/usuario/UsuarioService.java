package pe.edu.cibertec.fkarz.core.usuario;

public class UsuarioService {

    private UsuarioRepository ur = null;


    public UsuarioEntity findByUsername(String username) {
        ur = new UsuarioRepository();

        return ur.findByUsername(username);
    }

    public UsuarioEntity login(String username, String password) throws Exception {
        this.validateRequestLogin(username, password);

        UsuarioEntity ue = this.findByUsername(username);

        this.validateUsernameLogin(ue);
        this.validatePasswordLogin(ue.getPassword(), password);

        return ue;
    }

    private void validateRequestLogin(String username, String password) throws Exception {
        if (username.isEmpty() || password.isEmpty()) {
            throw new Exception("Los datos son invalidos");
        }
    }

    private void validateUsernameLogin(UsuarioEntity ue) throws Exception {
        if (ue == null) {
            throw new Exception("El usuario no existe");
        }
    }

    private void validatePasswordLogin(String saved_password, String requested_password) throws Exception {
        if (!saved_password.equals(requested_password)) {
            throw new Exception("La contraseña es incorrecta");
        }
    }

}
