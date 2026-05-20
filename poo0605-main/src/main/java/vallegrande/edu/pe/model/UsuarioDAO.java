package vallegrande.edu.pe.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // LISTAR
    public List<Usuario> listar() {

        List<Usuario> lista = new ArrayList<>();

        String sql = "SELECT * FROM usuario";

        try (
                Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Usuario u = new Usuario();

                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setTelefono(rs.getString("telefono"));
                u.setAsunto(rs.getString("asunto"));

                lista.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // INSERTAR
    public void insertar(Usuario u) {

        String sql = """
                INSERT INTO usuario
                (nombre, correo, telefono, asunto)
                VALUES (?, ?, ?, ?)
                """;

        try (
                Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getTelefono());
            ps.setString(4, u.getAsunto());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ELIMINAR
    public void eliminar(int id) {

        String sql = "DELETE FROM usuario WHERE id = ?";

        try (
                Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ACTUALIZAR
    public void actualizar(Usuario u) {

        String sql = """
                UPDATE usuario
                SET nombre=?, correo=?, telefono=?, asunto=?
                WHERE id=?
                """;

        try (
                Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getTelefono());
            ps.setString(4, u.getAsunto());
            ps.setInt(5, u.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}