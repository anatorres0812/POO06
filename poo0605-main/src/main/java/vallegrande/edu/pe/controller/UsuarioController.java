package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Usuario;
import vallegrande.edu.pe.model.UsuarioDAO;

import java.util.List;

public class UsuarioController {

    private final UsuarioDAO dao = new UsuarioDAO();

    public List<Usuario> obtenerUsuarios() {

        return dao.listar();
    }

    public void insertarUsuario(Usuario u) {

        dao.insertar(u);
    }

    public void eliminarUsuario(int id) {

        dao.eliminar(id);
    }

    public void actualizarUsuario(Usuario u) {

        dao.actualizar(u);
    }
}